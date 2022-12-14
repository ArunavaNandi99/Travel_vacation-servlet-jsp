<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vacation Registration</title>
</head>
<body>
<form action="vacationServlet" method="post" enctype="multipart/form-data">
Hotel Name:<input type="text" name ="hname" required><br/>
Description:<textarea rows="2" cols="" name="description" required></textarea><br/>
Type:<select name="type">
<option>hotel</option>
<option>resorts</option>
<option>cruise</option>
</select><br/>
location:<select name="city">
<option>Mumbai</option>
<option>Goa</option>
<option>Puri</option>
<option>Kolkata</option>
</select><br/>
NumerOfDays :<input type="text" name="numberofdays" required><br/>
Price:<input type="text" name="price" required><br/>
ValidTill:<input type="text" name ="validTill"><br/>
SoldOut:<select name="soldout">
<option>True</option>
<option>False</option>
</select><br/>
Image:<input type="file" name="image" required><br/>
<input type="submit" value="submit">
</form>
<%
String add = (String)session.getAttribute("vacation");
if(add != null)
{%>
	<b><%= add %></b>
	
<% 
session.removeAttribute("vacation");
}
%>

</body>
</html>