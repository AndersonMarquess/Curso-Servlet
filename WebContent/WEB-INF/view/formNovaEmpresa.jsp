<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <c:url value="/"/> igual /Curso-Servlet/?acao=NovaEmpresa --%>
<c:url value="/" var="linkNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${ linkNovaEmpresa }" method="POST">
		Nome: <input name="nome" type="text" />
		<br/>
		Data Abertura: <input name="data" type="text" />
		<input type="hidden" value="NovaEmpresa" name="acao"/>
		<button type="submit">Cadastrar</button>
	</form>

</body>
</html>