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
    		
     <table id="tabela" class="display" width="1366px">
     		
     		<thead>
			    <tr>
					<th hidden>C�digo Turma</th>
				    <th>Nome da Turma</th>
				    <th></th>
		  		</tr>
			</thead>
			
			<tbody>
		  		<c:forEach items="${turmas}" var="turmas" varStatus ="row">
				
				    <tr>
			  			<td hidden>${turmas.codigoTurma}</td>
			  			<td>${turmas.nome}</td>
	
			  			<td><a href="visualizarNotasTurma?id=${turmas.codigoTurma}">Postar Notas da Turma</a></td>
		  			</tr>
		  		</c:forEach>
	  		</tbody>
		</table>

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