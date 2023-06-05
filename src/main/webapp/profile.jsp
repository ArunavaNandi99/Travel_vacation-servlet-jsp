<!-- ShowError -->
<%@ page errorPage="errorPage.jsp" %>


    <%@page import="com.project1.entity.User" %>
        <!DOCTYPE html>
        <html>

        <head>
            <%@ include file="all_component/allcss.jsp" %>
                <title>profile</title>
        </head>

        <body>

            <% if ((request.getSession(false).getAttribute("userDetails")==null)) { %>
                <jsp:forward page="/login"></jsp:forward>
                <% } %>

                    <% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate" ); %>

                        <% User user2=(User) session.getAttribute("userDetails"); if (user2==null) {
                            response.sendRedirect("/project1/login"); session.setAttribute("Login-error", "Please Login"
                            ); }else{ %>

                            <!-- navbar -->
                            <%@ include file="all_component/navbar.jsp" %>
                                <div class="container-fluid">
                                    <div class="card">
                                        <h1 class="card-header"> Account Details </h1>
                                        <div class="card-body">
                                            <% User userDetails=(User) session.getAttribute("userDetails"); if
                                                (userDetails !=null) { %>
                                                <div>
                                                    <label for="username">UserName : <p id="username">
                                                            <%= userDetails.getUsername() %>
                                                        </p></label>
                                                </div>
                                                <div <label for="fname">First Name : <p id="fname">
                                                        <%= userDetails.getFname() %>
                                                    </p></label>
                                                </div>
                                                <div <label for="lname">Last Name : <p id="lname">
                                                        <%= userDetails.getLname() %>
                                                    </p></label>
                                                </div>
                                                <div <label for="email">Email : <p id="email">
                                                        <%= userDetails.getEmail() %>
                                                    </p></label>
                                                </div>
                                                <div>
                                                    <label id="phone">PhoneNumber : <p id="phone">
                                                            <%= userDetails.getPhoneNumber() %>
                                                        </p>
                                                        <div>
                                                            <form action="/project1/decrypt" method="POST">
                                                                <input type="hidden" name="command" value="SHOW">
                                                                <input type="hidden" name="phoneNumber"
                                                                    value="<%= userDetails.getPhoneNumber() %>">
                                                                <input class="btn btn-outline-success" type="submit"
                                                                    id="show" value="show">
                                                            </form>
                                                        </div>
                                                    </label>
                                                </div>


                                                </br>
                                                </br>
                                                <!--
            <div>
            <form action = "/encrypt" method = "POST">
                <input type = "hidden" name = "command" value = "HIDE">
                <input type = "submit" id = "hide" value = "Hide">
            </form>
            </div
            -->
                                                <% } %>

                                        </div>
                                    </div>

                                    <!--
<script>
    function showButton() {
      document.getElementById("hide").style.display = "none";
      document.getElementById("show").style.display = "inline";
    }

    function hideButton() {
      document.getElementById("show").style.display = "none";
      document.getElementById("hide").style.display = "inline";
    }

function toggleButton(){
    let button = document.getElementById("toggleButton");

    if(button.innerHTML === "Show"){
    button.innerHTML = "Hide";
    }else{
    button.innerHTML = "Show";
    }
    }
</script>
-->

                                    <!--
<form action="/project1/decrypt" method ="POST">
<label>PhoneNumber</label>
<input type ="text" name="phoneNumber" placeholder="Enter PhoneNumber">
<input type="submit" value="decrypt">
</form>

<% Long data = (Long)session.getAttribute("data");%>

<h2><%= data %></h2>
-->
                                </div>
                                <% } %>

        </body>

        </html>