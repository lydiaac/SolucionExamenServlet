<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.Videogame"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List recommended age</title>
</head>
<body>

	<h2>VIDEOGAMES</h2>

	<form action="listRecommendedAge" method="post">
		<span>Select a recommended age:</span> 
		<select name="age">
			<option value="TP">TP</option>
			<option value="07">+7</option>
			<option value="13">+13</option>
			<option value="18">+18</option>
		</select> 
		<br />
		<span>Order:</span> 
		<select name="order">
			<option value="alphabetically">Alphabetically</option>
			<option value="date">By release date</option>
		</select>
		<br/>
		<input type="submit" value="Search">
	</form>
	
	<%
		List<Videogame> videogames = (List<Videogame>) request.getAttribute("listAllVideogames");
		pageContext.setAttribute("videogames", videogames);
	%>
	
	<h4> List videogames: </h4>
	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Recomended age</td>
				<td>Release date</td>
				<td>ConsoleId</td>
			</tr>
		</thead>
		<tbody>
			<%
				if (null != videogames && !videogames.isEmpty()) {
					for (Videogame videogame : videogames) {
						out.println("<tr>");
						out.println("<td>");
						out.println(videogame.getId());
						out.println("</td>");
						out.println("<td>");
						out.println(videogame.getName());
						out.println("</td>");
						out.println("<td>");
						out.println(videogame.getRecomendedAge());
						out.println("</td>");
						out.println("<td>");
						out.println(videogame.getReleaseDate());
						out.println("</td>");
						out.println("<td>");
						out.println(videogame.getConsoleId());
						out.println("</td>");
						out.println("</tr>");
					}
				}
			%>
		</tbody>
	</table>
</body>
</html>