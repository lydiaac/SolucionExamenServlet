<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Company</title>
</head>
<body>
	<h2>FORM COMPANY</h2>
	<form:form action="registerCompany" method="post">
		<span>Name:</span> 
		<form:input type="text" path="name" /> <br/>
		<span>Creation date:</span> 
		<form:input type="date" path="creationDate" /><br/>
		<input type="submit" value="Submit">
	</form:form>
	</body>
</body>
</html>