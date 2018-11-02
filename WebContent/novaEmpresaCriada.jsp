
<%
	String nomeEmpresaParse = (String) request.getAttribute("nomeEmpresa");
	System.out.println("Funciona igual ao @() no ASP.NET "+nomeEmpresaParse);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeiro JSP</title>
</head>
<body>
	<label>Cadastro da empresa: <% out.print(nomeEmpresaParse); %> efetuado com sucesso.</label>
	<br/>
	ou
	<br/>
	<label>Cadastro da empresa: <%= nomeEmpresaParse %> efetuado com sucesso.</label>
	<br/>
	ou
	<br/>
	<label>Cadastro da empresa: ${ nomeEmpresa } efetuado com sucesso.</label>
</body>
</html>