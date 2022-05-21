<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="com.nagarro.trainee.advanceJava.model.Book,java.util.List,com.nagarro.trainee.advanceJava.model.Author"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="views/css/addBook.css">
</head>

<body>
	<%
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<header class="header">
		<form action="logoutUser" class="insideHeader">
			<span class="welcome">Welcome <%=session.getAttribute("userName")%></span>
			<input type="submit" value="Logout" class="header-logout-button" />
		</form>

	</header>
	<form action="addBook" class="container">
		<div class="title">ADD Book Details</div>
		<div class="div" style="margin-top: 30px;">
			<div class="control-label">
				<label class="label" for="bookCode">Book Code</label>
			</div>
			<div class="input">
				<input type="text" class="inputTag" name="book_code" id="bookCode"
					required>
			</div>
		</div>
		<div class="div" style="margin-top: 30px;">
			<div class="control-label">
				<label class="label" for="bookName">Book Name</label>
			</div>
			<div class="input">
				<input type="text" class="inputTag" name="book_name" id="bookName"
					required>
			</div>
		</div>
		<div class="div" style="margin-top: 30px;">
			<div class="control-label">
				<label class="label" for="author">Author</label>
			</div>
			<div class="input">
				<select name="author" id="author" class="inputTag">
				<c:forEach items="${authors}" var="author">
					<option value="${author.author_name }">${author.author_name}</option>
				</c:forEach>
				</select>
			</div>
		</div>
		<div class="div" style="margin-top: 30px;">
			<div class="control-label">
				<label class="label" for="date">Added On</label>
			</div>
			<div class="input">
				<input type="text" class="inputTag" name="added_on_date" id="bookName"
					required>
			</div>
		</div>
		<div class="div" style="margin-top: 30px;">
			<input type="submit" class="submit" value="Submit" /> <input
				type="button" class="cancel" value="Cancel" />
		</div>

	</form>
	<footer class="footer"></footer>
</body>

</html>