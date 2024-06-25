<?php
    function mensagemErro($msg) { ?>
        <script>
            Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: '<?=$msg?>',
            }).then((result) => {
                history.back(); 
            })
        </script>
        <?php
        exit;
    }

    function mensagemSucesso($msg) { ?>
        <script>
            Swal.fire({
            icon: 'success',
            title: 'Sucesso',
            text: '<?=$msg?>',
            }).then((result) => {
                location.href='listar/agendamentos'
            })
        </script>
        <?php
        exit;
    }

    function requisicaoPost($url, $dados) {
        $ch = curl_init();

        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $dados);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array(
            'Content-Type: application/json',
            'Content-Length: ' . strlen($dados))
        );

        $resultado = curl_exec($ch);
        curl_close($ch);

        if ($resultado === false) {
            mensagemErro("Ocorreu um erro, tente novamente mais tarde");
        }

        return $resultado;
    }

    function requisicaoPut($url, $dados) {
        $ch = curl_init();

        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
        curl_setopt($ch, CURLOPT_POSTFIELDS, $dados);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array(
            'Content-Type: application/json',
            'Content-Length: ' . strlen($dados))
        );

        $resultado = curl_exec($ch);
        curl_close($ch);

        if ($resultado === false) {
            mensagemErro("Ocorreu um erro, tente novamente mais tarde");
        }

        return $resultado;
    }

    function requisicaoDelete($url) {
        $ch = curl_init();

        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
        curl_setopt($ch, CURLOPT_FAILONERROR, true); // Fail if HTTP response code >= 400

        $resultado = curl_exec($ch);
        curl_close($ch);

        if ($resultado === false) {
            mensagemErro("Ocorreu um erro, tente novamente mais tarde");
        }

        return $resultado;
    }

    function pegarProximosAgendamentos($base_api_url ) {
        $id_idoso = $_SESSION["id_idoso"];
        $dataInicial = date('Y-m-d');
        $dataFinal = date('Y-m-d', strtotime('+45 days'));
    
        $url = $base_api_url . "agendamentos/$id_idoso?dataInicial=$dataInicial&dataFinal=$dataFinal";
        $json = file_get_contents($url);
        $agendamentosProximos45Dias = json_decode($json, true);
        $agendamentosProximos45Dias = count($agendamentosProximos45Dias["agendamentos"]);
    
        if ($agendamentosProximos45Dias > 0) {
            echo "
            <script>
                toastr.options = {
                    'closeButton': true,
                    'debug': false,
                    'newestOnTop': true,
                    'progressBar': true,
                    'positionClass': 'toast-top-right',
                    'preventDuplicates': true,
                    'onclick': null,
                    'showDuration': '300',
                    'hideDuration': '1000',
                    'timeOut': '5000',
                    'extendedTimeOut': '1000',
                    'showEasing': 'swing',
                    'hideEasing': 'linear',
                    'showMethod': 'fadeIn',
                    'hideMethod': 'fadeOut'
                }
                toastr['error']('Você tem <b>$agendamentosProximos45Dias</b> agendamentos para os próximos <b>45 dias</b>', 'ATENÇÃO')
            </script>";
        }
    }