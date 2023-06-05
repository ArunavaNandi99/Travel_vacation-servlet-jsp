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

                                <% Long data=(Long)session.getAttribute("data");%>
                                    <div>
                                        <div class="container-fluid pt-3">
                                            <div class="card">
                                                <h1 class="card-header"> Original Data</h1>
                                                <div class="card-body">
                                                    <p>Original Number : <%= data %>
                                                    </p>
                                                </div>
                                                <div>
                                                    <a class="btn btn-primary" href="/project1/profile">Back</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <% } %>

        </body>

        </html>