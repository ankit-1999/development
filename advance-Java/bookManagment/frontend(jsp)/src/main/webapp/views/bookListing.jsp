<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.nagarro.trainee.advanceJava.model.Book,java.util.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="views/css/bookListing.css">
<style type="text/css">
* {
	margin: 0;
	box-sizing: border-box;
	padding: 0;
}

body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

.header {
	width: 100%;
	height: 75px;
	font-size: 25px;
	font-weight: bold;
	background-image: linear-gradient(180deg, #cbe1fc, rgb(254, 254, 255));
	border-bottom: 1px solid rgb(82, 172, 207);
}

.insideHeader {
	float: right;
	margin-top: 14px;
	padding-right: 30px;
}

.header-logout-button {
	height: 35px;
	padding-right: 15px;
	padding-left: 15px;
	border-radius: 9px;
	color: rgb(60, 127, 216);
	font-size: 20px;
	border-color: rgb(60, 127, 216);
	background: none;
}

.welcome {
	padding-right: 10px;
}

.footer {
	margin-top: auto;
	height: 85px;
	width: 100%;
	background-image: linear-gradient(180deg, #cbe1fc, rgb(254, 254, 255));
	border-top: 1px solid rgb(65, 189, 238);
}

.container {
	margin-top: 30px;
	display: flex;
	flex-direction: column;
}

.title {
	height: 40px;
	font-size: 35px;
	text-align: center;
	font-weight: bold;
}

.addBook {
	float: right;
	padding-right: 80px;
}

.addBookBtn {
	width: 140px;
	height: 45px;
	border-radius: 8px;
	background-color: rgb(57, 144, 224);
	border: none;
	font-size: 18px;
	font-weight: bold;
	color: #f3efef;
}

.table {
	margin-top: 40px;
	margin-left: 60px;
	margin-right: 100px;
	margin-bottom: 60px;
}

td, th {
	border: 1px solid black;
	text-align: center;
}

.table-header {
	height: 50px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 90%;
}

.editBtn {
	width: 40%;
	height: 35px;
	padding-top: 2px;
	border-radius: 6px;
	color: #a4aeb9;
	font-weight: bold;
	font-size: 17px;
	background: none;
	border-color: #a4aeb9;
}

.deleteBtn {
	width: 40%;
	height: 35px;
	padding-top: 2px;
	border-radius: 6px;
	color: #f14a60;
	font-weight: bold;
	font-size: 17px;
	background: none;
	border-color: #f14a60;
}

.actionCol {
	width: 20%;
}
</style>
</head>

<body>
	<%
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("login.jsp");
	}
	System.out.println("in Book Listing");
	%>
	<header class="header">
		<form action="logoutUser" class="insideHeader">
			<span class="welcome">Welcome <%=session.getAttribute("userName")%></span>
			<input type="submit" value="Logout" class="header-logout-button" />
		</form>
	</header>
	<div class="container">
		<div class="title">
			<span>Books Listing</span>
			<form action="displayAddBook" class="addBook">
				<input type="submit" value="Add a book" class="addBookBtn">
			</form>
		</div>
		<table class="table">
			<tr class="table-header">
				<th>Book Code</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Data Added</th>
				<th class="actionBtn">Actions</th>
			</tr>
			<c:forEach items="${books}" var="book">
				<tr class="table-header">
					<td>${book.book_code}</td>
					<td>${book.book_name}</td>
					<td>${book.author}</td>
					<td>${book.added_on_date}</td>
					<td><a href="editBook/${book.book_code }"><input
							type="submit" value="Edit" class="editBtn"></a> <a
						href="deleteBook/${book.book_code }"><input type="submit"
							value="Delete" class="deleteBtn"></a></td>
				</tr>
			</c:forEach>


		</table>
	</div>
	<footer class="footer"> </footer>
</body>

</html>