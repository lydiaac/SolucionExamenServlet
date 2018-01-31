<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Consoles from Company</title>
</head>
<body>

	<h2>Consoles from Company</h2>

	<form:form action="listConsolesCompany" method="post">
		<span>Select a company:</span>
		 <form:select path="companyId">
		 	<c:forEach var="comp" items="${listAllCompanies}">
		 		<form:option value="${comp.id}">${comp.name}</form:option>
		 	</c:forEach>
		</form:select> 
		<br /> 
		<input type="submit" value="Search">
	</form:form>

	<h4>List consoles:</h4>
	
	<c:if test="${not empty listAllConsoles}">
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