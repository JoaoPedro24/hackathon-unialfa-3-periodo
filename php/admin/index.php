<?php
    require "../config.php";
    session_start();
    date_default_timezone_set('America/Sao_Paulo');
    $base_api_url = "http://localhost:3001/";

    $id_idoso = $_POST["id_idoso"] ?? null;
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SAV - Sistema de Agendamento de Vacinação</title>
    <base href="<?php echo "http://" . $_SERVER["HTTP_HOST"] . $_SERVER["SCRIPT_NAME"]; ?>">

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>

    <script src="js/lightbox-plus-jquery.min.js"></script>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script type="text/javascript" src="vendor/summernote/summernote.min.js"></script>
    <script type="text/javascript" src="vendor/summernote/summernote-bs4.min.js"></script>
    <script src="vendor/summernote/lang/summernote-pt-BR.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    
    <!-- Outros Javascript -->
    <script src="js/parsley.min.js"></script>
    
    <script src="js/jquery.inputmask.min.js"></script>
    <script src="js/bindings/inputmask.binding.js"></script>
    <script src="js/jquery.maskMoney.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
    <script src="js/sweetalert2.min.js"></script>
    <script src="js/toastr/toastr.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" integrity="sha512-pHVGpX7F/27yZ0ISY+VVjyULApbDlD0/X0rgGbTqCE7WFW5MezNTWG/dnhtbBuICzsd0WQPgpE4REBLv+UqChw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/lightbox.min.css">

    <link rel="stylesheet" type="text/css" href="vendor/summernote/summernote.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/summernote/summernote-bs4.min.css">
    <link rel="stylesheet" href="css/sweetalert2.min.css"></script>
    <link rel="stylesheet" href="js/toastr/toastr.css">

</head>
<body id="page-top">
    <?php
        require "funcoes.php";

        if (isset($_GET['param'])) {
            $page = explode("/", $_GET['param']);
            
            $dir = $page[0] ?? null;
            $arquivo = $page[1] ?? null;
            $id = $page[2] ?? null;

            $page = "$dir/$arquivo";

            if (!str_contains($page, "entrar")) {
                require "header.php";
    
                if (file_exists("$page.php")){
                    require "$page.php";
                }else {
                    require "paginas/erro.php";
                }
    
                // require "footer.php";
            } else {
                require "$page.php"; 
            }
        }
    ?>

    <script>
        $('#telefone').mask('(99) 99999-9999')
        $('#cpf').mask('999.999.999-99')
        $('#cep').mask('99999-999')

        $('.register-button').click(function (e) {
            Swal.fire({
                icon: 'warning',
                title: 'Para um novo cadastro entre em contato com a secretaria',
                html: "<a href='https://wa.me/5544997132502' target='_blank' style='color:#545454;text-underline:none'><i class='fab fa-whatsapp' style='color:#25d366'></i> <b>(44) 99713-2502</b></a> <br> \
                <i class='fas fa-phone-alt'></i> <b>(44) 3622-0681</b>",
                confirmButtonText: 'Confirmar'
            })
        })

        $('.btn-acessibilidade').click(function (e) {
            Swal.fire({
                icon: 'warning',
                title: 'Acessibilidade',
                text: 'Implementação futura',
                confirmButtonText: 'Confirmar'
            })
        })
    </script>
</body>
</html>