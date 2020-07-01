<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
//String id = request.getParameter("uname");
String id=(String)session.getAttribute("name"); 
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "netbeans";
String userid = "root";
String password = "rgukt123";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
PreparedStatement ps=null;
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
 <h1>Your orders</h1>
 <form action="deletearrived" method="post">
     <input type="submit" value="Delete from databse">
 </form>
<table border="2">
<tr>

<td>User</td>
<td>From</td>
<td>To</td>
<td>Date</td>
<td>Volume</td>
<td>Status</td>
<td>Id</td>


</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
//statement=connection.createStatement();
//String sql ="select * from clientorder where unmae=?";
ps=connection.prepareStatement("select * from clientorder where destination=? && OrderStatus=?");
ps.setString(1, id);
ps.setString(2,"assigned");
resultSet = ps.executeQuery();
while(resultSet.next()){
%>
<tr>
 
<td><%=resultSet.getString("uname") %></td>
<td><%=resultSet.getString("froms") %></td>
<td><%=resultSet.getString("destination") %></td>
<td><%=resultSet.getString("condate") %></td>
<td><%=resultSet.getString("convolume") %></td>
<td><%=resultSet.getString("OrderStatus") %></td>
<td<%=resultSet.getString("oid")%></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>