<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>userInputForm</title>
<Style>
form {
	width: 60%;
	height: 400px;
	margin-top: 50px;
	margin-left: 200px;
	text-align: center;
	background-color: rgb(245, 248, 248);
	border-radius: 20px;
}

.headings {
	font-size: 30px;
	font-weight: bold;
	margin-top: 50px;
	padding-top: 30px;
	color: rgb(165, 97, 20);
}

.div {
	height: 40px;
	margin-top: 20px;
	display: flex;
	text-align: center;
	justify-content: center;
}

.input {
	height: 30px;
	width: 250px;
}

.label {
	font-size: 15px;
	float: right;
	padding-right: 30px;
	padding-top: 7px;
}

.labeldiv {
	width: 45%;
}

#submit {
	width: 25%;
}
</Style>
</head>
<body>
	<form action="searchProduct">

		<div class="headings">Product Input Form</div>
		<div class="div">
			<div class="labeldiv">
				<label for="colour" class="label">Enter Your Tshirt Colour :
				</label>
			</div>

			<input type="text" name="colour" id="colour" class="input">
		</div>
		<div class="div">
			<div class="labeldiv">
				<label for="size" class="label">Enter Your Tshirt Size
					(S,M,L,XL,XXL) : </label>
			</div>
			<input type="text" name="size" id="size" class="input">
		</div>
		<div class="div">
			<div class="labeldiv">
				<label for="gender" class="label">Enter Your Gender (M/F) :
				</label>
			</div>
			<input type="text" name="gender" id="gender" class="input">
		</div>
		<div class="div">
			<div class="labeldiv">
				<label for="outputPreference" class="label">Enter Your
					Output Preference (Price,Rating,Both) : </label>
			</div>
			<input type="text" name="outputPreference" id="outputPreference"
				class="input">
		</div>
		<div class="div">
			<input type="submit" id="submit">
		</div>




	</form>
</body>
</html>