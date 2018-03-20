<%@page import="java.sql.*"%>
<%
  Class.forName("com.mysql.jdbc.Driver");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssi","root", "root");
   
 int code=Integer.parseInt(request.getParameter("c"));
  String name=request.getParameter("n");
  String address=request.getParameter("ci");
  String specialist=request.getParameter("s");
  
   PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
  ps.setInt(1,code);
  ps.setString(2, name);
  ps.setString(3,address);
  ps.setString(4,specialist);
  int a=ps.executeUpdate();
     if(a>0)
    	 out.println("Data Save");
%>
