<%@page import="com.project1.entity.Vacation"%>
<%@page import="java.util.List"%>
<%@page import="com.project1.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String city = request.getParameter("city");
List<Vacation> vac = (List<Vacation>) request.getAttribute("list");

if (vac.isEmpty()) {
	HttpSession session2 = request.getSession();
	session2.setAttribute("not_found", "Not found!");
	response.sendRedirect("/project1/error");
	
	response.setHeader("Cache-Control", "no-cache ,no-store,must-revalidate");
}
%>

<%
User user2 = (User) session.getAttribute("userDetails");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="all_component/allcss.jsp"%>
<meta charset="ISO-8859-1">
<title>List Of Vacation</title>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	<%
	Vacation va = new Vacation();
	%>

	<table class="table text-center">
		<tr>
			<th>Images</th>
			<th>Available Information</th>
			<th>Stay</th>
			<th>Price</th>
			<th>Action</th>



		</tr>
		<c:forEach var="v" items="${list}">
			<tr>
				<td><img src="images/${v.image}" height="100"></td>
				<td>
					<ul>
						<li>Hotel Name:${v.hname }</li>
						<li>Description:${v.description }</li>
						<li>Type:${ v.type}</li>
						<li>City:${v.city }</li>
						<li>ValidTill:${v.validTill }</li>
						<li>SoldOut:${v.soldout }</li>
					</ul>
				</td>
				<td>${v.numberofdays }</td>
				<td>${v.price }</td>

				<%
				if (user2 == null) {
				%>
				<td align="center"><a href="/project1/login">Book Now</a></td>
				<%
				} else {
				%>
				<td align="center"><a
					href="addToCart?vid=${v.id}&uid=<%= user.getId() %>">Book Now</a></td>
				<%
				}
				%>
			</tr>
		</c:forEach>

	</table>




</body>
</html>