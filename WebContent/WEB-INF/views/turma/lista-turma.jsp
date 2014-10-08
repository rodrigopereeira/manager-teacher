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
			<a class="novoBotao" href="novaTurma">Nova turma</a>
		</div> 
		
		<table id="tabela" class="display" width="1366px">
		
			<thead>
			    <tr>
					<th>Id</th>
				    <th>Curso</th>
				    <th>Professor</th>
				    <th>Sala</th>
				    <th>Hora Inicio</th>
				    <th>Dia</th>
				    <th>Data Inicio</th>
				    <th>Data Termino</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</thead>
			    
			<tfoot>
			   <tr>
					<th>Id</th>
				    <th>Curso</th>
				    <th>Professor</th>
				    <th>Sala</th>
				    <th>Hora Inicio</th>
				    <th>Dia</th>
				    <th>Data Inicio</th>
				    <th>Data Termino</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</tfoot>
		
			<tbody>
		  		<c:forEach items="${turmas}" var="turma" varStatus ="row">

				    <tr>
			  			<td>${turma.codigoTurma}</td>
			  			<td>${turma.nomeCurso}</td>
			  			<td>${turma.nomeProfessor}</td>
			  			<td>${turma.nomeSala}</td>
			  			<td>${turma.horaInicio}</td>
			  			<td>${turma.dia}</td>
						<td>${turma.dataInicio}</td>
						
						<td>${turma.dataTermino}</td>
			  			<td><a href="mostraTurma?id=${turma.codigoTurma}">Alterar</a></td>
						<td><a href="removeTurma?codigoTurma=${turma.codigoTurma}">Remover</a></td>
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

