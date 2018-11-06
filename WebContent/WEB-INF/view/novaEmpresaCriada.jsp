<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String nomeEmpresaParse = (String) request.getAttribute("nomeEmpresa");
	System.out.println("Funciona igual ao @() no ASP.NET "+nomeEmpresaParse);
	String vazio = "";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeiro JSP</title>
</head>
<body>

	<c:if test="${ not empty nomeEmpresa }">
		<label>Cadastro da empresa: <% out.print(nomeEmpresaParse); %> efetuado com sucesso. -- </label>
		
		<br/>ou<br/>
		
		<label>Cadastro da empresa: <%= nomeEmpresaParse %> efetuado com sucesso. - </label>
		
		<br/>ou<br/>
		
		<label>Cadastro da empresa: ${ nomeEmpresa } efetuado com sucesso. + </label>
	</c:if>
	
	<c:if test="${ empty vazio }">
		<p>Uma forma de usar o if - empty.</p>
	</c:if>
	
</body>
</html>