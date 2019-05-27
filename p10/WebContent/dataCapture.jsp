<%@ page import ="java.util.*" %>
<%@ page import="java.io.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Valid User</title>
</head>
<body>
<% PrintWriter po=response.getWriter();
   HashMap<String,String> hm=new HashMap<String,String>();
   hm.put("A","B");
   hm.put("B","C");
   String name=request.getParameter("name");
   String pw=request.getParameter("password");
   if(hm.containsKey(name) &&  pw.equals(hm.get(name))){
	   po.write("Welcome " + name);
%>
<br><br>
<form action="CalculateTax.jsp" method="post">
<br><br>
Select Organisation:<select name="pow">
<option>Engineer</option>
<option>Doctor</option>
</select>>
<br><br>
Gender:<select name="gender">
<option>Male</option>
<option>Female</option>
</select>>
<br><br>
Annual Income:<input type="text" name="salary" ><br><br>
<input type="submit" value="Calculate">
</form>
<%}else { %>
<jsp:forward page="index.html"></jsp:forward>
<%} %>
</body>
</html>