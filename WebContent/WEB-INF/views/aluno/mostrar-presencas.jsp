<html>
  <head>
  	<title>Matricula de Aluno</title>

  	
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  	
	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="resources/media/css/jquery.dataTables.css">
	  
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.js"></script>
	  
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.dataTables.js"></script>
  </head>
  <body>
	<c:import url="../menu.jsp" />
		
		<div class="improvisado">
			<div class="containerBotoesMeio">
				<a class="novoBotao" href="presencas">Voltar</a>
			</div> 
		</div>
		
    		<table id="tabela" class="display" cellspacing="0" width="100%">
				
				 <thead>
			        <tr>
					    <th>Data</th>
					    <th>Presença</th>
			  		</tr>
			    </thead>
			    
			    <tfoot>
			        <tr>
			            <th>Data</th>
					    <th>Presença</th>
			        </tr>
			    </tfoot>
				
				<tbody>
			  		<c:forEach items="${presencas}" var="presencas" varStatus ="row">

					    <tr>
				  			<td>${presencas.data}</td>
				  			<td>${presencas.presenca}</td>
			  			</tr>
			  		
			  		</c:forEach>
		  		</tbody>
			</table>
  </body>
</html>
<script>
$(document).ready(function() {
    $('#tabela').dataTable( {
        "ordering": false
    } );
} );
</script>