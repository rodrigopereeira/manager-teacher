<html>
<head>
	<title>Lista de Professores</title>
	
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
			<a class="novoBotao" href="novoProfessor">Novo Professor</a>
		</div> 
		
		<table id="tabela" class="display" width="1366px">
		
			<thead>
			    <tr>
					<th>Id</th>
				    <th>Nome</th>
				    <th>Rua</th>
				    <th>Numero</th>
				    <th>Bairro</th>
				    <th>Email</th>
				    <th>Celular</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</thead>
			    
			<tfoot>
			   <tr>
					<th>Id</th>
				    <th>Nome</th>
				    <th>Rua</th>
				    <th>Numero</th>
				    <th>Bairro</th>
				    <th>Email</th>
				    <th>Celular</th>
				    <th>Alterar</th>
				    <th>Excluir</th>
		  		</tr>
			</tfoot>
			
			<tbody>
		  		<c:forEach items="${professores}" var="professor" varStatus ="row">
				
				    <tr>
			  			<td>${professor.codigoProfessor}</td>
			  			<td>${professor.nome}</td>
			  			<td>${professor.endereco}</td>
			  			<td>${professor.numero}</td>
			  			<td>${professor.bairro}</td>
			  			<td>
				      		<c:if test="${not empty professor.email}">
				        		<a href="mailto:${professor.email}">${professor.email}</a>
				      		</c:if>
				            <c:if test="${empty professor.email}">
				        		E-mail não informado
				        	</c:if>
				        </td>
			  			<td>${professor.celular}</td>
			  			<td><a href="mostraProfessor?id=${professor.codigoProfessor}">Alterar</a></td>
						<td><a href="removeProfessor?codigoProfessor=${professor.codigoProfessor}">Remover</a></td>
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
