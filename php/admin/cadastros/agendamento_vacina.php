<?php
    $id_idoso = $_SESSION["id_idoso"];

    $json = file_get_contents($base_api_url . "idosos/$id_idoso");
    $idoso = json_decode($json, true);
    $idoso = $idoso["idoso"];

    $json = file_get_contents($base_api_url . "vacinas");
    $vacinas = json_decode($json, true);
    $vacinas = $vacinas["vacinas"];

    $json = file_get_contents($base_api_url . "enfermeiros");
    $enfermeiros = json_decode($json, true);
    $enfermeiros = $enfermeiros["enfermeiros"]
?>

<div class="card">
    <div class="card-header">
        <h2 class="float-left">Agendamento de vacina</h2>
    </div>
    <div class="card-body">
        <form method="POST" action="salvar/agendamento_vacina">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="nome">Idoso</label>
                    <select name="id_idoso" class="form-control" required disabled>
                        <option value="<?=$idoso["id"]?>" selected><?=$idoso["nome"]?></option>
                    </select>
                </div>
                
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="responsavel">Vacinas</label>
                    <select name="id_vacina" id="vacina" class="form-control" required>
                        <?php foreach ($vacinas as $vacina) {?>
                            <option value="<?=$vacina["id"]?>"><?=$vacina["nome"]?></option>
                        <?php } ?>
                    </select>
                </div>

            </div>

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="responsavel">Enfermeiros</label>
                    <select name="id_enfermeiro" id="enfermeiro" class="form-control" required>
                        <?php foreach ($enfermeiros as $enfermeiro) {?>
                            <option value="<?=$enfermeiro["id"]?>"><?=$enfermeiro["nome"]?></option>
                        <?php } ?>
                    </select>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="data">Data</label>
                    <input name="data" type="date" min="<?= date("Y-m-d");?>" id="data" class="form-control" required>
                </div>


                <div class="col-lg-12 col-md-12 col-sm-12">
                    <label for="observacoes">Observações</label>
                    <textarea name="observacoes" id="observacoes" class="form-control" style="resize: none;"></textarea>
                </div>

            </div>

            <div class="form-buttons mt-3">
                <button type="button" class="btn btn-outline-danger" onclick="location.href='listar/agendamentos'">
                    <i class="fas fa-times"></i> Cancelar
                </button>
                <button type="submit" class="btn btn-success">
                    <i class="fas fa-check"></i> Agendar
                </button>
            </div>
        </form>
    </div>
</div>