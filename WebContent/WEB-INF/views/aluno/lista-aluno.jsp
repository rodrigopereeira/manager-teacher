<html>
<head>
	<title>Lista de Alunos</title>
	
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
			<a class="novoBotao" href="novoAluno">Novo Aluno</a>
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
				    <th>Matricular</th>
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
				    <th>Matricular</th>
			    </tr>
			</tfoot>
	   		
			<tbody>
		  		<c:forEach items="${alunos}" var="aluno" varStatus ="row">

				    <tr>
			  			<td>${aluno.codigoAluno}</td>
		  				<td>${aluno.nome}</td>
			  			<td>${aluno.endereco}</td>
			  			<td>${aluno.numero}</td>
			  			<td>${aluno.bairro}</td>
			  			<td>
				      		<c:if test="${not empty aluno.email}">
				        		<a href="mailto:${aluno.email}">${aluno.email}</a>
				      		</c:if>
				            <c:if test="${empty aluno.email}">
				        		E-mail não informado
				        	</c:if>
				        </td>
			  			<td>${aluno.celular}</td>
			  			<td><a href="mostraAluno?id=${aluno.codigoAluno}">Mostrar</a></td>
						<td><a href="removeAluno?codigoAluno=${aluno.codigoAluno}">Excluir</a></td>
						<td><a href="#">Matricular</a></td>
						
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
