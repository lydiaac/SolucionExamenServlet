<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Companies</title>
</head>
<body>

	<form action="listCompany" method="post">
		<input type="submit" value="ver listado">
	</form>
	
	<% 
 List<Company> companies = (List<Company>)request.getAttribute("listAllCompanies");
 pageContext.setAttribute("companies", companies);
%>


	<table border="1">
		<thead>
			<tr>
				<td>Company</td>
				<td>Creation date</td>
			</tr>
		</thead>
		<tbody>
			<%
				if (null != companies && !companies.isEmpty()) {
					for (Company com : companies) {
						out.println("<tr>");
						out.println("<td>");
						out.println(com.getName());
						out.println("</td>");
						out.println("<td>");
						out.println(com.getCreationDate());
						out.println("</td>");

						
						out.println("<td>");
						out.println("<a href="+'"'+"/deleteCompany?name=" + com.getName() + '"' +">borrar</a>");
						out.println("</td>");
						

						out.println("</tr>");
					}

				}
			%>
		</tbody>
	</table>
</body>
</html>