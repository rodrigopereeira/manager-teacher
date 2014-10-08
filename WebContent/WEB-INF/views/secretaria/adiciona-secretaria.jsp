<html>
  <head>
  	<title>Cadastro de Secretaria</title>
  	
 <!-- jQuery -->
<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.js"></script>
	
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="resources/media/js/mascara.js"></script>
	
	
<script type="text/javascript">

    jQuery(function($){
    	$("#telefone").mask("(99) 9999-9999");
    	$("#celular").mask("(99) 9999-9999");
    	$("#cpf").mask("999.999.999-99");
    	$("#rg").mask("9.999.999");
    });

</script>
  </head>
  <body>

  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
	<c:import url="../menu.jsp" />
  	
    <form action="adicionaSecretaria" method="post">
    	<div class="fundoTitulo">
    		<p class="tituloForm">Nova Secretária(o)</p>
    	</div>
    	<br>
    	<fieldset class="formulario">
	    			<label for="nome">Nome:</label>
	    				<input type="text" name="nome" id="nome" required class="inputGrande"> <br>
	    			<label for="dataNascimento">Data de Nascimento:</label>
	    				<input type="date" name="dataNascimento" id="dataNascimento" required class="inputPequeno"> <br>
	    			<label for="sexo">Sexo:</label>
	    				<select  name="codigoSexo" id="codigoSexo" class="select">
	    					<c:forEach items="${sexos}" var="p">  
							       <option value="${p.codigoSexo}">${p.descricao}</option>  
							</c:forEach>
					    </select>
					    
					<label for="estadoCivil">Estado Civil:</label>
	    				<select  name="codigoEstadoCivil" id="codigoEstadoCivil" class="select">
	    					<c:forEach items="${estadosCivis}" var="es">  
							       <option value="${es.codigoEstadoCivil}">${es.descricao}</option>  
							</c:forEach>
					    </select> <br>
	    		
	    			<label for="endereco">Rua:</label>
	    				<input type="text" name="endereco" id="endereco" required class="inputGrande"> <br>
	    			<label for="numero">Numero:</label>
	    				<input type="number" name="numero" id="numero" required class="inputPequeno">
	    			<label for="bairro">Bairro:</label>
	    				<input type="text" name="bairro" id="bairro" required class="inputPequeno"> <br>
	    			<label for="estado">Estado:</label>
	    				<select  name="codigoEstado" id="codigoEstado" class="select">
	    					<c:forEach items="${estados}" var="e">  
							       <option value="${e.codigoEstado}">${e.estado}</option>  
							</c:forEach>
					    </select> <br>
					    
	    			<label for="celular">Celular:</label>
	    				<input type="text" name="celular" id="celular" required class="inputPequeno">
	    			<label for="telefone">Telefone:</label>
	    				<input type="text" name="telefone" id="telefone" class="inputPequeno"> <br>
	    				
	    			<label for="email">Email:</label>
	    				<input type="email" name="email" id="email" class="inputMedio"> <br>
	    			<label for="cpf">CPF:</label>
	    				<input type="text" name="cpf" id="cpf" required class="inputPequeno"> <br>
	    			<label for="rg">RG:</label>
	    				<input type="text" name="rg" id="rg" required class="inputPequeno"> <br>
	    			<label for="login">Login:</label>
	    				<input type="text" name="login" id="login" required class="inputPequeno"> <br>
	    			<label for="senha">Senha:</label>
	    				<input type="password" name="senha" id="senha" required class="inputPequeno"> <br>
	    				
	    				<input type="submit" value="Adicionar" class="novoBotao"> 
	    				<input type="reset" value="Cancelar" class="novoBotao">
        </fieldset>
    </form>
  </body>
</html>