<html>
  <head>
  	<title>Cadastro de Sala</title>
  	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
  </head>
  <body>

  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
	<c:import url="../menu.jsp" />
  	
    <form action="adicionaSala" method="post">
    	<div class="fundoTitulo">
    		<p class="tituloForm">Nova Sala</p>
    	</div>
    	<br>
    	<fieldset class="formulario">
 		
			<label for="numeroSala">Número da Sala:</label>
	    		<input type="number" name="numeroSala" id="numeroSala" class="inputPequeno" required><br>
	    		
	    	<label for="nome">Nome:</label>
	    		<input type="text" name="nome" id="nome" class="inputPequeno" required><br>
	    		
	    	<label for="capacidade">Capacidade:</label>
	    		<input type="number" name="capacidade" id="capacidade" class="inputPequeno" required><br>
	    		
	    	<input type="submit" value="Adicionar" class="novoBotao"> 
	    	<input type="reset" value="Cancelar" class="novoBotao">
	    						    		
        </fieldset>
    </form>
  </body>
</html>