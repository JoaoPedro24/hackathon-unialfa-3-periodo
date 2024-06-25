<?php 
    $id_idoso = $_SESSION["id_idoso"];

    $json = file_get_contents($base_api_url . "idosos/$id_idoso");
    $idoso = json_decode($json, true);
    $id_reponsavel = $idoso["idoso"]["id_responsavel"];

    $json = file_get_contents($base_api_url . "responsaveis/$id_reponsavel");
    $responsavel = json_decode($json, true);
    $responsavel = $responsavel["responsavel"];
?>
<div class="card">
    <div class="card-header">
        <h2 class="float-left">Alterar cadastro do responsável</h2>
    </div>
    <div class="card-body">
        <form method="POST" action="salvar/cadastro_responsavel">
            <input type="hidden" name="id_responsavel" value="<?=$id_reponsavel?>">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="nome">Nome</label>
                    <input class="form-control" type="text" name="nome" id="nome" value="<?=$responsavel["nome"]?>" disabled>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="cpf">CPF</label>
                    <input name="cpf" type="text" id="cpf" class="form-control" value="<?=$responsavel["cpf"]?>" required disabled>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="telefone">Telefone</label>
                    <input name="telefone" type="text" id="telefone" class="form-control" required value="<?=$responsavel["telefone"]?>">
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="data_nascimento">Data de nascimento</label>
                    <input name="data_nascimento" type="date" value="<?=date('Y-m-d',strtotime($responsavel["data_nascimento"]))?>" id="data_nascimento" class="form-control" required>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="cep">CEP</label>
                    <input name="cep" type="text" id="cep" class="form-control" value="<?=$responsavel["cep"]?>" required>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="rua">Rua</label>
                    <input name="rua" type="text" id="rua" class="form-control" required value="<?=$responsavel["rua"]?>">
                </div>
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="bairro">Bairro</label>
                    <input name="bairro" type="text" value="<?=$responsavel["bairro"]?>" id="bairro" class="form-control" required>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="numero">Número</label>
                    <input name="numero" type="text" value="<?=$responsavel["numero"]?>" id="numero" class="form-control" required>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="complemento">Complemento</label>
                    <input name="complemento" type="text" id="complemento" class="form-control" value="<?=$responsavel["complemento"]?>">
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="uf">Estado</label>
                    <input name="uf" type="text" id="uf" class="form-control" required value="<?=$responsavel["uf"]?>">
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="cidade">Cidade</label>
                    <input name="cidade" type="text" value="<?=$responsavel["cidade"]?>" id="cidade" class="form-control" required>
                </div>
            </div>

            <div class="form-buttons mt-3">
                <button type="button" class="btn btn-outline-danger" onclick="location.href='listar/agendamentos'">
                    <i class="fas fa-times"></i> Cancelar
                </button>
                <button type="submit" class="btn btn-success">
                    <i class="fas fa-check"></i> Alterar
                </button>
            </div>
        </form>
    </div>
    <p style="margin: 0 0 8px 0; text-align: center; font-size: 18px">Para qualquer alteração em outros dados do responsável, entrar em contato com a secretaria</p>
</div>