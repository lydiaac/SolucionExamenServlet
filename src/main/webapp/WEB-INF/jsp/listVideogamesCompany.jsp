<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Videogames from Company</title>
</head>
<body>

	<h2>Videogames from Company</h2>

	<form:form action="listVideogamesCompany" method="post">
		<span>Select a company:</span>
		 <form:select path="id">
		 	<c:forEach var="comp" items="${listAllCompanies}">
		 		<form:option value="${comp.id}">${comp.name}</form:option>
		 	</c:forEach>
		</form:select> 
		<br /> 
		<input type="submit" value="Search">
	</form:form>
	
	<h4> List videogames: </h4>
	
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
				<c:forEach var="vid" items="${listAllVideogames}">
					<tr>
						<td><c:out value="${vid.id}"/> </td>
						<td><c:out value="${vid.name}"/> </td>
						<td><c:out value="${vid.recomendedAge}"/> </td>
						<td><c:out value="${vid.releaseDate}"/> </td>
						<td><c:out value="${vid.consoleId}"/> </td>
			    	</tr>
				</c:forEach>
		</table>
	</c:if>
</body>
</html>