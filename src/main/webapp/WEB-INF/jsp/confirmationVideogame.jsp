<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete confirmation</title>
</head>
<body>

	<h3>Are you sure?</h3>

	<form:form action="deleteVideogame" method="post">
		<form:input type='text' path='id' value="${id}" />
		<input type="submit" value="Yes">
	</form:form>

</body>
</html>