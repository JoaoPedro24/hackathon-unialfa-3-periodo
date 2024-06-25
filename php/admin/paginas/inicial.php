<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>SAV - Sistema de Agendamento de Vacina</title>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #11114e;">
          <div class="container" style="display:flex;align-items:center">
            <img src="../images/logo.png" style="width:200px;" alt="SAV">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup" >
              <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="#agendamento"  style="color:white;">Agende sua vacina</a>
                <a class="nav-link" href="#beneficios" style="color:white;">Beneficios da vacina</a>
                <a class="nav-link" href="#efeitos" style="color:white;">Efeitos colaterais</a>
              </div>
            </div>
          </div>
        </nav>
    </header>

    <div style="display: flex; justify-content:center; align-items:center; flex-direction: column;margin-bottom: 32px;" id="agendamento">
      <h1 class="mt-5">Seja bem-vindo ao <b>SAV - Sistema de Agendamento de Vacina</b>!</h1>
      <a href="../paginas/entrar" class="btn btn-inicial mt-3">Registre-se que aqui</a>    
    </div>

    <div class="container" id="beneficios">
      <h2 style="color:#11114e;border-bottom: 1px dotted #999999; padding-bottom: 8px; margin-bottom:16px"><b>Benefícios da Vacinação</b></h2>
      <p>A vacinação é uma das medidas mais eficazes para proteger indivíduos contra doenças infecciosas. Aqui estão alguns dos principais benefícios:</p>
      <ul>
          <li><strong>Prevenção de doenças:</strong> Vacinas ajudam a prevenir doenças graves como sarampo, rubéola, poliomielite e muitas outras.</li>
          <li><strong>Proteção coletiva:</strong> A imunização em massa reduz a propagação de doenças, protegendo não apenas os vacinados, mas também pessoas vulneráveis que não podem ser vacinadas.</li>
          <li><strong>Redução de complicações:</strong> Vacinas podem diminuir as chances de complicações graves e hospitalizações relacionadas a doenças infecciosas.</li>
          <li><strong>Segurança comprovada:</strong> As vacinas são rigorosamente testadas quanto à segurança e eficácia antes de serem aprovadas para uso público.</li>
          <li><strong>Contribuição para a erradicação de doenças:</strong> Programas de vacinação bem-sucedidos têm ajudado a erradicar ou controlar doenças em muitas partes do mundo.</li>
      </ul>
      <p>Em resumo, a vacinação não só protege indivíduos contra doenças, mas também desempenha um papel crucial na saúde pública global. Consulte sempre um profissional de saúde para orientação específica sobre vacinas.</p>
    </div>

    <div class="container" id="vacinas">
        <h2 style="color:#11114e;border-bottom: 1px dotted #999999; padding-bottom: 8px; margin-bottom:16px"><b>A vacina pode causa efeito colateral?</b></h2>
        <p style="font-size: 16px"><b>Sim</b>, como qualquer medicamento, a vacina pode apresentar efeitos colaterais</p>
        <p style="margin: 8px 0;">Os mais comuns são:</p>
        <ul>
          <li>Febre</li>
          <li>Dor</li>
          <li>Vermelhidão</li>
          <li>Inchaço no local da aplicação</li>
        </ul>
        <p style="font-size: 16px;margin: 8px 0;color:#11114e"><b>O que devo fazer?</b></p>
        <ul>
          <li>Coloque apenas compressas frias no local da aplicação</li>
          <li>Não coloque compressas quentes</li>
          <li>Não aplique cremes ou pomadas</li>
          <li>Não aplique curativos</li>
          <li>Não coçe o local</li>
        </ul>
        <p><b>Caso apresente nos 7 primeiros dias após a vacinação sintomas de alergia, náuseas, vômitos, diarreia, fraqueza, formigamentos, sintomas de covid-19 (febre, dor de garganta, coriza, falta de ar), procure um posto de saúde</b></p>
    </div>

    <div style="display: flex; justify-content:center; align-items:center; flex-direction: column;margin-bottom: 32px;" id="agendamento">
      <a href="../paginas/entrar" class="btn btn-inicial mt-3">Registre-se que aqui</a>    
    </div>
</body>
</html>