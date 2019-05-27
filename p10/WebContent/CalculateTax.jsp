<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tax Calculation</title>
</head>
<body>
<% PrintWriter p=response.getWriter();
   double tax=0;
   double salary=Double.parseDouble(request.getParameter("salary"));
   if(salary<=1000000)
	 tax=0.1*salary;
   if(salary>1000000)
	   tax=(0.1*1000000) + (0.3*(salary-1000000));
   p.println("<h2>Tax Payable:" + tax + "</h2>");
%>
</body>
</html>