<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<%@page import="com.nagarro.trainee.advanceJava.dao.*,com.nagarro.trainee.advanceJava.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="css/edit.css">
</head>
<body>
     
     <%
     String id=request.getParameter("Title");
     System.out.println(id+"1");
     Product product = ProductDao.getProduct(id);
     %>

	<form action="editProduct">
		<br>
		<div class="div">
			<div class="control-label">
				<label for="title">Title</label>
			</div>
			<div class="input">
				<input  name="title" Style="pointer-events:none" value="<%=product.getTitle()  %>" id="title">
			</div>
		</div>
		<div class="div">
			<div class="control-label">
				<label for="quantity">Quantity</label>
			</div>
			<div class="input">
				<input type="text" name="quantity" value="<%=product.getQuantity() %>" id="quantity">
			</div>
		</div>
		<div class="div">
			<div class="control-label">
				<label for="size">Size</label>
			</div>
			<div class="input">
				<input type="text" name="size" id="size" value="<%=product.getSize()  %>">
			</div>
		</div>
		<div class="div">
			<div class="control-label">
				<label for="image">Image</label>
			</div>
			<div class="input">
				<input  name="oldImage" Style="pointer-events:none"  value="<%=product.getImage()  %>">
			</div>
			<div class="input" style="margin-left: 15px">
				<input type="file" accept="image/*" name="newImage" value="<%=product.getImage()  %> id="image">
			</div>
		</div>
		<div class="div">
			<div class="control-label"></div>
			<div class="input">
				<input type="submit" name="imageBtn" value="Edit" id="add">
			</div>
		</div>
	</form>
</body>
</html>