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
		<div class="fundoTitulo">
    		<p class="tituloForm">Aluno - ${nomeAluno}</p>
    	</div>
		<div class="containerBotoesMeio">
			<a class="novoBotao" href="mostraAluno?id=${codigoAluno}">Voltar</a>
		</div> 
		
    	<br><br>
		<table id="tabela" class="display" width="1366px">
	
			<thead>
				<tr>
					<th>Aluno</th>
					<th>Turma</th>
					<th>Dia Matrícula</th>
					<th>Hora da Matrícula</th>
		  		</tr>
			</thead>
		   
		    <tfoot>
			    <tr>
					<th>Aluno</th>
					<th>Turma</th>
					<th>Dia Matrícula</th>
					<th>Hora da Matrícula</th>
		  		</tr>
			</tfoot>
			
			<tbody>
		  		<c:forEach items="${alunoTurma}" var="alunoTurma" varStatus ="row">
				    <tr>
				    	<td>${alunoTurma.nomeAluno}</td>
				   		<td>${alunoTurma.nomeTurma}</td>
						<td>${alunoTurma.diaMatricula}</td>
						<td>${alunoTurma.horaMatricula}</td>
		  			</tr>
		  		</c:forEach>
	  		</tbody>
		</table>
	</div>
</body>
</html>
<script>
	$(document).ready(function() {
  	    var table = $('#tabela').DataTable();
  	 
  	    $('#tabela tbody').on( 'click', 'tr', function () {
  	        if ( $(this).hasClass('selected') ) {
  	            $(this).removeClass('selected');
  	        }
  	        else {
  	            table.$('tr.selected').removeClass('selected');
  	            $(this).addClass('selected');
  	        }
  	    } );
  	 
  	    $('#button').click( function () {
  	        table.row('.selected').remove().draw( false );
  	    } );
  	} );
</script>
