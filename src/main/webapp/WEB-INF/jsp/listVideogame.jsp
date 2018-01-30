<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List videogames</title>
</head>
<body>

	<h2>LIST VIDEOGAMES</h2>

	<c:if test="${not empty listAllVideogames}">
		<table border="1">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Recomended age</td>
					<td>Release date</td>
					<td>ConsoleId</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vid" items="${listAllVideogames}">
					<tr>
						<td><c:out value="${vid.id}" /></td>
						<td><c:out value="${vid.name}" /></td>
						<td><c:out value="${vid.recomendedAge}" /></td>
						<td><c:out value="${vid.releaseDate}" /></td>
						<td><c:out value="${vid.consoleId}" /></td>
						<td><a href="/deleteVideogame?id=${vid.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>