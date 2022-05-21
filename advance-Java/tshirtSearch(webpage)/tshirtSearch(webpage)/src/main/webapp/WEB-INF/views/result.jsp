<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="com.nagarro.trainee.advanceJava.model.Tshirt,java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Result</title>
<Style>
td, th {
	border: 1px solid black;
	text-align: center;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 70%;
	margin-top: 100px;
	margin-left: 200px;;
}
</Style>
</head>
<body>
	<%
	   List<Tshirt> list= (List<Tshirt>) request.getAttribute("result");
	   
     %>
	<div class="table">
		<table>
			<tr class="table-header">
				<th>ID</th>
				<th>NAME</th>
				<th>COLOUR</th>
				<th>GENDER RECOMMENDATION</th>
				<th>SIZE</th>
				<th>PRICE</th>
				<th>RATING</th>
				<th>AVALIBILITY</th>
			</tr>
			<% for(Tshirt s:list)
			{
				
				%>
				<tr>
				<th><%=s.getId()%></th>
				<th><%=s.getName() %></th>
				<th><%=s.getColour() %></th>
				<th><%=s.getGenderRecommendation() %></th>
				<th><%=s.getSize()%></th>
				<th><%=s.getPrice() %></th>
			    <th><%=s.getRating() %></th>
				<th><%=s.getAvailability() %></th>
			</tr>
			<% } %>

		</table>
	</div>
</body>
</html>