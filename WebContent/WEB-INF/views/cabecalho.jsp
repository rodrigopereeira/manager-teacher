<head>
<title>Mantea - Inicio</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="resources/css/estiloHeader.css" type="text/css" rel="stylesheet"/>
<link rel="shortcut icon" href="resources/css/favicon.png" width="24" height="24">
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="topo">
    <div class="colunaLogo">
        <img src="resources/css/logo.png" height="60" alt="Logomarca MRNeT" />
    </div>
    <div class="colunaUsuario">
        <div class=" linhaUsuario">

        <jsp:useBean id="date" class="java.util.Date"/>

		<fmt:formatDate var="time" value="${date}" pattern="HH"/>
		<c:choose>
		     <c:when test="${time > 18}">
		       Boa Noite, 
		    </c:when>
		    <c:when test="${time < 05}">
		       Boa Noite, 
		    </c:when>
		    <c:when test="${time > 12}">
		        Boa Tarde, 
		    </c:when>
			<c:otherwise>
		        Bom Dia, 
		    </c:otherwise>
		</c:choose>
		${usuarioLogado.nome}
        </div>
    </div>
</div>
<nav>
  <ul class="menu">
  		<c:forEach items="${menu0}" var="menu0" varStatus="row">
  		<c:if test="${menu0.nivelMenu == 0 }">
  			<li>
  				<a href="${menu0.urlMenu}">${menu0.nomeMenu}</a>
  				<ul>
  					<c:forEach items="${menu1}" var="menu1" varStatus="row">
				  		<c:if test="${(menu1.nivelMenu == 1) and (menu1.codMenuPai == menu0.codMenu)}">
				  			<li>
				  				<a href="${menu1.urlMenu}">${menu1.nomeMenu}</a>
				  				<ul>
									<c:forEach items="${menu2}" var="menu2" varStatus="row">
								  		<c:if test="${(menu2.nivelMenu == 2) and (menu2.codMenuPai == menu1.codMenu) }">
								  			<li>
								  				<a href="${menu2.urlMenu}">${menu2.nomeMenu}</a>
								  			</li>						  		
								  		</c:if>	  		
								  	</c:forEach>
				  				</ul>
				  			</li>		
				  		</c:if>		
				  	</c:forEach>
  				</ul>
  			</li>
  		</c:if>
  		
  		</c:forEach>
                     
</ul>
</nav>
</body>
