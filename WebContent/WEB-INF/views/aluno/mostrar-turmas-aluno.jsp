<html>
<head>
	<title>Lista de Turmas do Aluno</title>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="resources/media/css/jquery.dataTables.css">
	  
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.js"></script>
	  
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="resources/media/js/jquery.dataTables.js"></script>
</head>
<body>	
	
	<c:import url="../menu.jsp" />
	
	
	<div class="containerConteudoMeio">
		<form action="presencasTurma" method="get" >
			<fieldset class="formulario">
			
				<label for="turma">Seleciona a turma:</label>
			    		<select  name="codigoTurma" id="codiogTurma" class="select" >
			    			<c:forEach items="${turmas}" var="p">  
						       <option value="${p.codigoTurma}">${p.nome}</option>  
							</c:forEach>
					    </select> <br>
					    
				<input type="submit" value="Visualizar Presencas" class="novoBotao" > 
				
			</fieldset>
		</form>
	</div>
</body>
</html>
