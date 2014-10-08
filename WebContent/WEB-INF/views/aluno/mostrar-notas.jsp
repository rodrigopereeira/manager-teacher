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
		<div class="improvisado"></div>
		
    		<table id="tabela" class="display" cellspacing="0" width="100%">
				
				 <thead>
			        <tr>
					    <th>Turma</th>
					    <th>M1</th>
					    <th>M2</th>
					    <th>M3</th>
					    <th>Média Parcial</th>
					    <th>Média Final</th>
					     <th>Status</th>
			  		</tr>
			    </thead>
			    
			    <tfoot>
			        <tr>
			            <th>Turma</th>
					    <th>M1</th>
					    <th>M2</th>
					    <th>M3</th>
					    <th>Média Parcial</th>
					    <th>Média Final</th>
					    <th>Status</th>
			        </tr>
			    </tfoot>
				
				<tbody>
			  		<c:forEach items="${alunosNotas}" var="notas" varStatus ="row">

					    <tr>
				  			<td>${notas.nomeTurma}</td>
				  			<td>${notas.m1}</td>
				  			<td>${notas.m2}</td>
				  			<td>${notas.m3}</td>
							<td>${notas.mediaParcial}</td>
							<td>${notas.mediaFinal}</td>
							
							<td>
								<c:if test="${not empty notas.status}">
									<c:if test="${notas.status == 'Reprovado'}">
										<p style="color:red;" >${notas.status}</p>
									</c:if>
					        		<c:if test="${notas.status == 'Aprovado'}">
										<p style="color:green;" >${notas.status}</p>
									</c:if>
					      		</c:if>
					            <c:if test="${empty notas.status}">
					        		Em andamento
					        	</c:if>
				        	</td>
			  			</tr>
			  		
			  		</c:forEach>
		  		</tbody>
			</table>
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