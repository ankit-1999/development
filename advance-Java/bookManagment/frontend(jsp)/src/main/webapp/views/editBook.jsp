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
<link rel="stylesheet" href="views/css/editBook.css">
<style type="text/css">
body {
	margin: 0;
	box-sizing: border-box;
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

.footer {
	bottom: 0;
	height: 85px;
	position: absolute;
	width: 100%;
	background-image: linear-gradient(180deg, #cbe1fc, rgb(254, 254, 255));
	border-top: 1px solid rgb(65, 189, 238);
}

.container {
	margin-top: 30px;
}

.title {
	height: 40px;
	font-size: 35px;
	text-align: center;
	font-weight: bold;
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

.div {
	display: flex;
	margin-left: 300px;
	height: 35px;
}

.control-label {
	font-size: 25px;
	width: 250px;
}

.date {
	font-size: 20px;
	color: rgb(145, 160, 160);
}

.input {
	width: 250px;
}

.inputTag {
	height: 75%;
	border-radius: 8px;
	width: 100%;
}

.submit {
	width: 100px;
	font-weight: bold;
	background-color: rgb(11, 151, 245);
	border-radius: 8px;
	color: #fffefe;
	outline: none;
	margin-left: 250px;
	border: none;
}

.cancel {
	width: 100px;
	margin-left: 50px;
	font-weight: bold;
	background-color: rgb(255, 66, 66);
	border-radius: 8px;
	color: #fffefe;
	border: none;
}
</style>
</head>

<body>
	<%
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("login.jsp");

	}
	System.out.println("in edit book");
	%>
	<header class="header">
		<form action="logoutUser" class="insideHeader">
			<span class="welcome">Welcome <%=session.getAttribute("userName")%></span>
			<input type="submit" value="Logout" class="header-logout-button" />
		</form>

	</header>
	<form action="editBook" class="container">
		<div class="title">Edit Book Details</div>
		<div class="div" style="margin-top: 30px;">
			<div class="control-label">
				<label class="label" for="bookCode">Book Code</label>
			</div>
			<div class="input">
				<span class="date">${book.book_code}</span> <input type="text"
					class="inputTag" name="book_code" id="bookCode"
					value="${book.book_code}" required style="display: none">
			</div>
		</div>
		<div class="div" style="margin-top: 30px;">
			<div class="control-label">
				<label class="label" for="bookName">Book Name</label>
			</div>
			<div class="input">
				<input type="text" class="inputTag" name="book_name" id="bookName"
					value="${book.book_name}" required>
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
				<input type="text" class="inputTag" name="added_on_date" id="date"
					value="${book.added_on_date}" required>

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