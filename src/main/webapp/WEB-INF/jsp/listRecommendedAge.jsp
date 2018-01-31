<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List recommended age</title>
</head>
<body>

	<h2>VIDEOGAMES</h2>

	<form:form action="listRecommendedAge" method="post">
		<span>Select a recommended age:</span> 
			<form:select path="age">
				<form:option value="TP">TP</form:option>
				<form:option value="07">+7</form:option>
				<form:option value="13">+13</form:option>
				<form:option value="18">+18</form:option>
			</form:select> 
		<br /> 
		<span>Order:</span> 
			<form:select path="order">
				<form:option value="alphabetically">Alphabetically</form:option>
				<form:option value="date">By release date</form:option>
			</form:select>
		<br /> 
		<input type="submit" value="Search">
	</form:form>

	<h4>List videogames:</h4>
	
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>