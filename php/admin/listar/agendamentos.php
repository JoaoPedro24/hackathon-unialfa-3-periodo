<div class="card">
    <div class="card-header">
        <h2>Agendamentos</h2>
        <a href="./cadastros/agendamento_vacina">
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
                    $id_idoso = $_SESSION["id_idoso"];
                    $url = $base_api_url . "agendamentos/$id_idoso";
                    $json = file_get_contents($url);
                    $dados = json_decode($json, true);
                    foreach($dados["agendamentos"] as $dado){
                        $data = explode('T', $dado["data"]);
                ?>
                <tr>
                    <td><?=$dado["idoso"]?></td>
                    <td><?=$dado["vacina"]?></td>
                    <td><?=$dado["enfermeiro"]?></td>
                    <td><?=$data[0]?></td>
                    <td><?=$dado["observacoes"]?></td>
                </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</div>