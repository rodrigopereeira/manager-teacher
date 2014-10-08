<html>
<head>
	<title>Lista de Salas Ocupadas</title>
	
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
				    <th>Sala</th>
				    <th>Turma</th>
				    <th>Dia</th>
				    <th>Data de Inicio</th>
				    <th>Data de Termino</th>
				    <th>Hora de Inicio</th>
				    <th>Hora de Termino</th>
		  		</tr>
			</thead>

			<tbody>
		  		<c:forEach items="${salasOcupadas}" var="salasOcupadas" varStatus ="row">
				    <tr>
			  			<td>${salasOcupadas.nomeSala}</td>
			  			<td>${salasOcupadas.nomeTurma}</td>
			  			<td>${salasOcupadas.dia}</td>
			  			<td>${salasOcupadas.dataInicial}</td>
			  			<td>${salasOcupadas.dataTermino}</td>
			  			<td>${salasOcupadas.horaInicio}</td>
			  			<td>${salasOcupadas.horaTermino}</td>
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
