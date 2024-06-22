<?php
    $id_idoso = $_SESSION["id_idoso"];
    $id_vacina = $_POST["id_vacina"] ?? NULL;
    $id_enfermeiro = $_POST["id_enfermeiro"] ?? NULL;
    $data = $_POST["data"] ?? NULL;
    $observacoes = $_POST["observacoes"] ?? NULL;

    $agendamento = file_get_contents($base_api_url . "agendamentos/enfermeiro/$id_enfermeiro?data=$data");
    $agendamento = json_decode($agendamento);

    if (count($agendamento->agendamento) != 0) {
        mensagemErro("Enfermeiro ocupado nessa data");
    }

    $dados = json_encode([
        "id_idoso" => intval($id_idoso),
        "id_enfermeiro" => intval($id_enfermeiro),
        "id_vacina" => intval($id_vacina),
        "data" => $data,
        "observacoes" => $observacoes
    ]);

    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL, $base_api_url . "agendamentos");
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $dados);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json',
        'Content-Length: ' . strlen($dados))
    );

    $resultado = curl_exec($ch);
    curl_close($ch);

    if ($resultado === false) {
        mensagemErro("Ocorreu um erro, tente novamente mais tarde");
    }

    mensagemSucesso("Agendamento marcado com sucesso!");
