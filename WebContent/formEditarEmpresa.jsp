<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/editar" var="linkEditarEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${ linkEditarEmpresa }" method="POST">
		<input type="hidden" name="id" value="${ empresa.id }"/>
		Nome: <input name="nome" type="text" value="${ empresa.nome }"/>
		<br/>
		Data Abertura: <input name="data" type="text" value="${ empresa.dataBrowser }"/>
		<button type="submit">Cadastrar</button>
	</form>

</body>
</html>