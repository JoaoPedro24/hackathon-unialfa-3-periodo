<?php 
    $cep = $_POST["cep"] ?? null;

    if($cep){
        $sql = "select * from where cep = :cep";
        $consulta = $pdo->prepare($sql);
        $consulta->bindParam(":cep", $cep);
        $dados = $consulta->fetch(PDO::FETCH_ASSOC);
        if(empty($dados)){
            $json = file_get_contents("https://viacep.com.br/ws/$cep/json/");
            $data = json_decode($json, true);
            
            if(!isset($data['erro'])){
                $sql = "insert into (endereco cep, rua, bairro, localidade, uf) values (:cep, :rua, :bairro, :localidade, :uf)s";
                $consulta->prepare($sql);
                $consulta->bindParam(":cep", $cep);
                $consulta->bindParam(":rua", $dadod['logradouro']);
                $consulta->bindParam(":bairro",  $dados['bairro']);
                $consulta->bindParam(":localidade",  $dados['localidade']);
                $consulta->bindParam(":uf",  $dados['uf']);
                $consulta->execute();
            }
        }else{
            $errormessage = "CEP não encontrado";
            echo $errormessage;
            $data = null;
        }

        
    }

    ?>

<div class="card">
    <div class="card-header">
        <h2 class="float-left">Busca de CEP</h2> 
    </div>
    <div class="card-body">
    <form method="POST" action="listar/buscar_cep">
        <label for="cep">CEP</label>
        <div class="d-flex" style="gap: 16px;">
            <input type="text" name="cep" 
                id="cep" class="form-control" required value="<?=$cep?>" placeholder="Insira o CEP que deseja buscar">

            <button type="submit" class="btn btn-success">
                Buscar
            </button>
        </div>
    </form>
    
    <?php if (!empty($data)) {?>
        <div class="cep-listing">
            <h2>Resultado da busca:</h2>
            <div>
                <p>Logradouro: <?= $data['logradouro'] ?></p>
            </div>
            <div>
                <p>Bairro: <?= $data['bairro'] ?></p>
            </div>
            <div>
                <p>Localidade: <?= $data['localidade'] ?> - <?= $data['uf'] ?></p>
            </div>
            <div>
                <p>DDD: <?= $data['ddd'] ?></p>
            </div>
        </div>
    <?php }?>

    </div>
</div>
