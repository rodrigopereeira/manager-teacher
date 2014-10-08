<html>
<head>
	<title>Lista de Professores Ocupados</title>
	
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
		
		<table id="tabela" class="display" width="1366px">

			<thead>
			    <tr>
				    <th>Professor</th>
				    <th>Turma</th>
				    <th>Dia</th>
				    <th>Data de Inicio</th>
				    <th>Data de Termino</th>
				    <th>Hora de Inicio</th>
				    <th>Hora de Termino</th>
		  		</tr>
			</thead>
			
			<tbody>
		  		<c:forEach items="${professoresOcupados}" var="professoresOcupados" varStatus ="row">

				    <tr>
			  			<td>${professoresOcupados.nomeProfessor}</td>
			  			<td>${professoresOcupados.nomeTurma}</td>
			  			<td>${professoresOcupados.dia}</td>
			  			<td>${professoresOcupados.dataInicial}</td>
			  			<td>${professoresOcupados.dataTermino}</td>
			  			<td>${professoresOcupados.horaInicio}</td>
			  			<td>${professoresOcupados.horaTermino}</td>
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