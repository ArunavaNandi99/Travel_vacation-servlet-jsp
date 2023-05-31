<%@page import="com.project1.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="all_component/allcss.jsp"%>
<title>profile</title>
</head>
<body>
<!-- navbar -->
<%@ include file="all_component/navbar.jsp"%>
<div>

<h1>Account Details </h1>

<div>
            <%
			User userDetails = (User) session.getAttribute("userDetails");

			if (userDetails != null) {
			%>
            <label>username</label>
            <p><%= userDetails.getUsername() %> </p>

            <label>First Name</label>
            <p><%= userDetails.getFname() %> </p>

            <label>Last Name</label>
            <p><%= userDetails.getLname() %> </p>

            <label>phone Number</label>
            <p><%= userDetails.getPhoneNumber() %> </p>

            <label>Email</label>
            <p><%= userDetails.getEmail() %> </p>

			<%
            }
            %>

</div>

</div>
</body>
</html>