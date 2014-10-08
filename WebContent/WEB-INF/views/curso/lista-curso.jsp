<html>
<head>
	<title>Lista de Cursos</title>
	
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
			<a class="novoBotao" href="novoCurso">Novo Curso</a>
		</div> 
		
		<table id="tabela" class="display" width="1366px">
		
			<thead>
				<tr>
					<th>Id</th>
				    <th>Nome</th>
				    <th>Descrição</th>
				    <th>Especialidade 1</th>
				    <th>Especialidade 2</th>
				    <th>Especialidade 3</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</thead>
		   
		    <tfoot>
			    <tr>
					<th>Id</th>
				    <th>Nome</th>
				    <th>Descrição</th>
				    <th>Especialidade 1</th>
				    <th>Especialidade 2</th>
				    <th>Especialidade 3</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</tfoot>
			
			<tbody>
		  		<c:forEach items="${cursos}" var="curso" varStatus ="row">
				
				    <tr>
			  			<td>${curso.codigoCurso}</td>
			  			<td>${curso.nome}</td>
			  			<td>${curso.descricao}</td>
			  			<td>${curso.especialidade1}</td>
			  			<td>${curso.especialidade2}</td>
			  			<td>${curso.especialidade3}</td>
				        
			  			<td><a href="mostraCurso?id=${curso.codigoCurso}">Alterar</a></td>
						<td><a href="removeCurso?codigoCurso=${curso.codigoCurso}">Remover</a></td>
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
