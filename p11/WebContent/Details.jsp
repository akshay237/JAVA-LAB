<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
PrintWriter p= response.getWriter();
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/od","root","atul4898");
String name=request.getParameter("name");
Statement st=con.createStatement();
String query="select * from Flight where airline_name='" +name  + "';";
ResultSet rs=st.executeQuery(query);
while(rs.next()){
	p.append( rs.getString("flight_number") + "\t");
	p.append( rs.getString("weekday") + "\t");
}
con.close();
}
catch(Exception e){
	e.printStackTrace();
}
%>
<a href="ReserveOnline.jsp" >Click to get Details</a>
</body>
</html>