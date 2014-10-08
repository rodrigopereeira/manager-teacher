<html>
<head>
	<title>Alterar Professor</title>
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
	<form action="alteraProfessor" method="post">
		<div class="fundoTitulo">
    		<p class="tituloForm">Alterar Professor(a) - ${professor.nome}</p>
    	</div>
    	<br>
		<fieldset class="formulario">
	    	<label for="codigoProfessor">ID:</label>
	    		<input type="text" name="codigoProfessor" id="codigoProfessor" class="inputPequeno" value="${professor.codigoProfessor}" readonly> <br>
	    				
	    	<label for="nome">Nome:</label>
	    		<input type="text" name="nome" id="nome" class="inputGrande" value="${professor.nome}"> <br>
	    		
	    	<label for="dataNascimento">Data de Nascimento:</label>
	    		<input type="text" name="dataNascimento" id="dataNascimento" class="select" value="${professor.dataNascimento}"> <br>
	    		
	    	<label for="sexo">Sexo:</label>		
	    		<select  name="codigoSexo" id="codigoSexo" class="inputPequeno" >
	    			<c:forEach items="${sexos}" var="p">
	    				<c:choose>
	    					<c:when test="${ professor.codigoSexo == p.codigoSexo }">
				    			<option value="${p.codigoSexo}" selected>${p.descricao}</option>  
					   		</c:when>
						    <c:otherwise>
						   		<option value="${p.codigoSexo}">${p.descricao}</option> 
						    </c:otherwise>
	    				</c:choose>  
					</c:forEach>
				</select>

	    	<label for="estadoCivil">Estado Civil:</label>
	    		<select  name="codigoEstadoCivil" id="codigoEstadoCivil"  class="select" >
	    			<c:forEach items="${estadosCivis}" var="es">  
	    				<c:choose>
	    					<c:when test="${ professor.codigoEstadoCivil == es.codigoEstadoCivil }">
								 <option value="${es.codigoEstadoCivil}" selected>${es.descricao}</option>  
				      		</c:when>
				            <c:otherwise>
				        		<option value="${es.codigoEstadoCivil}">${es.descricao}</option>  
				        	</c:otherwise>
	    				</c:choose>
					</c:forEach>
				</select> <br>
	    			
	    	<label for="especialidade">Especialidade:</label>
	    		<select  name="codigoEspecialidade" id="codigoEspecialidade"  class="select" >
	    			<c:forEach items="${especialidades}" var="esp">  
	    				<c:choose>
	    					<c:when test="${ professor.codigoEspecialidade == esp.codigoEspecialidade }">
								 <option value="${esp.codigoEspecialidade}" selected>${esp.descricao}</option>  
				      		</c:when>
					        <c:otherwise>
					       		<option value="${esp.codigoEspecialidade}">${esp.descricao}</option>  
					       	</c:otherwise>
	    				</c:choose>
					</c:forEach>
				</select> <br>
	    			
	    	<label for="endereco">Endereço:</label>
	    		<input type="text" name="endereco" id="endereco"  class="inputGrande" value="${professor.endereco}"> <br>
	 
	    	<label for="numero">Numero:</label>
	    		<input type="text" name="numero" id="numero"  class="inputPequeno" value="${professor.numero}">
	   	
	    	<label for="bairro">Bairro:</label>
	    		<input type="text" name="bairro" id="bairro"  class="inputPequeno" value="${professor.bairro}"> <br>
	    				
	    	<label for="estado">Estado:</label>
	    		<select  name="codigoEstado" id="codigoEstado"  class="select" >
	    			<c:forEach items="${estados}" var="e">  
	    				<c:choose>
			   				<c:when test="${ professor.codigoEstado == e.codigoEstado }">
			  					 <option value="${e.codigoEstado}" selected>${e.estado}</option>  
				      		</c:when>
				            <c:otherwise>
			    	    		<option value="${e.codigoEstado}">${e.estado}</option>  
				        	</c:otherwise>
				       	</c:choose>
					</c:forEach>
				</select> <br>
	    			
	    	<label for="celular">Celular:</label>
	    		<input type="text" name="celular" id="celular"  class="inputPequeno" value="${professor.celular}">	
	    		
	    	<label for="telefone">Telefone:</label>
	    		<input type="text" name="telefone" id="telefone"  class="inputPequeno" value="${professor.telefone}"> <br>
	    		
	    	<label for="email">Email:</label>
	    		<input type="email" name="email" id="email"  class="inputMedio" value="${professor.email}"> <br>
	    		
	    	<label for="cpf">CPF:</label>
	    		<input type="text" name="cpf" id="cpf"  class="inputPequeno" value="${professor.cpf}"> <br>
	    		
	    	<label for="rg">RG:</label>
	    		<input type="text" name="rg" id="rg"  class="inputPequeno" value="${professor.rg}"> <br>
	    
	    	<label for="senha">Senha:</label>
	    		<input type="password" name="senha" id="senha"  class="inputPequeno" value="${professor.senha}"> <br>
	    			
	    	<input type="submit" value="Alterar" class="botaoForm"> 
	    	<input type="reset" value="Cancelar" class="botaoForm">
	    		<a href="listaProfessores"><input type="submit" value="Voltar" class="botaoForm"></a>
	    						    		
        </fieldset>
	</form>
</body>
</html>