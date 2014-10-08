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
				<a class="novoBotao" href="visualizarDocumentos">Voltar</a>
			</div> 
		</div>
		
	
    <br><br>
	<table id="tabela" class="display" width="1366px">
        <thead>
	        <tr>
	            <th>N°</th>
	            <th>Nome</th>
	            <th>Descrição</th>
	            <th>Tipo</th>
	            <th>Ação</th>
	        </tr>
        </thead>
			<c:forEach var="file" items="${files}" varStatus="counter">
            	<tr>
                	<td>${counter.index + 1}</td>
                    <td>${file.filename}</td>
                    <td>${file.notes}</td>
                    <td>${file.type}</td>
                    <td><a href="download.htm?id=${file.id}">Download</a>
                    </td>
                </tr>
            </c:forEach>

    </table>	
	
	
	
    <br>
    
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