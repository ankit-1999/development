<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loginPage</title>
<style type="text/css">
.container {
	width: 50%;
	height: 220px;
	position: absolute;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.header {
	border-top: 2px solid rgb(145, 174, 212);
	border-bottom: 2px solid rgb(145, 174, 212);
	height: 18%;
	vertical-align: middle;
	font-size: 30px;
	padding-left: 7px;
	color: rgb(11, 80, 170);
	background-color: hsl(195, 65%, 87%);
	font-weight: bold;
}

.div {
	display: flex;
}

.input {
	width: 100%;
}

.control-label {
	font-size: 20px;
	width: 40%;
	padding-left: 14px;
}

.inputTag {
	width: 50%;
}

.star {
	color: red;
}

.footer {
	justify-content: flex-end;
	display: flex;
	border-top: 2px solid rgb(145, 174, 212);
	border-bottom: 2px solid rgb(145, 174, 212);
	background-color: hsl(195, 65%, 87%);
}

form {
	background-color: hsl(194, 89%, 93%);
}

#loginButton {
	width: 14%;
	margin-top: 5px;
	margin-bottom: 5px;
	height: 24px;
	margin-right: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">Login</div>
		<form action="loginUser">
			<br>
			<div class="div">
				<div class="control-label">
					<label for="username">Username:</label>
				</div>
				<div class="input">
					<span class="star">* </span> <input type="text" class="inputTag"
						name="userName" id="username">
				</div>
			</div>
			<br>
			<div class="div">
				<div class="control-label">
					<label for="password">Password:</label>
				</div>
				<div class="input">
					<span class="star">* </span> <input type="password"
						class="inputTag" name="password" id="password">
				</div>
			</div>
			<br>
			<div class="div" style="padding-bottom: 7px">
				<div class="control-label"></div>
				<div class="input">
					<a href="forgotPassword.html"
						style="margin-left: 10px; padding-bottom: 5px;">Forgotten your
						password?</a>
				</div>
			</div>

			<div class="footer">
				<input type="submit" value="login >>" id="loginButton">
			</div>
		</form>
	</div>
</body>
</html>