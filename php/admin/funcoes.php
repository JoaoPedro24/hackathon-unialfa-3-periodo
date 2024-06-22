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