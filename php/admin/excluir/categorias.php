<?php 

    $sql = 'select id from categoria where id = :id';
    $consulta = $pdo->prepare($sql);
    $consulta->bindParam(':id', $id);
    $consulta->execute();
    $categoria = $consulta->fetch(PDO::FETCH_OBJ);

    $retornarVazioDoBanco = empty($categoria->id);

    if($retornarVazioDoBanco) {
        mensagemErro("Não foi possível excluir esta categoria");
    }

    $sql = 'delete from categoria where id = :id';
    $consulta = $pdo->prepare($sql);
    $consulta->bindParam(':id', $id);
    if($consulta->execute()) {
        echo "<script>location.href='listar/categorias';</script>";
        exit;
    }

?>