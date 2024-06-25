<?php
    $id_idoso = $_SESSION["id_idoso"];
    $id_vacina = $_POST["id_vacina"] ?? NULL;
    $id_enfermeiro = $_POST["id_enfermeiro"] ?? NULL;
    $data = $_POST["data"] ?? NULL;
    $observacoes = $_POST["observacoes"] ?? NULL;

    if (!isset($_POST["editar"])) {
        $agendamento = file_get_contents($base_api_url . "agendamentos/enfermeiro/$id_enfermeiro?data=$data");
        $agendamento = json_decode($agendamento);
    
        if (count($agendamento->agendamento) != 0) {
            mensagemErro("Enfermeiro ocupado nessa data");
        }
    }

    $dados = json_encode([
        "id_idoso" => intval($id_idoso),
        "id_enfermeiro" => intval($id_enfermeiro),
        "id_vacina" => intval($id_vacina),
        "data" => $data,
        "observacoes" => $observacoes
    ]);

    $agendamento = requisicaoPost($base_api_url . "agendamentos", $dados);
    mensagemSucesso("Agendamento marcado com sucesso!");
