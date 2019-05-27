<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ViewDetails.jsp">
Name<input type="text" name="name">
<br><br>
Number<input type="text" name="number">
<br><br>
Flight_number<input type="text" name="f_no">
<br><br>
Date<input type="text" name="date">
<br><br>
<input type="submit">
<br><br>
</form>
<br><br>
Search Flight 
<form action="Details.jsp">
Name<input type="text" name="name">
<br><br>
<input type="submit">
</form>
</body>
</html>