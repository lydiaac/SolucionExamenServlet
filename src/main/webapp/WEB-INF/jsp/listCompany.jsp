<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Companies</title>
</head>
<body>

	<h2>LIST COMPANIES</h2>
	
	 <c:if test="${not empty listAllCompanies}">
		<table border="1">
			<thead>
				<tr>
					<td>ID</td>
					<td>Company</td>
					<td>Creation date</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="comp" items="${listAllCompanies}">
					<tr>
						<td><c:out value="${comp.id}" /></td>
						<td><c:out value="${comp.name}" /></td>
						<td><c:out value="${comp.creationDate}" /></td>
						<td><a href="/deleteCompany?id=${comp.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>