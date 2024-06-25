<?php
    pegarProximosAgendamentos($base_api_url);
?>

<div class="card">
    <div class="card-header">
        <h2>Vacinas</h2>
    </div>
    <div class="card-body">
        <table class="table table-bordered table-hover table-striped">
            <thead>
                <tr>
                    <td>Nome</td>
                    <td>Prazo (meses)</td>
                    <td>Idade Mínima</td>
                </tr>
            </thead>
            <tbody>
                <?php
                    $url = $base_api_url . "vacinas";
                    $json = file_get_contents($url);
                    $dados = json_decode($json, true);
                    foreach($dados as $dado){
                ?>
                <tr>
                    <td><?=$dado[0]["nome"]?></td>
                    <td><?=$dado[0]["prazo"]?></td>
                    <td><?=$dado[0]["idade_minima"] ?? "<i>Sem idade mínima</i>"?></td>
                </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</div>