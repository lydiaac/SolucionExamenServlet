<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.Console"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Consoles</title>
</head>
<body>

	<h2>LIST CONSOLES</h2>

	<form action="listConsole" method="post">
		<input type="submit" value="See consoles">
	</form>
	<br/>
	<%
		List<Console> consoles = (List<Console>) request.getAttribute("listAllConsoles");
		pageContext.setAttribute("consoles", consoles);
	%>

	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>CompanyId</td>
			</tr>
		</thead>
		<tbody>
			<%
				if (null != consoles && !consoles.isEmpty()) {
					for (Console con : consoles) {
						out.println("<tr>");
						out.println("<td>");
						out.println(con.getId());
						out.println("</td>");
						out.println("<td>");
						out.println(con.getName());
						out.println("</td>");
						out.println("<td>");
						out.println(con.getCompanyId());
						out.println("</td>");
						out.println("<td>");
						out.println("<a href=" + '"' + "/deleteConsole?id=" + con.getId() + '"' + ">Delete</a>");
						out.println("</td>");
						out.println("</tr>");
					}
				}
			%>
		</tbody>
	</table>
</body>
</html>