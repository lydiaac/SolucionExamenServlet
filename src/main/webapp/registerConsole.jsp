<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.Company"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Console</title>
</head>
<body>
	<h2>FORM CONSOLE</h2>
	
	<form action="listCompanyDropDown" method="post">
		<input type="submit" value="See companies">
	</form>
	<br/>
	<%
		List<Company> companies = (List<Company>) request.getAttribute("listAllCompanies");
		pageContext.setAttribute("companies", companies);
	%>

	<form action="registerConsole" method="post">
		<span>Name:</span> 
		<input type="text" name="name">
		<br /> 
		<span>Company:</span>
		<select name="companyId">
		<%		
			if (null != companies && !companies.isEmpty()) {
				for (Company com : companies) {
					out.println("<option value="+com.getId() +">"+ com.getName() +"</option>");
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