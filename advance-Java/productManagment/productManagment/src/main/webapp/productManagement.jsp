<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="com.nagarro.trainee.advanceJava.util.*,org.hibernate.Session,org.hibernate.Transaction,
org.hibernate.query.Query,java.util.List,com.nagarro.trainee.advanceJava.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>productManagement</title>
<link rel="stylesheet" href="css/productManagement.css">
</head>
<body>
	<%
		if (session.getAttribute("userName") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="header">
		<span class="heading">Product Management Tool</span>
		<form action="logoutUser" class="header-form">
			<span class="username">Hi <%=session.getAttribute("userName")%></span>
			<input type="submit" value="Logout" class="header-logout-button" />
		</form>
	</div>
	<div class="input-container">
		<span class="form-intro">Please enter product details to add to
			stock</span>
		<form action="addProduct">
			<br>
			<div class="div">
				<div class="control-label">
					<label for="title">Title</label>
				</div>
				<div class="input">
					<input type="text" name="title" id="title">
				</div>
			</div>
			<div class="div">
				<div class="control-label">
					<label for="quantity">Quantity</label>
				</div>
				<div class="input">
					<input type="text" name="quantity" id="quantity">
				</div>
			</div>
			<div class="div">
				<div class="control-label">
					<label for="size">Size</label>
				</div>
				<div class="input">
					<input type="text" name="size" id="size">
				</div>
			</div>
			<div class="div">
				<div class="control-label">
					<label for="image">Image</label>
				</div>
				<div class="input">
					<input type="file" accept="image/*" name="image" id="image">
				</div>
			</div>
			<div class="div">
				<div class="control-label"></div>
				<div class="input">
					<input type="submit" name="submit" value="Add" id="add">
				</div>
			</div>
		</form>

	</div>
	<div class="table">
		<table>
			<tr class="table-header">
				<th class="th1">S.No</th>
				<th class="th2">Title</th>
				<th class="th3">Quantity</th>
				<th class="th4">Size</th>
				<th class="th5">Image</th>
				<th class="th6">Actions</th>
			</tr>
			<%
				try (Session ses = HibernateUtil.getSessionFactory().openSession()) {
					Transaction tx = ses.beginTransaction();
					Query q = ses.createQuery("from Product ");
					List<Product> list = q.list();
					int i = 1;
					for (Product s : list) {
			%>
			<tr>
				<td><%=i%></td>
				<td><%=s.getTitle()%></td>
				<td><%=s.getQuantity()%></td>
				<td><%=s.getSize()%></td>
				<td><img src="photos/<%=s.getImage()%>" alt="product_Image"
					height="160" width="160"
					style="padding-top: 20px; padding-bottom: 20px"></td>
				<td><a href="edit.jsp?Title= <%=s.getTitle()%> "><img
						src="photos/edit.png" alt="edit" height="40" width="40"></a> <a
					href="delete.jsp?Title= <%=s.getTitle()%> "> <img
						src="photos/delete.jpg" alt="delete" height="40" width="40"
						style="padding-left: 60px"></a></td>
			</tr>
			<%
				i++;
					}
					tx.commit();

				} catch (Exception e) {
					e.printStackTrace();
				}
			%>

		</table>
	</div>
</body>
</html>