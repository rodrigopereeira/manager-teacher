<html>
<head>
	<title>Alterar Sala</title>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../menu.jsp" />
	<form action="alteraSala" method="post">
		<div class="fundoTitulo">
    		<p class="tituloForm">Alterar Sala - ${sala.nome}</p>
    	</div>
    	<br>
		<fieldset class="formulario">
  
	    	<label for="codigoSala">ID:</label>
	    		<input type="text" name="codigoSala" id="codigoSala" class="inputPequeno" value="${sala.codigoSala}" readonly> <br>
	    		    		
	    	<label for="numeroSala">Número da Sala:</label>
	    		<input type="text" name="numeroSala" id="numeroSala" class="inputPequeno" value="${sala.numeroSala}"> <br>
	    	    		
	    	<label for="nome">Nome:</label>
	    		<input type="text" name="nome" id=nome class="inputPequeno" value="${sala.nome}"> <br>
	    	    		
	    	<label for="capacidade">Capacidade:</label>
	    		<input type="text" name="capacidade" id="capacidade" class="inputPequeno" value="${sala.capacidade}"> <br>
	    		    		
	    	<input type="submit" value="Alterar" class="novoBotao"> 
	    	<input type="reset" value="Cancelar" class="novoBotao">
	    		<a href="listaSalas"><input type="submit" value="Voltar" class="novoBotao"></a>
	    			

        </fieldset>
	</form>
</body>
</html>