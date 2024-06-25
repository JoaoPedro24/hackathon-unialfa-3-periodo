<?php
    $json = file_get_contents($base_api_url . "agendamentos/ag/$id");
    $agendamento = json_decode($json, true);
    $agendamento = $agendamento["agendamento"];
?>

<div class="card">
    <div class="card-header">
        <h2 class="float-left">Agendamento de vacina</h2>
    </div>
    <div class="card-body">
        <form method="POST" action="salvar/agendamento_vacina">
            <input type="hidden" name="editar" value="sim">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="nome">Idoso</label>
                    <select name="id_idoso" class="form-control" required readonly>
                        <option value="<?=$agendamento["id_idoso"]?>" selected><?=$agendamento["idoso"]?></option>
                    </select>
                </div>
                
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="responsavel">Vacinas</label>
                    <select name="id_vacina" id="vacina" class="form-control" required readonly>
                        <option value="<?=$agendamento["id_vacina"]?>" selected><?=$agendamento["vacina"]?></option>
                    </select>
                </div>

            </div>

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="responsavel">Enfermeiros</label>
                    <select name="id_enfermeiro" id="enfermeiro" class="form-control" required readonly>
                        <option value="<?=$agendamento["id_enfermeiro"]?>" selected><?=$agendamento["enfermeiro"]?></option>
                    </select>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="data">Data</label>
                    <input name="data" type="date" value="<?=date('Y-m-d',strtotime($agendamento["data"]))?>" id="data" class="form-control" required readonly>
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

    <p style="margin: 0 0 8px 0; text-align: center; font-size: 18px">Para qualquer alteração em algum dos agendamentos entrar em contato com a secretaria</p>

</div>