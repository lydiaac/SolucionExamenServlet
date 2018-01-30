<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Consoles</title>
</head>
<body>

	<h2>LIST CONSOLES</h2>

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
						<td><c:out value="${con.id}"/> </td>
						<td><c:out value="${con.name}"/> </td>
						<td><c:out value="${con.companyId}"/> </td>
						<td><a href="/deleteConsole?id=${con.id}">Delete</a></td>
			    	</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>