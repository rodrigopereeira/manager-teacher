<html>
<head>
	<title>Alterar Curso</title>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../menu.jsp" />
	<form action="alteraCurso" method="post">
		<div class="fundoTitulo">
    		<p class="tituloForm">Alterar Curso - ${curso.nome}</p>
    	</div>
    	<br>
		<fieldset class="formulario" >
		
	    	<label for="codigoCurso">ID:</label>
	    		<input type="text" name="codigoCurso" id="codigoCurso" class="inputPequeno" value="${curso.codigoCurso}" readonly> <br>
	    		
	    	<label for="nome">Nome:</label>
	    		<input type="text" name="nome" id="nome" class="inputPequeno" value="${curso.nome}"> <br>
	    		
	    	<label for="descricao">Descrição:</label>
	    		<input type="text" name="descricao" id="descricao" class="inputPequeno" value="${curso.descricao}"> <br>
	    	   		
	    	<label for="codigoEspecialidade1">Especialidade 1:</label>
	    		<select  name="codigoEspecialidade1" id="codigoEspecialidade1" class="select" >
	    			<c:forEach items="${especialidades}" var="esp1">   
	    				<c:choose>
	    					<c:when test="${ curso.codigoEspecialidade1 == esp1.codigoEspecialidade }">
			 					<option value="${esp1.codigoEspecialidade}" selected>${esp1.descricao}</option>  
						    </c:when>
							<c:otherwise>
								<option value="${esp1.codigoEspecialidade}">${esp1.descricao}</option>  
							</c:otherwise>
	    				</c:choose>
					</c:forEach>
				</select> <br>

	    	<label for="codigoEspecialidade2">Especialidade 2:</label>		
	    		<select  name="codigoEspecialidade2" id="codigoEspecialidade2" class="select">
	    			<c:forEach items="${especialidades}" var="esp2">  
	    				<c:choose>
	    					<c:when test="${ curso.codigoEspecialidade2 == esp2.codigoEspecialidade }">
								 <option value="${esp2.codigoEspecialidade}" selected>${esp2.descricao}</option>  
				      		</c:when>
				            <c:otherwise>
				        		<option value="${esp2.codigoEspecialidade}">${esp2.descricao}</option>  
				        	</c:otherwise>
	    				</c:choose>
					</c:forEach>
				</select> <br>
	    		
	    		<label for="codigoEspecialidade3">Especialidade 3:</label>	
	    			<select  name="codigoEspecialidade3" id="codigoEspecialidade3" class="select">
	    				<c:forEach items="${especialidades}" var="esp3">  
	    					<c:choose>
	    						<c:when test="${ curso.codigoEspecialidade3 == esp3.codigoEspecialidade }">
				    				 <option value="${esp3.codigoEspecialidade}" selected>${esp3.descricao}</option>  
					      		</c:when>
					        	<c:otherwise>
					       			<option value="${esp3.codigoEspecialidade}">${esp3.descricao}</option>  
					       		</c:otherwise>
	    					</c:choose>
						</c:forEach>
					</select> <br>

	    		<input type="submit" value="Alterar" class="novoBotao"> 
	    		<input type="reset" value="Cancelar" class="novoBotao">
	    			<a href="listaCursos"><input type="submit" value="Voltar" class="novoBotao"></a>
	    			
	    						    		
	    	
        </fieldset>
	</form>
</body>
</html>