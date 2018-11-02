<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JavaServer Pages Standard Tag Library</title>
</head>
<body>
	
	
	
	<ul>
		<c:forEach items="${ empresas }" var="emp">
			<!-- chama o emp.getNome() -->
			<li>${ emp.nome }</li>
		</c:forEach>
	</ul>
	
</body>
</html>