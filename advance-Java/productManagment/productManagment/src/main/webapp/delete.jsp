<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.nagarro.trainee.advanceJava.dao.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println(request.getParameter("Title"));
ProductDao.deleteProduct(request.getParameter("Title"));
response.sendRedirect("productManagement.jsp");


%>
</body>
</html>