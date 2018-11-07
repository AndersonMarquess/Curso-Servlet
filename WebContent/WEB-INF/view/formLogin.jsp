<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/" var="linkLogin"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${ not empty erroLogin }">
		<p style="color:red;">${ erroLogin }</p>
	</c:if>

	<br/>

	<form action="${ linkLogin }" method="POST">
		Login: <input name="login" type="text" />
		<br/>
		Senha: <input name="senha" type="password" />
		<br/>
		<input type="hidden" value="AutenticarUsuario" name="acao"/>
		<button type="submit">Cadastrar</button>
	</form>

</body>
</html>