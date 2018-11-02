<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JavaServer Pages Standard Tag Library</title>
</head>
<body>

	<c:forEach var="i" begin="1" end="10" step="2">
       ${i} <br />
	</c:forEach>

	<ul>
		<c:forEach items="${ empresas }" var="emp">
			<!-- chama o emp.getNome() -->
			<li>${ emp.nome } - <fmt:formatDate value="${ emp.dataAbertura }" pattern="dd/MM/yyyy"/></li>
		</c:forEach>
	</ul>

</body>
</html>