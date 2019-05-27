<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>e</title>
</head>
<body>
<%
PrintWriter p=response.getWriter();
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/od","root","atul4898");
String name=request.getParameter("name");
int number=Integer.parseInt(request.getParameter("number"));
int fnum=Integer.parseInt(request.getParameter("f_no"));
String date=request.getParameter("date");
int sno=new Random().nextInt(500)+1;
p.append(name + " " + number + " " + fnum + " "  + date + " " + sno);
Statement st=con.createStatement();
int c=st.executeUpdate("insert into Seat values(" + fnum + "," +"'" + date + "'," + sno + "," + "'" +name +"'," + "'" + number + "');" );
p.append("Row updated:" + c);
con.close();
}
catch(Exception e){
	e.printStackTrace();
}
 
%>
</body>
</html>