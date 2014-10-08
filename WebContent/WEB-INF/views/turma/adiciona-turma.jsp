<html>
  <head>
  	<title>Cadastro de Turma</title>
  	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	<script>
	$(function() {
	    $( "#dataInicio" ).datepicker({
	    	dateFormat: 'dd/mm/yy',
	    	changeMonth: true,
	        changeYear: true,
	        yearRange: "-60:+1",
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
	        yearRange: "-60:+10",
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
  </head>
  <body>

  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<c:import url="../menu.jsp" />
	
  	<form method="post" action="adicionaTurma" >
    	<div class="fundoTitulo">
    		<p class="tituloForm">Nova Turma</p>
    	</div>
    	<br>
    	<fieldset class="formulario">

	    	<label for="codigoCurso">Curso:</label>		
	    		<select  name="codigoCurso" id="codigoCurso" class="select">
	    			<c:forEach items="${cursos}" var="p">  
				       <option value="${p.codigoCurso}">${p.nome}</option>  
					</c:forEach>
				</select> <br>
					
	    	<label for="codigoProfessor">Professor:</label>
	    		<select  name="codigoProfessor" id="codigoProfessor" class="select">
	    			<c:forEach items="${professores}" var="pr">  
				       <option value="${pr.codigoProfessor}">${pr.nome}</option>  
					</c:forEach>
			    </select>
			<p class="fatalError">${erroProfessor}</p>  <br>
						
	    	<label for="codigoSala">Sala:</label>
	    		<select  name="codigoSala" id="codigoSala" class="select">
	    			<c:forEach items="${salas}" var="sl">  
				       <option value="${sl.codigoSala}">${sl.nome}</option>  
					</c:forEach>
			    </select>
			<p class="fatalError">${erroSala}</p> <br>
	    		
	    	<label for="nome">Nome da Turma:</label>
	    		<input type="text" name="nome" id="nome" class="inputPequeno" required> <br>
	    		
	    	<label for="vagas">Vagas:</label>
	    		<input type="number" min="1" max="100" name="vagas" id="vagas" class="inputPequeno" required> 
	    	<p class="fatalError">${erroCapacidade}</p> <br>
	    				
	    	<label for="horaInicio">Hora de Inicio:</label>
	    		<input type="time" name="horaInicio" id="horaInicio" class="inputPequeno" required>
	    		
	    	<label for="horaTermino">Hora de Saída:</label>
	    		<input type="time" name="horaTermino" id="horaTermino" class="inputPequeno" required> <br>
	    	
	    	<label for="dataInicio">Data de Inicio:</label>
	    		<input type="text" name="dataInicio"id="dataInicio" class="inputPequeno" required>
	    			
	    	<label for="dataTermino">Data de Termino:</label>
	    		<input type="text" name="dataTermino" id="dataTermino" class="inputPequeno" required> <br>
	    		
	    	<label for="notaAprovacao">Nota de Aprovação:</label>
	    		<select name="notaAprovacao" id="notaAprovacao" class="select">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>
					<option value="50">50</option>
					<option value="60">60</option>
					<option value="70" selected>70</option>
					<option value="80">80</option>
					<option value="90">90</option>
					<option value="100">100</option>
				</select> <br>
	    			
	    	<label for="frequenciaAprovacao">Frequencia Mínima:</label>
	    		<select name="frequenciaAprovacao" id="frequenciaAprovacao" class="select">
				    <option value="50">50%</option>
				    <option value="55">55%</option>
				    <option value="60" selected>60%</option>
				    <option value="65">65%</option>
				    <option value="70">70%</option>
				    <option value="75">75%</option>
					<option value="80">80%</option>
					<option value="85">85%</option>
					<option value="90">90%</option>
					<option value="95">95%</option>
					<option value="100">100%</option>
				</select> <br>
	    		
	    		<input type="submit" value="Adicionar" class="novoBotao"> 
	    		<input type="reset" value="Cancelar" class="novoBotao">

        </fieldset>
    </form>
  </body>
</html>