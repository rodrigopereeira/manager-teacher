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
    		
    		
		<form:form method="post" id="formulario" action="#" modelAttribute="notasAlunos">
			<table id="tabela" class="display" width="1366px">
			
				<thead>
					<tr>
						<th hidden>Código Turma</th>
						<th hidden>Código Aluno</th>
					    <th width="900px">Aluno</th>
					    <th width="150px">M1</th>
					    <th width="150px">M2</th>
					    <th width="150px">M3</th>
					    <th width="150px">Média Final</th>
					    <th width="150px">Status</th>
			  		</tr>
				</thead>
				
				<tbody>
			  		<c:forEach items="${alunosNotas}" var="turmas" varStatus ="row">
					    <tr>
					    <td hidden><input type="text" id="codigoTurma" name="listaNotas[${row.index}].codigoTurma" value="${turmas.codigoTurma}"></td>
				  			<td hidden><input type="text" name="listaNotas[${row.index}].codigoAluno" value="${turmas.codigoAluno}"></td>
				  			<td>${turmas.nomeAluno}</td>
				  			<td><input type="text" name="listaNotas[${row.index}].m1" class="inputPequeno" value="${turmas.m1}"></td>
				  			<td><input type="text" name="listaNotas[${row.index}].m2" class="inputPequeno" value="${turmas.m2}"></td>
				  			<td><input type="text" name="listaNotas[${row.index}].m3" class="inputPequeno" value="${turmas.m3}" ></td>
				  			<td><input type="text" name="listaNotas[${row.index}].m2" class="inputPequeno" value="${turmas.mediaFinal}" readonly></td>
				  			<td><input type="text" name="listaNotas[${row.index}].m3" id="status" class="inputPequeno" value="${turmas.status}" readonly></td>
			  			</tr>
			  		</c:forEach>
		  		</tbody>
			</table>
			<input type="submit" id="postar" onclick="postarNotas();" value="Postar" class="novoBotao"/>
			<input type="submit" id="fechar" onclick="fecharTurmas();" value="Fechar Turma"  class="novoBotao"/>
			<a href="visualizarNotas"><input type="button" value="Voltar" id="voltar" class="novoBotao"></a>
		</form:form>
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

function postarNotas() {
	$('#formulario').attr('action', 'confirmarNotas');
}

function fecharTurmas(){
	$('#formulario').attr('action', 'fecharTurma');
}

$( document ).ready(function() {
	 var fechada = $('#status').val();
	 
	 if (fechada != "") {
		 $('#postar').remove();
		 $('#fechar').remove();
		 $("input:text").attr('disabled','disabled');
	 }
});

</script>