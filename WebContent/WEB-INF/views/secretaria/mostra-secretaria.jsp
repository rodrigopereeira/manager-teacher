<html>
<head>
	<title>Alterar Secretaria</title>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../menu.jsp" />
	<form action="alteraSecretaria" method="post">
		<div class="fundoTitulo">
    		<p class="tituloForm">Alterar Secretario(a) - ${secretaria.nome}</p>
    	</div>
    	<br>
		<fieldset class="formulario" >
	    			<label for="codigoSecretaria">ID:</label>
	    				<input type="text" name="codigoSecretaria" id="codigoSecretaria" class="inputPequeno" value="${secretaria.codigoSecretaria}" readonly> <br>
	    			<label for="nome">Nome:</label>
	    				<input type="text" class="inputGrande" name="nome" id="nome" value="${secretaria.nome}"> <br>
	    			<label for="dataNascimento">Data de Nascimento:</label>
	    				<input type="text" class="inputPequeno" name="dataNascimento" id="dataNascimento" value="${secretaria.dataNascimento}"> <br>
	    			<label for="sexo">Sexo:</label>
	    				<select  name="codigoSexo" id="codigoSexo" class="select">
	    					<c:forEach items="${sexos}" var="p">
	    						<c:choose>
	    							<c:when test="${ secretaria.codigoSexo == p.codigoSexo }">
				    					 <option value="${p.codigoSexo}" selected>${p.descricao}</option>  
						      		</c:when>
						            <c:otherwise>
						        		<option value="${p.codigoSexo}">${p.descricao}</option> 
						        	</c:otherwise>
	    						</c:choose>  
							</c:forEach>
					    </select>

	    			<label for="estadoCivil">Estado Civil:</label>
	    				<select  name="codigoEstadoCivil" id="codigoEstadoCivil" class="select">
	    					<c:forEach items="${estadosCivis}" var="es">  
	    						<c:choose>
	    							<c:when test="${ secretaria.codigoEstadoCivil == es.codigoEstadoCivil }">
				    					 <option value="${es.codigoEstadoCivil}" selected>${es.descricao}</option>  
						      		</c:when>
						            <c:otherwise>
						        		<option value="${es.codigoEstadoCivil}">${es.descricao}</option>  
						        	</c:otherwise>
	    						</c:choose>
							</c:forEach>
					    </select> <br>

	    			<label for="endereco">Rua:</label>
	    				<input type="text" class="inputGrande" name="endereco" id="rua" value="${secretaria.endereco}"> <br>

	    			<label for="numero">Numero:</label>
	    				<input type="text" class="inputPequeno" name="numero" id="numero" value="${secretaria.numero}">

	    			<label for="bairro">Bairro:</label>
	    				<input type="text" class="inputPequeno" name="bairro" id="bairro" value="${secretaria.bairro}"> <br>

	    			<label for="estado">Estado:</label>
	    				<select  name="codigoEstado" id="codigoEstado" class="select">
	    					<c:forEach items="${estados}" var="e">  
	    						<c:choose>
				    				<c:when test="${ secretaria.codigoEstado == e.codigoEstado }">
				    					 <option value="${e.codigoEstado}" selected>${e.estado}</option>  
						      		</c:when>
						            <c:otherwise>
						        		<option value="${e.codigoEstado}">${e.estado}</option>  
						        	</c:otherwise>
					        	</c:choose>
							</c:forEach>
					    </select> <br>

	    			<label for="celular">Celular:</label>
	    				<input type="text" class="inputPequeno" name="celular" id="celular" value="${secretaria.celular}">

	    			<label for="telefone">Telefone:</label>
	    				<input type="text" class="inputPequeno" name="telefone" id="telefone" value="${secretaria.telefone}"> <br>

	    			<label for="email">Email:</label>
	    				<input type="email"class="inputMedio" name="email" id="email" value="${secretaria.email}"> <br>

	    			<label for="cpf">CPF:</label>
	    				<input type="text" class="inputPequeno" name="cpf" id="cpf" value="${secretaria.cpf}">

	    			<label for="rg">RG:</label>
	    				<input type="text" class="inputPequeno" name="rg" id="rg" value="${secretaria.rg}"> <br>

	    			<label for="login">Login:</label>
	    				<input type="text" class="inputPequeno" name="login" id="login" value="${secretaria.login}"> <br>

	    			<label for="senha">Senha:</label>
	    				<input type="password" class="inputPequeno" name="senha" id="senha" value="${secretaria.senha}"> <br>

	    			<input type="submit" value="Alterar" class="novoBotao"> 
	    			<input type="reset" value="Cancelar" class="novoBotao">
	    				<a href="listaSecretarias"><input type="submit" value="Voltar" class="novoBotao"></a>			    		
        </fieldset>
	</form>
</body>
</html>