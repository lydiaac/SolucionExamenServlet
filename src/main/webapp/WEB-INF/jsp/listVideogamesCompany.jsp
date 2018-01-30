<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.Videogame,es.salesianos.model.Company"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Videogames from Company</title>
</head>
<body>

	<h2>Videogames from Company</h2>

	<form action="listDropDownCompaniesVideogame" method="post">
		<input type="submit" value="See companies">
	</form>
	<br/>

	<form action="listVideogamesCompany" method="post">
		<span>Select a company:</span>
		 <select name="companyId">
		 	<c:forEach var="comp" items="${listAllCompanies}">
		 		<option value="${comp.id}">${comp.name}</option>
		 	</c:forEach>
		</select> 
		<br /> 
		<input type="submit" value="Search">
	</form>
	
	<h4> List videogames: </h4>
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
</body>
</html>