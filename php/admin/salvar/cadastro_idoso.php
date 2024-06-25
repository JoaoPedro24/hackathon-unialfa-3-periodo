<?php
    $id_idoso = $_SESSION["id_idoso"];
    $telefone = $_POST["telefone"] ?? NULL;
    $data_nascimento = $_POST["data_nascimento"] ?? NULL;
    $cep = $_POST["cep"] ?? NULL;
    $rua = $_POST["rua"] ?? NULL;
    $bairro = $_POST["bairro"] ?? NULL;
    $numero = $_POST["numero"] ?? NULL;
    $complemento = $_POST["complemento"] ?? NULL;
    $uf = $_POST["uf"] ?? NULL;
    $cidade = $_POST["cidade"] ?? NULL;

    $dados = json_encode([
        "telefone" => $telefone,
        "data_nascimento" => $data_nascimento,
        "cep" => $cep,
        "rua" => $rua,
        "bairro" => $bairro,
        "numero" => intval($numero),
        "complemento" => $complemento,
        "uf" => $uf,
        "cidade" => $cidade
    ]);

    $idoso = requisicaoPut($base_api_url . "idosos/$id_idoso", $dados);
    mensagemSucesso("Cadastro alterado com sucesso!");
