<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.Console"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Videogame</title>
</head>
<body>
	<h2>FORM VIDEOGAME</h2>
	
	<form action="listConsoleDropDown" method="post">
		<input type="submit" value="See consoles">
	</form>
	<br/>
	<%
		List<Console> consoles = (List<Console>) request.getAttribute("listAllConsoles");
		pageContext.setAttribute("consoles", consoles);
	%>
	
	<form action="registerVideogame" method="post">
		<span>Name:</span> 
		<input type="text" name="name">
		<br /> 
		<span>Recomended Age:</span> 
		<input type="text" name="recomendedAge">
		<br /> 
		<span>Release Date:</span> 
		<input type="date" name="releaseDate">
		<br /> 
		<span>Console:</span>
		<select name="consoleId">
		
		<%		
		if (null != consoles && !consoles.isEmpty()) {
			for (Console con : consoles) {
				out.println("<option value="+con.getId() +">"+ con.getName() +"</option>");
			}
		}
		%>
				
		</select>	
		<br/>
		 <input type="submit" value="Submit">
	</form>
</body>
</body>
</html>