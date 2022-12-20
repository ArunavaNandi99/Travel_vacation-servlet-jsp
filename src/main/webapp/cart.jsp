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

CartDao dao = new CartDao(DBConnection.getConnection());
List<Cart> cart = dao.getVacationByUser(user2.getId());
if (cart != null) {
	HttpSession session2 = request.getSession();
	session2.setAttribute("cartList", cart);
}
%>
<%
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cartList");
CartDao cDao = new CartDao(DBConnection.getConnection());
Integer total =  cDao.getTotalCartPrice(cart_list);
request.setAttribute("total", total);

response.setHeader("Cache-Control", "no-cache ,no-store,must-revalidate");

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
		<h3>Total price :$ ${total}</h3>
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
			for (Cart c : cart) {
			%>

			<tr>

				<td><%=c.getHname() %></td>
				<td><%=c.getDescription()%></td>
				<td><%=c.getCity()%></td>
				<td><%=c.getType()%></td>
				<td><%=c.getPrice()%></td>
				<td><a href="removeFormCart?id=<%=c.getCid()%>">Remove</a></td>

			</tr>
			<%
			}
			%>

			

		</tbody>




	</table>

</body>
</html>