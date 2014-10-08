<html>
  <head>
  	<title>Matricula de Aluno</title>
  	
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  	
  	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.js"></script>
  	

	<script type='text/javascript'>
	function abreDiv()  {

		var current = $("#codigoTurma").val();
		<c:forEach items="${turmasDisponiveis}" var="t">
			if("${t.codigoTurma}" == current) {
		 		document.getElementById('infoNomeCurso').value="${t.nomeCurso}" ; 
		 		document.getElementById('infoNomeTurma').value="${t.nome}" ; 
		 		document.getElementById('infoVagas').value="${t.vagas}" ; 
		 		document.getElementById('infoHoraInicio').value="${t.horaInicio}" ; 
		 		document.getElementById('infoHoraTermino').value="${t.horaTermino}" ;
		 		document.getElementById('infoDataInicio').value="${t.dataInicio}" ; 
		 		document.getElementById('infoDataTermino').value="${t.dataTermino}" ; 
		 		document.getElementById('infoDia').value="${t.dia}" ; 
		 	}
		</c:forEach>
			 
	};
	</script>
	
  </head>
  <body>
  	
	<c:import url="../menu.jsp" />
	
    <form action="matriculaAluno" method="post">
    	<div class="fundoTitulo">
    		<p class="tituloForm">Nova Matricula</p>
    	</div>
    	<br>
    	<fieldset class="formulario">
    	
	    	<label for="codigoTurma">Curso:</label>	
	    		<select  name="codigoTurma" id="codigoTurma" class="select">
	    			<c:forEach items="${turmasDisponiveis}" var="t">  
						<option value="${t.codigoTurma}"> ${t.nome} + ${t.nomeCurso}</option>  
					</c:forEach>
				</select>
		 		
				<a href="#openModal" onclick="abreDiv();" >
					<input type="button" class="infos" value="Mais infos" readonly>
				</a> 
				
				<div id="openModal" class="modalDialog" id="seuBotao">
					<div >
						<a href="#close" title="Close" class="close">X</a>
						
						<h4 class="tituloInfo">Informações da Turma</h4>
						<label for="infoNomeCurso">Curso:</label>		
							<input type='text' id='infoNomeCurso'>
						<label for="infoNomeTurma">Turma:</label>
							<input type='text' id='infoNomeTurma'>
						<label for="infoVagas">Vagas:</label>
							<input type='text' id='infoVagas'>	
						<label for="infoHoraInicio">Hora Ínicio:</label>
							<input type='text' id='infoHoraInicio'>
						<label for="infoHoraTermino">Hora Termino:</label>
							<input type='text' id='infoHoraTermino'>
						<label for="infoDataInicio">Data Ínicio:</label>
							<input type='text' id='infoDataInicio'>
						<label for="infoDataTermino">Data Termino:</label>
							<input type='text' id='infoDataTermino'>
						<label for="infoDia">Dia:</label>
							<input type='text' id='infoDia'>
						
					</div>
				</div>
				
				
				<br>
			
			<label for="codigoAluno">Aluno:</label>	
	    		<select  name="codigoAluno" id="codigoAluno" class="select">
	    			<c:forEach items="${alunos}" var="a">  
						<option value="${a.codigoAluno}">${a.nome}</option>  
					</c:forEach>
				</select> <br>
	    		
	    	<input type="submit" value="Matricular" class="novoBotao"> 
	    	<input type="reset" value="Cancelar" class="novoBotao">

        </fieldset>
    </form>
  </body>
</html>