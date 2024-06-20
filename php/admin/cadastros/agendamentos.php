<?php

    $nome = NULL;

    if (!empty($id)) {
        $sql = "select * from categoria where id = :id";
        $consulta = $pdo->prepare($sql);
        $consulta->bindParam(':id', $id);
        $consulta->execute();

        $dados = $consulta->fetch(PDO::FETCH_OBJ);

        $id = $dados->id ?? NULL;
        $nome = $dados->nome ?? NULL;
    }
?>

<div class="card">
    <div class="card-header">
        <h2 class="float-left">Agendamento de vacina</h2>
    </div>
    <div class="card-body">
        <form method="POST" action="salvar/pacientes">
            <div class="row">
                <div class="col-lg-5 col-md-6 col-sm-12">
                    <label for="nome">Nome do idoso</label>
                    <select class="form-control" required value="<?=$nome?>">
                        <option value="">teste</option>
                    </select>
                </div>
                
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="responsavel">Vacina</label>
                    <select name="vacina" id="vacina" class="form-control" required value="<?=$vacina?>">
                        <option value="">teste</option>
                    </select>
                </div>

            </div>

            <div class="row">
                <div class="col-lg-5 col-md-6 col-sm-12">
                    <label for="responsavel">Enfermeiro</label>
                    <select name="enfermeiro" id="enfermeiro" class="form-control" required value="<?=$enfermeiro?>">
                        <option value="">teste</option>
                    </select>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="data">data</label>
                    <input type="date" min="<?= date("Y-m-d");?>" name="enfermeiro" id="enfermeiro" class="form-control" required value="<?=$enfermeiro?>">
                </div>


                <div class="col-lg-12 col-md-12 col-sm-12 mb-3">
                    <label for="responsavel">Observações</label>
                    <textarea name="observacoes" id="observacoes" class="form-control" required value="<?=$observacoes?>"></textarea>
                </div>

            </div>

            <button type="submit" class="btn btn-success">
                Salvar Dados
            </button>
        </form>
    </div>
</div>