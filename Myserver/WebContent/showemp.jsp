<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.*"%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssi","root", null);
PreparedStatement ps=con.prepareStatement("select * from employee");
ResultSet rs=ps.executeQuery();
   JSONArray jar=new JSONArray();
while(rs.next())
    {
       JSONObject json=new JSONObject();
       json.put("c",rs.getString(1));
       json.put("n",rs.getString(2));
       json.put("ci",rs.getString(3));
       json.put("s",rs.getString(4));
       jar.put(json);
    }
  
  JSONObject ob=new JSONObject();
   ob.put("empdetails",jar);
   out.println(ob);

%>