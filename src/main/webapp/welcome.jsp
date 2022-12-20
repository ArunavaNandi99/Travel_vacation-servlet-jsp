<%@page import="com.project1.DAO.CartDao"%>
<%@page import="com.project1.entity.*"%>
<%@page import="com.project1.entity.Vacation"%>
<%@page import=" com.project1.DAO.VacationDAO"%>
<%@page import="com.project1.db.DBConnection"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
VacationDAO vacationDAO = new VacationDAO(DBConnection.getConnection());
List<Vacation> vacations = vacationDAO.allVacation();
request.setAttribute("vacationList", vacations);

response.setHeader("Cache-Control", "no-cache ,no-store,must-revalidate");

%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="all_component/allcss.jsp"%>
<meta charset="ISO-8859-1">
<title>Travel Vacation</title>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>

	

	<table class="table text-center" >
	
		<tr >
			<th>Image</th>
			<th>City</th>
			<th>Action</th>
		</tr>

			<tr>
				<td><img src="images\HOTEL.png" height="100"></td>
				<td>Mumbai</td>
				<td><a href="locationServlet?city=mumbai">Details</a></td>
			</tr>
			<tr>
				<td><img src="images\png-clipart-azul-hotel-restaurant-computer-icons-boutique-hotel-gratis-hotel-text-rectangle-thumbnail.png" height="100"></td>
				<td>Goa</td>
				<td><a href="locationServlet?city=goa">Details</a></td>
			</tr>
			<tr>
				<td><img src="images\pngtree-hotel-icon-for-personal-and-commercial-use-png-image_1044892.jpg" height="100"></td>
				<td>Puri</td>
				<td><a href="locationServlet?city=puri">Details</a></td>
			</tr>
			<tr>
				<td><img src="images\HOTEL.png" height="100"></td>
				<td>Kolkata</td>
				<td><a href="locationServlet?city=kolkata">Details</a></td>
			</tr>

		
		
		
	</table>
	
	
	
</body>
</html>