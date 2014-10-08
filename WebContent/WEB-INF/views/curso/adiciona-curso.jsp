<html>
  <head>
  	<title>Cadastro de Curso</title>
  	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
  </head>
  <body>

  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<c:import url="../menu.jsp" />
  	
    <form action="adicionaCurso" method="post">
    	<div class="fundoTitulo">
    		<p class="tituloForm">Novo Curso</p>
    	</div>
    	<br>
    	<fieldset class="formulario" >

	    	<label for="nome">Nome:</label>
	    		<input type="text" name="nome" id="nome" class="inputPequeno">
	    		<form:errors path="curso.nome" cssStyle="color:red"/> <br>
	    		
	    	<label for="descricao">Descrição:</label>
	    		<input type="text" name="descricao" id="descricao" class="inputPequeno" > <br>
	    		
	    	<label for="especialidade1">Especialidade 1:</label>  			
	    		<select  name="codigoEspecialidade1" id="codigoEspecialidade1" class="select">
	    			<c:forEach items="${especialidades}" var="esp1">  
				       <option value="${esp1.codigoEspecialidade}">${esp1.descricao}</option>  
					</c:forEach>
				</select> <br>
	 	
   			<label for="especialidade2">Especialidade 2:</label>
   				<select  name="codigoEspecialidade2" id="codigoEspecialidade2" class="select">
   					<c:forEach items="${especialidades}" var="esp2">  
				       <option value="${esp2.codigoEspecialidade}">${esp2.descricao}</option>  
					</c:forEach>
			    </select> <br>
	
	    	<label for="especialidade3">Especialidade:</label>
	    		<select  name="codigoEspecialidade3" id="codigoEspecialidade3" class="select">
	    			<c:forEach items="${especialidades}" var="esp3">  
				       <option value="${esp3.codigoEspecialidade}">${esp3.descricao}</option>  
					</c:forEach>
				</select> <br>
	    			
	    	<input type="submit" value="Adicionar" class="novoBotao"> 
	    	<input type="reset" value="Cancelar" class="novoBotao">

        </fieldset>
    </form>
  </body>
</html>