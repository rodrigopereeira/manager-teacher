<html>
  <head>
  	<title>Matricula de Aluno</title>
  	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
  	
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  	
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	
  </head>
  <body>
  	
	<c:import url="../menu.jsp" />
	<form action="selecionarTurma" method="post">
    	<fieldset class="formulario">
    		<br>
	    	<label for="codigoTurma">Curso:</label>	
	    		<select  name="codigoTurma" id="codigoTurma" class="select">
	    			<c:forEach items="${turmas}" var="t">  
						<option value="${t.codigoTurma}"> ${t.nome} + ${t.nomeCurso}</option>  
					</c:forEach>
				</select><br>
	    		
	    	<input type="submit" value="Selecionar" class="novoBotao"> 
	    	<input type="reset" value="Cancelar" class="novoBotao">

        </fieldset>
     </form>
  </body>
</html>