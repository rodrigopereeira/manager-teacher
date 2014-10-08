<html>
<head>
	<title>Lista de Salas</title>
	
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
			<a class="novoBotao" href="novaSala">Nova sala</a>
		</div> 
		
		<table id="tabela" class="display" width="1366px">
		
			<thead>
			    <tr>
					<th>Id</th>
				    <th>Número da Sala</th>
				    <th>Nome</th>
				    <th>Capacidade</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</thead>
			
			<tfoot>
			   <tr>
					<th>Id</th>
				    <th>Número da Sala</th>
				    <th>Nome</th>
				    <th>Capacidade</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</tfoot>
			
			<tbody>
		  		<c:forEach items="${salas}" var="sala" varStatus ="row">
				
				    <tr>
			  			<td>${sala.codigoSala}</td>
			  			<td>${sala.numeroSala}</td>
			  			<td>${sala.nome}</td>
			  			<td>${sala.capacidade}</td>
			  			
			  			<td><a href="mostraSala?id=${sala.codigoSala}">Alterar</a></td>
						<td><a href="removeSala?codigoSala=${sala.codigoSala}">Remover</a></td>
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

