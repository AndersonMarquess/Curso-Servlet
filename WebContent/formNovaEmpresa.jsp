<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <c:url value="/NovaEmpresa"/> igual /Curso-Servlet/NovaEmpresa --%>
<c:url value="/NovaEmpresa" var="linkNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${ linkNovaEmpresa }" method="POST">
		Nome: <input name="nome" type="text" />
		<button type="submit">Cadastrar</button>
	</form>

</body>
</html>