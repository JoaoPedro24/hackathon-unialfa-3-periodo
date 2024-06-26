<?php
    $id_idoso = $_POST["id_idoso"] ?? null;

    if (isset($id_idoso)) {
        $_SESSION["id_idoso"] = $id_idoso;

        $json = file_get_contents("http://localhost:3001/idosos/$id_idoso");
        $idoso = json_decode($json, true);
        $idoso = $idoso["idoso"] ?? null;

        if ($idoso) {
            echo "<script>location.href='listar/agendamentos'</script>";
        }

        mensagemErro('Nenhum idoso encontrado com esse código!');
    }

?>

<div class="selecione-codigo container w-50">
    <img src="images/logo1.png" alt="Logo SAV preta">
    <h3 for="id_idoso">Digite o seu código de paciente</h3>
    <form class="w-50" method="POST" action="">
        <input class="form-control" type="text" name="id_idoso" id="id_idoso" placeholder="Informe seu código" required>
        <button class="mt-2 mb-3 w-100 btn btn-primary" type="submit">Entrar</button>
        <span class="register-button">Cadastre-se</span>
    </form>
</div>