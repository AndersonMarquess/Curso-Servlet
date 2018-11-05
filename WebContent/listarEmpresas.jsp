<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%-- <c:url value="/remover"/> igual /Curso-Servlet/remover --%>
<c:url value="/remover" var="linkRemoverEmp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JavaServer Pages Standard Tag Library</title>
</head>
<body>
	<c:if test="${ not empty nomeEmpresa }">
		<label>Cadastro da empresa: ${ nomeEmpresa } efetuado com sucesso.</label>
	</c:if>
	
	<br/>
	<br/>

	<c:forEach var="i" begin="1" end="10" step="2">
       ${i} <br />
	</c:forEach>

	<ul>
		<c:forEach items="${ empresas }" var="emp">
			<!-- chama o emp.getNome() -->
			<li>
				${ emp.nome }- <fmt:formatDate value="${ emp.dataAbertura }" pattern="dd/MM/yyyy" />
				
				<form action="${ linkRemoverEmp }" method="post">
					<input type="hidden" name="id" value="${ emp.id }">
					<button type="submit">Remover</button>
				</form>
			</li>
		</c:forEach>
	</ul>

</body>
</html>