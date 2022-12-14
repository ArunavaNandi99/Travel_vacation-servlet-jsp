<%@page import="com.project1.DAO.CartDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project1.db.DBConnection"%>
<%@page import="com.project1.DAO.VacationDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.project1.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
if ((request.getSession(false).getAttribute("userDetails") == null)) {
%>
<jsp:forward page="/login"></jsp:forward>
<%
}
%>


<!-- logout -->

<%
User user2 = (User) session.getAttribute("userDetails");

if (user2 == null) {
	response.sendRedirect("/project1/login");
	session.setAttribute("Login-error", "Please Login");

}
 ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cartList");
if (cart_list != null) {
	VacationDAO dao = new VacationDAO(DBConnection.getConnection());
	Integer cartProduct1 = dao.getTotalCartPrice(cart_list);
	Integer total = dao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);

} 
%>


<!DOCTYPE html>
<html>
<head>
<%@ include file="all_component/allcss.jsp"%>
<meta charset="ISO-8859-1">
<title>Cart page</title>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	<%
	Vacation vacation = new Vacation();
	%>

	<div class="d-flex py-3">
		<h3>Total price :</h3>
		<a class="mx-3 btn btn-primary" href="#">Check Out</a>
	</div>

	<table class="table text-center">
		<thead>
			<tr>

				<th>HotelName</th>
				<th>Description</th>
				<th>City</th>
				<th>Type</th>
				<th>Price</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>
			<%
			CartDao dao = new CartDao(DBConnection.getConnection());
			List<Cart> cart = dao.getVacationByUser(user2.getId());
			int totalPrice = 0;
			for(Cart c: cart){
				totalPrice = c.getTotalPrice();
			%>

			<tr>

				<td><%=c.getHname() %></td>
				<td><%=c.getDescription() %></td>
				<td><%= c.getCity() %></td>
				<td><%=c.getType() %></td>
				<td><%= c.getPrice() %></td>
				<td><a href="remove_from_cart?id=<%= c.getCid() %>">Remove</a></td>

			</tr>
			<%
			}
			%>

			<tr>
			<td><%= totalPrice %></td>
			</tr>
		</tbody>
		
		
		

	</table>

</body>
</html>