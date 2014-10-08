<html>
<head>
	<title>Alterar Turma</title>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	  
</head>
<body>
	<script>
	$(function() {
	    $( "#dataInicio" ).datepicker({
	    	dateFormat: 'dd/mm/yy',
	    	changeMonth: true,
	        changeYear: true,
	        yearRange: "-60:+0",
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
	        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
	        showOtherMonths: true,
	        selectOtherMonths: true
	    });
	});
	$(function() {
	    $( "#dataTermino" ).datepicker({
	    	dateFormat: 'dd/mm/yy',
	    	changeMonth: true,
	        changeYear: true,
	        yearRange: "-60:+0",
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
	        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
	        showOtherMonths: true,
	        selectOtherMonths: true
	    });
	});
	</script>

	<c:import url="../menu.jsp" />
	<form action="alteraTurma" method="post">
		<div class="fundoTitulo">
    		<p class="tituloForm">Alterar Turma - ${turma.nome}</p>
    	</div>
    	<br>
		<fieldset class="formulario">

	    	<label for="codigoTurma">ID:</label>
	    		<input type="text" name="codigoTurma" id="codigoTurma" class="inputPequeno" value="${turma.codigoTurma}" readonly> <br>
	    	   		
	    	<label for="codigoCurso">Curso:</label>
	    		<select  name="codigoCurso" id="codigoCurso" class="select">
	    			<c:forEach items="${cursos}" var="e">  
	    				<c:choose>
				    		<c:when test="${ turma.codigoCurso == e.codigoCurso }">
				    			<option value="${e.codigoCurso}" selected>${e.nome}</option>  
							</c:when>
						    <c:otherwise>
						   		<option value="${e.codigoCurso}">${e.nome}</option>  
						   	</c:otherwise>
					    </c:choose>
					</c:forEach>
				</select> <br>
	    			    		
	    	<label for="codigoProfessor">Professor:</label>
	    		<select  name="codigoProfessor" id="codigoProfessor" class="select">
	    			<c:forEach items="${professores}" var="es">  
	    				<c:choose>
			   				<c:when test="${ turma.codigoProfessor == es.codigoProfessor }">
			   					 <option value="${es.codigoProfessor}" selected>${es.nome}</option>  
				      		</c:when>
				            <c:otherwise>
				        		<option value="${es.codigoProfessor}">${es.nome}</option>  
				        	</c:otherwise>
			        	</c:choose>
					</c:forEach>
			    </select>  <br>
	    				
	    	<label for="codigoSala">Sala:</label>
	    		<select  name="codigoSala" id="codigoSala" class="select">
	    			<c:forEach items="${salas}" var="esp">  
	    				<c:choose>
							<c:when test="${ turma.codigoSala == esp.codigoSala }">
								 <option value="${esp.codigoSala}" selected>${esp.nome}</option>  
				      		</c:when>
					        <c:otherwise>
					       		<option value="${esp.codigoSala}">${esp.nome}</option>  
					       	</c:otherwise>
					   	</c:choose>
					</c:forEach>
				</select> <br>
	    				
	    	<label for="nome">Nome:</label>
	    		<input type="text" name="nome" id="nome" class="inputPequeno" value="${turma.nome}"> <br>
	    			
	    	<label for="vagas">Vagas:</label>
	    		<input type="text" name="vagas" id="vagas" class="inputPequeno" value="${turma.vagas}"> <br>
	    			
	    	<label for="horaInicio">Hora de Inicio:</label>
	    		<input type="text" name="horaInicio" id="horaInicio" class="inputPequeno" value="${turma.horaInicio}">
	    			
	    	<label for="horaTermino">Hora de Termino:</label>
	    		<input type="text" name="horaTermino" id="horaTermino" class="inputPequeno" value="${turma.horaTermino}"> <br>
	    				
	    	<label for="dataInicio">Data de Inicio:</label>
	    		<input type="text" name="dataInicio" id="dataInicio" class="inputPequeno" value="${turma.dataInicio}">
	    				
	    	<label for="dataTermino">Data de Termino:</label>
	    		<input type="text" name="dataTermino" id="dataTermino" class="inputPequeno" value="${turma.dataTermino}"> <br>
	    		
	    	<label for="notaAprovacao">Nota de Aprovação:</label>
	    		<input type="text" name="notaAprovacao" id="notaAprovacao" class="inputPequeno" value="${turma.notaAprovacao}"> <br>
	    			
	    	<label for="frequenciaMinima">Frequencia Minima:</label>
	    		<input type="text" name="frequenciaMinima" id="frequenciaMinima" class="inputPequeno" value="${turma.frequenciaMinima}"> <br>	
	
	    	<input type="submit" value="Alterar" class="novoBotao"> 
	    	<input type="reset" value="Cancelar" class="novoBotao">
	    		<a href="listaTurmas"><input type="submit" value="Voltar" class="novoBotao"></a>
	    			

        </fieldset>
	</form>
</body>
</html>