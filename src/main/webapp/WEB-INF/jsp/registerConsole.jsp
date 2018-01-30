<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Console</title>
</head>
<body>
	<h2>FORM CONSOLE</h2>
	
	<form:form action="registerConsole" method="post">
		<span>Name:</span> 
		<form:input type="text" path="name"/>
		<br /> 
		<span>Company:</span>
		<form:select path="companyId">
		 	<c:forEach var="comp" items="${listAllCompanies}">
		 		<form:option value="${comp.id}">${comp.name}</form:option>
		 	</c:forEach>
		</form:select> 
		<br/>
		 <input type="submit" value="Submit">
	</form:form>
</body>
</body>
</html>