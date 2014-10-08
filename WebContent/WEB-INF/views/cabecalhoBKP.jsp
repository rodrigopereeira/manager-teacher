<head>
<title>Mantea - Inicio</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="resources/css/estiloHeader.css" type="text/css" rel="stylesheet"/>
<link rel="shortcut icon" href="resources/css/favicon.png" width="24" height="24">
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="topo">
    <div class="colunaLogo">
        <img src="resources/css/logo.png" height="60" alt="Logomarca MRNeT" />
    </div>
    <div class="colunaUsuario">
        <div class=" linhaUsuario">

        <jsp:useBean id="date" class="java.util.Date"/>

		<fmt:formatDate var="time" value="${date}" pattern="HH"/>
		<c:choose>
		     <c:when test="${time > 18}">
		       Boa Noite, 
		    </c:when>
		    <c:when test="${time < 05}">
		       Boa Noite, 
		    </c:when>
		    <c:when test="${time > 12}">
		        Boa Tarde, 
		    </c:when>
			<c:otherwise>
		        Bom Dia, 
		    </c:otherwise>
		</c:choose>
		${usuarioLogado.nome}
        </div>
    </div>
</div>
<nav>
  <ul class="menu">
        <li><a href="inicio">Inicio</a></li>
        <li><a href="#">Cadastros</a>
            <ul>
                <li><a href="listaSecretarias">Secretaria</a></li>
                <li><a href="listaProfessores">Professor</a></li>
                <li><a href="listaAlunos">Aluno</a></li>
                <li><a href="listaCursos">Curso</a>
                	<ul>
                		<li><a href="#">Turma</a>
                	</ul>
                </li>                
            </ul>
        </li>
        <li><a href="#">Matriculas</a>
            <ul> 
                <li><a href="#">Aluno</a></li>
            </ul>
        </li>
        <li><a href="#">Turmas</a>
        	<ul>
        		<li><a href="#">Postar Documento</a></li>
				<li><a href="#">Cadastrar Notas</a></li>
				<li><a href="#">Controle de Presen�a</a></li>
        	</ul>
        </li>  
        <li><a href="logout">Sair</a></li>             
</ul>
</nav>
</body>
