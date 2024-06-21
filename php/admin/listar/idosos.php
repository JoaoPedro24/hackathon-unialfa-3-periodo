<div class="card">
    <div class="card-body">
        <table class="table table-bordered table-hover table-striped">
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Nome</td>
                    <td>CPF</td>
                    <td>Telefone</td>
                    <td>DN</td>
                    <td>Responsável</td>
                    <td>CEP</td>
                    <td>Rua</td>
                    <td>Bairro</td>
                    <td>Número</td>
                    <td>Complemento</td>
                    <td>UF</td>
                    <td>Cidade</td>
                </tr>
            </thead>
            <tbody>
                <?php
                    $sql = "select i.*, r.nome as responsavel
                            from idosos as i
                            join responsaveis as r on r.id = i.id_responsavel
                            where i.id = :id";
                    $consulta = $pdo->prepare($sql);
                    $consulta->bindParam(':id_idoso', $_SESSION["id_idoso"]);
                    $consulta->execute();
                    $dados = $consulta->fetchAll(PDO::FETCH_OBJ);
                    foreach($dados as $dado){
                ?>
                    <tr>
                        <td><?=$dado->nome?></td>
                        <td><?=$dado->cpf?></td>
                        <td><?=$dado->telefone?></td>
                        <td><?=$dado->data_nascimento?></td>
                        <td><?=$dado->nome?></td>
                        <td><?=$dado->cep?></td>
                        <td><?=$dado->rua?></td>
                        <td><?=$dado->bairro?></td>
                        <td><?=$dado->numero?></td>
                        <td><?=$dado->complemento?></td>
                        <td><?=$dado->uf?></td>
                        <td><?=$dado->cidade?></td>
                    </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</div>