<%-- 
    Document   : Logout
    Created on : 16 Mar, 2020, 10:23:56 AM
    Author     : rgukt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
      
           <%
               

        request.getSession().invalidate();
        String redirectURL = "index.html";
        response.sendRedirect(redirectURL);
           %>
   
    </body>
</html>
