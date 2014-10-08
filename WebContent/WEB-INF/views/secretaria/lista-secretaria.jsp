<html>
<head>
	<title>Lista de Secretarias</title>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="resources/media/css/jquery.dataTables.css">
	  
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.js"></script>
	  
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.dataTables.js"></script>
	
  	<script>
  	$(document).ready( function () {
  	    $('#tabela').DataTable();
  	} );
  	</script>
</head>
<body>	

	<c:import url="../menu.jsp" />
	
	<div class="containerConteudoMeio">
		<div class="containerBotoesMeio">
			<a class="novoBotao" href="novaSecretaria">Nova secretaria</a>
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
		  		<c:forEach items="${secretarias}" var="secretaria" varStatus ="row">

				    <tr>
			  			<td>${secretaria.codigoSecretaria}</td>
			  			<td>${secretaria.nome}</td>
			  			<td>${secretaria.endereco}</td>
			  			<td>${secretaria.numero}</td>
			  			<td>${secretaria.bairro}</td>
			  			<td>
				      		<c:if test="${not empty secretaria.email}">
				        		<a href="mailto:${secretaria.email}">${secretaria.email}</a>
				      		</c:if>
				            <c:if test="${empty secretaria.email}">
				        		E-mail não informado
				        	</c:if>
				        </td>
			  			<td>${secretaria.celular}</td>
			  			<td><a href="mostraSecretaria?id=${secretaria.codigoSecretaria}">Alterar</a></td>
						<td><a href="removeSecretaria?codigoSecretaria=${secretaria.codigoSecretaria}">Remover</a></td>
		  			</tr>
		  		</c:forEach>
		  	</tbody>
		</table>
	</div>
</body>
</html>
