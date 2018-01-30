<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.io.*,java.util.*,es.salesianos.model.Console,es.salesianos.model.Company"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Consoles from Company</title>
</head>
<body>

	<h2>Consoles from Company</h2>

	<form action="listConsolesCompany" method="post">
		<span>Select a company:</span>
		 <select name="companyId">
		 	<c:forEach var="comp" items="${listAllCompanies}">
		 		<option value="${comp.id}">${comp.name}</option>
		 	</c:forEach>
		</select> 
		<br /> 
		<input type="submit" value="Search">
	</form>

	<h4>List consoles:</h4>
	
	<c:if test="${not empty listAllCompanies}">
		<table border="1">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>CompanyId</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="con" items="${listAllConsoles}">
					<tr>
						<td><c:out value="${con.id}" /></td>
						<td><c:out value="${con.name}" /></td>
						<td><c:out value="${con.companyId}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>