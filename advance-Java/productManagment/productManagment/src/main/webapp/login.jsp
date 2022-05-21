<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loginPage</title>
<link rel="stylesheet" href="css/login.css">
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
					<a href="forgotPassword.html" style="margin-left: 10px; padding-bottom: 5px;">Forgotten
						your password?</a>
				</div>
			</div>

			<div class="footer">
				<input type="submit" value="login >>" id="loginButton">
			</div>
		</form>
	</div>
</body>
</html>