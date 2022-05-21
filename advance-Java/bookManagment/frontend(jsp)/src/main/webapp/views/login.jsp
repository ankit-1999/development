<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="views/css/login.css">
<Script src="views/js/login.js"></Script>
<Style>
* {
	margin: 0;
	box-sizing: border-box;
	padding: 0;
}

.container {
	width: 50%;
	height: 230px;
	transform: translate(-50%, -50%);
	position: absolute;
	top: 50%;
	left: 50%;
}

.footer {
	bottom: 0;
	position: absolute;
	width: 100%;
	height: 65px;
	background-image: linear-gradient(180deg, #eef1e0, rgb(161, 163, 241));
}

.header {
	width: 100%;
	height: 90px;
	background-image: linear-gradient(180deg, rgb(173, 174, 245), #eef1e0);
}

.div {
	display: flex;
	height: 30px;
}

.control-label {
	width: 35%;
}

.label {
	padding-left: 15px;
	padding-right: 20px;
	float: right;
	margin-right: 40px;
	font-size: 20px;
	background-color: rgb(238, 238, 237);
	padding-top: 7px;
	padding-bottom: 7px;
}

.input {
	width: 45%;
}

.inputTag {
	height: 95%;
	width: 100%;
	border: 1px solid rgb(52, 139, 211);
	padding-left: 10px;
}

.submitbtn {
	padding-left: 25px;
	padding-right: 25px;
	height: 100%;
}
</Style>
</head>

<body>
	<div class="header"></div>
	<form action="loginUser" class="container">
		<fieldset style="border-color: aliceblue">
			<legend style="color: rgb(26, 132, 165); font-size: 25px;">Login</legend>
			<div class="div" style="margin-top: 30px;">
				<div class="control-label">
					<label class="label" for="username">User Id:</label>
				</div>
				<div class="input">
					<input type="text" class="inputTag" name="userName" id="userName"
						placeholder="username" required>
				</div>
			</div>
			<div class="div" style="margin-top: 20px;">
				<div class="control-label">
					<label class="label" for="password">Password:</label>
				</div>
				<div class="input">
					<input type="text" class="inputTag" name="password" id="password"
						placeholder="password" required>
				</div>
			</div>
			<div class="div" style="margin-top: 20px; margin-bottom: 20px">
				<div class="control-label"></div>
				<div class="input">
					<input type="submit" value="Login" class="submitbtn"
						onclick="validate();">
				</div>
			</div>

		</fieldset>
	</form>
	<div class="footer"></div>
</body>

</html>