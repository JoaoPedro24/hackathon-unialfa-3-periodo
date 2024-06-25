<?php
    pegarProximosAgendamentos($base_api_url);
?>

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
                    <td style="text-align:center">Opções</td>
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
                    <td><b><?=$dado["vacina"]?></b></td>
                    <td><?=$dado["enfermeiro"]?></td>
                    <td><b><?=date('d/m/Y', strtotime($data[0]))?></b></td>
                    <td><?=$dado["observacoes"]?></td>
                    <td style="text-align: center">
                        <?='<span class="edit-button" style="color: #11114e" onclick="editar(' . $dado["id"] . ')"><i class="fas fa-edit" style="color: #11114e"></i></span>'?>
                        <?='<span class="delete-button" style="color: #ff6961" onclick="confirmarExclusao(' . $dado["id"] . ')"><i style="color: #ff6961" class="fas fa-trash"></i></span>'?>
                    </td>
                </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</div>

<script>
    function confirmarExclusao(id) {
        Swal.fire({
            title: 'Tem certeza que deseja deletar o registro?',
            text: "Não será possível restaurar",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Confirmar',
            cancelButtonText: 'Cancelar',
        }).then((result) => {
            if (result.isConfirmed) {
                location.href='excluir/agendamentos/' + id
            }
        });
    }

    function editar(id) {
        location.href='editar/agendamento/' + id
    }
</script>