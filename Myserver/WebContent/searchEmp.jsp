<%@page import="java.sql.*"%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssi","root", "root");
String specialist=request.getParameter("s");

PreparedStatement ps=con.prepareStatement("select name,address,specialist from employee where specialist=?");
ps.setString(1,specialist);

ResultSet rs=ps.executeQuery();
String s=""; 

if(rs.next())
    {
	
    	s+=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3);
    }
  out.println(s);

%>