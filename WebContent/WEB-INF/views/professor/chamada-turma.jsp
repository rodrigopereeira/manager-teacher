

<html>
<head>
	<title>Lista de Professores</title>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
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
		<div class="fundoTitulo">
    		<p class="tituloForm">Chamada da Turma ${turma.nomeTurma}           Dia:${turma.data} </p>
    	</div>
    	
	<form:form method="post" action="confirmarChamada" modelAttribute="alunosChamada">
	
		<table id="tabela" class="display" width="1366px">
		
			<thead>
				<tr>
					<th width="750px">Aluno</th>
				    <th width="750px">Presença</th>
				    <th></th>
		  		</tr>
			</thead>
			
			<tbody>
		  		<c:forEach items="${alunosChamada.listaPresencas}" var="alunos" varStatus ="row">
					
				    <tr id="alunosTr" class="linhasNome">
				    	<td hidden align="center">${row.index}</td>
				    	<td hidden><input type="text" name="listaPresencas[${row.index}].codigoTurma" id="nome" value="${turma.codigoTurma}"></td>
				    	<td hidden><input type="text" name="listaPresencas[${row.index}].codigoAluno" id="nome" value="${alunos.codigoAluno}"></td>
			  			<td>${alunosChamada.listaPresencas[row.index].nomeAluno}</td>
			  			<td id ="presencaAluno" >
			  				<c:choose>
							    <c:when test="${alunos.presenca == 'Presente'}">
							      <input type="checkbox" value="Presenca" name="listaPresencas[${row.index}].presenca" checked >
							    </c:when>
							    <c:otherwise>
							        <input type="checkbox" value="Presenca" name="listaPresencas[${row.index}].presenca" >
							    </c:otherwise>						
							</c:choose>
				        </td>
		  			</tr>
		  		</c:forEach>
	  		</tbody>
		</table>
		
		<input type="submit" value="Salvar" class="novoBotao"/>
		</form:form>
	</div>
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
