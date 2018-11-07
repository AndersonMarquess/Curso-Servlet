<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/" var="linkLogin"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${ linkLogin }" method="POST">
		senha: <input name="login" type="text" />
		<br/>
		Senha: <input name="senha" type="password" />
		<input type="hidden" value="LoginForm" name="acao"/>
		<button type="submit">Cadastrar</button>
	</form>

</body>
</html>