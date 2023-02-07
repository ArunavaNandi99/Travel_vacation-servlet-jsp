<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="all_component/allcss.jsp"%>
<meta charset="ISO-8859-1">
<title>Error page</title>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	<!-- city not found -->
	<%
	response.setHeader("Cache-Control", "no-cache ,no-store, must-revalidate");
	String notFound = (String) session.getAttribute("not_found");

	if (notFound != null) {
	%>
	<div align="center">
		<b><%=notFound%></b>
	</div>
	<%	
	}
	%>

</body>
</html>