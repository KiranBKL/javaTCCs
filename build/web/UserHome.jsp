<%-- 
    Document   : UserHome
    Created on : 16 Mar, 2020, 9:59:14 AM
    Author     : rgukt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Royal Truck</title>
        <link rel="stylesheet" type="text/css" href="uhome.css">
    </head>
   <body>
       <%
           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0");

response.setHeader("Pragma", "no-cache");

response.setHeader("Expires", "0");
           %>
<header>
<div class="container">
	<div id="branding">
		<h1>Truck</h1>
	</div>
    <form action="Logout" method="POST">
	<nav>
		<ul>
			<li ><a href="#">Home</a></li>
			<li><a href="Request.jsp">Requests</a></li>
			<li><a href="Arrived.jsp">Arrived</a></li>
                        <li>  <a href="Logout.jsp">Logout</a></li>
		</ul>
	</nav>
        
    </form>
</div>
</header>
    
<h1>
Hello
<%=session.getAttribute("name")%></h1>
</body>
</html>