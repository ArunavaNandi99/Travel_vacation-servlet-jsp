<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="all_component/allcss.jsp"%>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center">
						<i class="fa fa-user-plus" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>
					<!-- Password and ConfirmPassword not match -->
					<%
					String pass = (String) session.getAttribute("password_no_match");

					if (pass != null) {
					%>
					<b><%=pass%></b>

					<%
					session.removeAttribute("password_no_match");
					}
					
					%>

					<!-- userAlreadyExist -->

					<%
					String userexist = (String) session.getAttribute("userexist");
					if (userexist != null) {
					%>
					<b><%=userexist%></b>

					<%
					session.removeAttribute("userexist");
					}
					%>


					<!-- All Fields are required -->
					<%
					String required = (String) session.getAttribute("required");
					if (required != null) {
					%>
					<b><%=required%></b>

					<%
					session.removeAttribute("required");
					}
					%>



					<div class="card-body">
						<form name="form" action="UserServlet" method="post"
							onsubmit="return validate()" >
							<div class="form-group text-center">
								UserName<input type="text" name="username"><br />
							</div>
							<div class="form-group text-center">
								FirstName<input type="text" name="fname"><br />
							</div>
							<div class="form-group text-center">
								LastName<input type="text" name="lname"><br />
							</div>
							<div class="form-group text-center">s
								PhoneNumber<input type="number" name="phoneNumber"><br />
							</div>
							<div class="form-group text-center">
								Email<input type="email" name="email"><br />
							</div>
							<div class="form-group text-center">
								Password<input type="password" name="password" id="password" ><br />
							</div>
							<div class="form-group text-center">
								ConfirmPassword<input type="password" name="confirmpassword"
									id="confirmpassword"><br />
							</div>
							<div class="form-group text-center">
								<input type="submit" value="Register">
							</div>
						</form>
						<b >Already Register?<a href="/project1/login">Login</a></b>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br />



	<!-- javaScript Validation -->

	<script type="text/javascript">
		function validate() {
			var password = document.form.password.value;
			var confirmpassword = document.form.confirmpassword.value;

			if (password != confirmpassword) {
				alert("password and confirm password dosen't match")
				return false;
			}
		}
	</script>
</body>
</html>