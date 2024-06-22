<div id="wrapper">
    <ul class="navbar-nav sidebar sidebar-dark accordion" style="background-color: #11114e" id="accordionSidebar">
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <img src="images/logo.png" class="w-100" alt="Vitrine">
        </a>

        <?php if($_SESSION["id_idoso"] == "admin13608"){  ?>

        <hr class="sidebar-divider my-0">

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-tools"></i>
                <span>Admin</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="cadastros/idosos">
                        <i class="fas fa-user-friends"></i> Idosos
                    </a>
                    <a class="collapse-item" href="cadastros/responsaveis">
                        <i class="fas fa-user"></i> Responsaveis
                    </a>
                    <a class="collapse-item" href="cadastros/agendamentos">
                    <i class="fas fa-stethoscope"></i>
                        Agendamento
                    </a>
                </div>
            </div>
        </li>
        <?php } ?>
        <hr class="sidebar-divider my-0">

        <li class="nav-item active">
            <a class="nav-link" href="paginas/entrar">
                <i class="fas fa-home"></i> Página inicial
            </a>
        </li>

        <hr class="sidebar-divider">

        <li class="nav-item">
            <a class="nav-link" href="listar/agendamentos">
                <i class="far fa-calendar"></i> Agendamentos
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="listar/vacinas">
                <i class="fas fa-syringe"></i> Vacinas
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="listar/meu_cadastro">
                <i class="fas fa-user"></i></i> Meu cadastro
            </a>
        </li>
    </ul>

    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content" style="margin-top: 24px;">
            <div class="container-fluid">