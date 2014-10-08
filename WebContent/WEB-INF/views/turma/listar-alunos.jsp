<html>
<head>
	<title>Lista de Turmas</title>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="resources/media/css/jquery.dataTables.css">
	  
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.js"></script>
	  
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.dataTables.js"></script>
	
</head>
<body>	

	<c:import url="../menu.jsp" />
	
	<div class="containerConteudoMeio">
		<div class="containerBotoesMeio">
			<a class="novoBotao" href="mostrarTurma">Voltar</a>
		</div> 
		<div class="fundoTitulo">
    		<p class="tituloForm">Turma - ${nomeTurma}</p>
    	</div>
    	
		<table id="tabela" class="display" width="1366px">

			<thead>
			    <tr>
					<th>Código Matricula</th>
					<th>Alunos</th>
		  		</tr>
			</thead>
			
			<tbody>
		  		<c:forEach items="${turmasAlunos}" var="turma" varStatus ="row">

				    <tr>
				   		<td>${turma.codigoAluno}</td>
			  			<td>${turma.nomeAluno}</td>
						
		  			</tr>
		  		</c:forEach>
	  		</tbody>
		</table>
	</div>
</body>
</html>
<script>
$(document).ready(function() {
    $('#tabela').dataTable( {
        "paging":   false,
        "ordering": false,
        "info":     false,
        "searching":     false
    } );
} );
</script>
