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
        <h2 class="float-left">Cadastros de idosos</h2>
    </div>
    <div class="card-body">
        <form method="POST" action="salvar/pacientes">
            <div class="row">
                <div class="col-lg-2 col-md-5 col-sm-5">
                    <label for="id">ID do paciente</label>
                    <input type="text" name="id" id="id" class="form-control" readonly value="<?=$id?>">
                </div>
                <div class="col-lg-6 col-md-8 col-sm-12">
                    <label for="nome">Nome completo</label>
                    <input type="text" name="nome" id="nome" class="form-control" required value="<?=$nome?>">
                </div>
                
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <label for="cpf">CPF</label>
                    <input type="text" name="cpf" id="cpf" class="form-control" required value="<?=$cpf?>">
                </div>

            </div>

            <div class="row">
                <div class="col-lg-2 col-md-5 col-sm-5">
                    <label for="data_nasc">Data de nascimento</label>
                    <input type="text" name="data_nasc" id="data_nasc" class="form-control" required value="<?=$dataNasc?>">
                </div>

                <div class="col-lg-4 col-md-6 col-sm-12">
                    <label for="telefone">Telefone</label>
                    <input type="text" name="telefone" id="telefone" class="form-control" required value="<?=$telefone?>">
                </div>

                <div class="col-lg-6 col-md-6 col-sm-12">
                    <label for="responsavel">Responsável</label>
                    <select name="responsavel" id="responsavel" class="form-control" required value="<?=$responsavel?>">
                        <option value="">teste</option>
                    </select>
                </div>

            </div>

            <div class="row">

            <div class="col-lg-4 col-md-6 col-sm-12">
                    <label for="cep">CEP</label>
                    <input type="text" name="cep" id="cep" class="form-control" required value="<?=$cep?>">
                </div>

                <div class="col-lg-4 col-md-6 col-sm-12">
                    <label for="rua">Rua</label>
                    <input type="text" name="rua" id="rua" class="form-control" required value="<?=$rua?>">
                </div>

                <div class="col-lg-4 col-md-6 col-sm-12">
                    <label for="numero">Número</label>
                    <input type="text" name="numero" id="numero" class="form-control" required value="<?=$numero?>">
                </div>

            </div>

            <div class="row">

                <div class="col-lg-3 col-md-7 col-sm-12">
                    <label for="bairro">Bairro</label>
                    <input type="text" name="bairro" id="bairro" class="form-control" required value="<?=$bairro?>">
                </div>

                <div class="col-lg-4 col-md-6 col-sm-12">
                    <label for="complemento">Complemento</label>
                    <input type="text" name="complemento" id="complemento" class="form-control" required value="<?=$complemento?>">
                </div>

                <div class="col-lg-1 col-sm-9 col-sm-12">                    
                    <label for="uf">UF</label>
                    <input type="text" name="uf" id="uf" class="form-control" required value="<?=$uf?>">
                </div>

                <div class="col-lg-4 col-sm-6 col-sm-12 mb-3">
                    <label for="cidade">Cidade</label>
                    <input type="text" name="cidade" id="cidade" class="form-control" required value="<?=$cidade?>">
                </div>
            </div>

            <button type="submit" class="btn btn-success">
                Salvar Dados
            </button>
        </form>
    </div>
</div>