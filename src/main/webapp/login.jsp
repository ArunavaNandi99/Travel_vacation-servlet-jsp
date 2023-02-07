<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="all_component/allcss.jsp"%>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<%
if ((request.getSession(true).getAttribute("userDetails") != null)) {
%>
<jsp:forward page="/welcome"></jsp:forward>
<%
}
%>
<body>
	<%@ include file="all_component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center">
						<i class="fa fa-sign-in" aria-hidden="true"></i>
						<h4>Login</h4>
					</div>
					<%
					String loginFailed = (String) session.getAttribute("loginFailed");
					if (loginFailed != null) {
					%>
					<b><%=loginFailed%> </b>

					<%
					session.removeAttribute("loginFailed");
					}
					%>
					<br /> <br />
					<%
					String logoutMsg = (String) session.getAttribute("logoutMsg");

					if (logoutMsg != null)

					{
					%>
					<%=logoutMsg%>


					<%
					session.removeAttribute("logoutMsg");
					}
					%>
					<br />
					<%
					String LoginError = (String) session.getAttribute("Login-error");

					if (LoginError != null) {
					%>
					<%=LoginError%>


					<%
					session.removeAttribute("Login-error");
					}
					%>


					<div class="card-body">

						<form action="loginServlet" method="post" >
							<div class="form-group text-center">
								UserName<input type="text" name="username">
							</div>
							<div class="form-group text-center">
								Password<input type="password" name="password" >
							</div>
							<div class="form-group text-center">
								<input type="submit" value="Login">

							</div>
							<div class="text align-center">
								<b>Register Here<a href="/project1/register">SignUp</a></b>
							</div>
						</form>

					</div>

				</div>

			</div>

		</div>

	</div>


</body>
</html>