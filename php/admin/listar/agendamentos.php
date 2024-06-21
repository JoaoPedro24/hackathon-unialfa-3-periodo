<div class="card">
    <div class="card-header">
        <h2>Agendamentos</h2>
        <a href="./cadastros/agendamentos">
            <i class="fas fa-plus"></i> Novo agendamento
        </a>
    </div>
    <div class="card-body">
        <table class="table table-bordered table-hover table-striped">
            <thead>
                <tr>
                    <td>Idoso</td>
                    <td>Vacina</td>
                    <td>Enfermeiro</td>
                    <td>Data</td>
                    <td>Observações</td>
                </tr>
            </thead>
            <tbody>
                <?php
                    $sql = "select a.data, a.observacoes, i.nome as idoso, v.nome as vacina, e.nome as enfermeiro from agendamentos as a
                    join idosos as i on i.id = a.id_idoso
                    join vacinas as v on v.id = a.id_vacina
                    join enfermeiros as e on e.id = a.id_enfermeiro
                    where id_idoso = :id_idoso";
                    $consulta = $pdo->prepare($sql);
                    $consulta->bindParam(':id_idoso', $_SESSION["id_idoso"]);
                    $consulta->execute();
                    $dados = $consulta->fetchAll(PDO::FETCH_OBJ);
                    foreach($dados as $dado){
                ?>
                    <tr>
                        <td><?=$dado->idoso?></td>
                        <td><?=$dado->vacina?></td>
                        <td><?=$dado->enfermeiro?></td>
                        <td><?=$dado->data?></td>
                        <td><?=$dado->observacoes?></td>
                    </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</div>