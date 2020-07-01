
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
    <script>
function validate()
{
var num=document.reg.volume.value;

    if(isNaN(num))
    {
        alert("please enter number in volume field");
      return false;
    }
    
    else
    {
        return true;
    }


}
</script>
<body>
 <h1>Your orders</h1>
 <form method="post"  action="Controller1" onsubmit="return validate()" >
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
//statement=connection.createStatement();
//String sql ="select * from clientorder where unmae=?";
ps=connection.prepareStatement("select * from clientorder where froms=? and OrderStatus=?");
ps.setString(1, id);
ps.setString(2, "notassigned");
resultSet = ps.executeQuery();
int i=0;
while(resultSet.next()){
%>

    <%String s=resultSet.getString("uname")+" "+resultSet.getString("froms")+" to "+resultSet.getString("destination")+" "+resultSet.getString("condate")+" "+resultSet.getString("convolume"); 
     
    %>

<br<br<br><input type="checkbox" name="oid"  value="<%=resultSet.getString("oid")%>"/><%=s%>

<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
         <input type = "submit" value = "Select Orders" />
 </form>
</body>
</html>