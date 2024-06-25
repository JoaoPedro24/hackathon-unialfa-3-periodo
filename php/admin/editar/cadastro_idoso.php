<?php 
    $id_idoso = $_SESSION["id_idoso"];

    $json = file_get_contents($base_api_url . "idosos/$id_idoso");
    $idoso = json_decode($json, true);
    $idoso = $idoso["idoso"];
?>
<div class="card">
    <div class="card-header">
        <h2 class="float-left">Alterar meu cadastro</h2>
    </div>
    <div class="card-body">
        <form method="POST" action="salvar/cadastro_idoso">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="nome">Nome</label>
                    <input class="form-control" type="text" name="nome" id="nome" value="<?=$idoso["nome"]?>" disabled>
                </div>
                
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="responsavel">Nome do responsável</label>
                    <input class="form-control" type="text" name="nome_responsavel" id="nome_responsavel" value="<?=$idoso["nome_responsavel"]?>" disabled>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="cpf">CPF</label>
                    <input name="cpf" type="text" id="cpf" class="form-control" value="<?=$idoso["cpf"]?>" required disabled>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="telefone">Telefone</label>
                    <input name="telefone" type="text" id="telefone" class="form-control" required value="<?=$idoso["telefone"]?>">
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="data_nascimento">Data de nascimento</label>
                    <input name="data_nascimento" type="date" value="<?=date('Y-m-d',strtotime($idoso["data_nascimento"]))?>" id="data_nascimento" class="form-control" required>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="cep">CEP</label>
                    <input name="cep" type="text" id="cep" class="form-control" value="<?=$idoso["cep"]?>" required>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="rua">Rua</label>
                    <input name="rua" type="text" id="rua" class="form-control" required value="<?=$idoso["rua"]?>">
                </div>
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="bairro">Bairro</label>
                    <input name="bairro" type="text" value="<?=$idoso["bairro"]?>" id="bairro" class="form-control" required>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <label for="numero">Número</label>
                    <input name="numero" type="text" value="<?=$idoso["numero"]?>" id="numero" class="form-control" required>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="complemento">Complemento</label>
                    <input name="complemento" type="text" id="complemento" class="form-control" value="<?=$idoso["complemento"]?>">
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="uf">Estado</label>
                    <input name="uf" type="text" id="uf" class="form-control" required value="<?=$idoso["uf"]?>">
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <label for="cidade">Cidade</label>
                    <input name="cidade" type="text" value="<?=$idoso["cidade"]?>" id="cidade" class="form-control" required>
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
</div>