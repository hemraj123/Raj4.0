<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.*"%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssi","root", "root");
string specialist=request.getParameter("s");

PreparedStatement ps=con.prepareStatement("select name,speciaist,address from employee where speciaist=?");
ps.setString(1,speciaist);

ResultSet rs=ps.executeQuery();
JSONObject ob=new JSONObject();
if(rs.next())
{
	
	s+=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3);
}
out.println(s);

  out.println(s);

%>