<html>
<head>
	<title>Alterar Aluno</title>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<script>
	$(function() {
	    $( "#dataNascimento" ).datepicker({
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
	  
	<script type="text/javascript">  
  
	function habilita_a()  
	{  
		//Habilitando  
	    document.getElementById("nome").disabled = false; 
	    document.getElementById("dataNascimento").disabled = false; 
		document.getElementById("codigoSexo").disabled = false; 
	    document.getElementById("codigoEstadoCivil").disabled = false; 
	    document.getElementById("endereco").disabled = false; 
	    document.getElementById("numero").disabled = false; 
	    document.getElementById("bairro").disabled = false; 
	    document.getElementById("codigoEstado").disabled = false; 
	    document.getElementById("celular").disabled = false; 
	    document.getElementById("telefone").disabled = false; 
	    document.getElementById("email").disabled = false; 
	    document.getElementById("cpf").disabled = false; 
	    document.getElementById("rg").disabled = false; 
	    document.getElementById("senha").disabled = false; 	    
	}  

	</script>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../menu.jsp" />
	<form action="alteraAluno" method="post">
		<div class="fundoTitulo">
    		<p class="tituloForm">Alterar Aluno(a) - ${aluno.nome}</p>
    	</div>
    	<br>
		<fieldset class="formulario" >

	    	<label for="codigoAluno">Matricula:</label>
	    		<input type="text" name="codigoAluno" id="codigoAluno" class="inputPequeno" value="${aluno.codigoAluno}" readonly> <br>	
	    		
	    	<label for="nome">Nome:</label>
	    		<input type="text" name="nome" id="nome" class="inputGrande" value="${aluno.nome}" disabled> <br>
	    		
	    	<label for="dataNascimento">Data de Nascimento:</label>
	    		<input type="text" name="dataNascimento" id="dataNascimento" class="inputPequeno" value="${aluno.dataNascimento}" disabled> <br>
	    		
	    	<label for="sexo">Sexo:</label>
	    		<select  name="codigoSexo" id="codigoSexo" class="select" disabled>
	    			<c:forEach items="${sexos}" var="p">
	    				<c:choose>
	    					<c:when test="${ aluno.codigoSexo == p.codigoSexo }">
				    			<option value="${p.codigoSexo}" selected>${p.descricao}</option>  
						    </c:when>
						    <c:otherwise>
						        <option value="${p.codigoSexo}">${p.descricao}</option> 
						    </c:otherwise>
	    				</c:choose>  
					</c:forEach>
				 </select>
					
	    	<label for="estadoCivil">Estado Civil:</label>
	    		<select  name="codigoEstadoCivil" id="codigoEstadoCivil" class="select" disabled>
	    			<c:forEach items="${estadosCivis}" var="es">  
	    				<c:choose>
	    					<c:when test="${ aluno.codigoEstadoCivil == es.codigoEstadoCivil }">
				    			<option value="${es.codigoEstadoCivil}" selected>${es.descricao}</option>  
						    </c:when>
						    <c:otherwise>
						        <option value="${es.codigoEstadoCivil}">${es.descricao}</option>  
						    </c:otherwise>
	    				</c:choose>
					</c:forEach>
				</select> <br>

	    	<label for="endereco">Endereço:</label>
	    		<input type="text" name="endereco" id="endereco" class="inputGrande" value="${aluno.endereco}" disabled> <br>
	    		
	    	<label for="numero">Numero:</label>
	    		<input type="text" name="numero" id="numero" class="inputPequeno" value="${aluno.numero}" disabled>

	    	<label for="bairro">Bairro:</label>
	    		<input type="text" name="bairro" id="bairro" class="inputPequeno" value="${aluno.bairro}" disabled> <br>
	    			
	    	<label for="estado">Estado:</label>	
	    		<select  name="codigoEstado" id="codigoEstado" class="select" disabled>
	    			<c:forEach items="${estados}" var="e">  
	    				<c:choose>
				    		<c:when test="${ aluno.codigoEstado == e.codigoEstado }">
				    			<option value="${e.codigoEstado}" selected>${e.estado}</option>  
						    </c:when>
						    <c:otherwise>
						        <option value="${e.codigoEstado}">${e.estado}</option>  
						    </c:otherwise>
					    </c:choose>
					</c:forEach>
				</select> <br>

	    	<label for="celular">Celular:</label>
	    		<input type="text" name="celular" id="celular" class="inputPequeno" value="${aluno.celular}" disabled>
	    		
	    	<label for="telefone">Telefone:</label>
	    		<input type="text" name="telefone" id="telefone" class="inputPequeno" value="${aluno.telefone}" disabled> <br>
	    		
	    	<label for="email">Email:</label>
	    		<input type="email" name="email" id="email" class="inputMedio" value="${aluno.email}" disabled> <br>
	    			
	    	<label for="cpf">CPF:</label>
	    		<input type="text" name="cpf" id="cpf" class="inputPequeno" value="${aluno.cpf}" disabled> <br>

	    	<label for="rg">RG:</label>
	    		<input type="text" name="rg" id="rg" class="inputPequeno" value="${aluno.rg}" disabled> <br>
	    		
	    	<label for="senha">Senha:</label>
	    		<input type="password" name="senha" id="senha" class="inputPequeno" value="${aluno.senha}" disabled> <br>
	    		
	    	<a><input type="button" value="Alterar" class="novoBotao" onclick="habilita_a();"></a>
	    	<input type="submit" value="Salvar" class="novoBotao"> 
	    	<input type="reset" value="Cancelar" class="novoBotao">
	    	<a href="listaAlunos"><input type="button" value="Voltar" class="novoBotao"></a>
	    	<a href="mostrarTurmasAluno?codigoAluno=${aluno.codigoAluno}"><input type="button" value="Turmas" class="novoBotao"></a>
	    			
        </fieldset>
	</form>
</body>
</html>