<%@ page import="servlets_jsp_ems.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update employee</title>
<style>
	body {
		font-family: Arial, sans-serif;
		background-color: #f4f4f4;
		margin: 0;
		padding: 0;
	}
	
	.container {
		width: 50%;
		margin: 50px auto;
		background-color: #fff;
		padding: 20px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}
	
	label {
		display: block;
		margin-bottom: 8px;
	}
	
	input, select {
		width: 100%;
		padding: 10px;
		margin-bottom: 16px;
		box-sizing: border-box;
	}
	
	.message {
		background-color: #a4a7ab;
		color: black;
		font-weight: bolder;
		font-size: 15px;
		margin: 20px;
		padding: 20px;
		padding-top: 30px;
		justify-content: center;
		align-items: center;
		border: 1px solid #ccc;
		border-radius: 8px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		max-width: 150px;
		width: 25%;
		text-align: center;
		font-family: 'Arial', sans-serif;
	}
	
	button {
		background-color: #4caf50;
		color: #fff;
		padding: 10px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	button:hover {
		background-color: #45a049;
	}
	
	button.reset {
		background-color: #f44336;
	}
	
	button.reset:hover {
		background-color: #d32f2f;
	}
	
	h2 {
		text-align: center;
	}
</style>
</head>
<body>

	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
	%>

	<div class="message"><%=message%> </div>
	<%
		}
	%>

	<%
		Employee employee = (Employee) request.getAttribute("Emp");
	%>

	<div class="container">
		<h2>Update Employee Details</h2>
		<form action="edit" method="post">

			<label>Employee ID:</label>
			<input type="text" name="id" value= <%=employee.getId()%> readonly="readonly">
			
			<label>EmployeeName:</label>
			<input type="text" name="name" value= <%=employee.getName()%> >
			
			<label>Employee Phone:</label>
			<input type="text" name="phone" value= <%=employee.getPhone()%> >
			
			<label>EmployeeAddress:</label>
			<input type="text" name="address" value= <%=employee.getAddress()%> >
			
			<label>EmployeeEmail Id:</label>
			<input type="text" name="email" value= <%=employee.getEmail()%> >
			
			<label>EmployeePassword:</label>
			<input type="hidden" name="password" value= <%=employee.getPassword()%> >

			<button type="submit">Update</button>
			<button type="reset" class="reset">Reset</button>

		</form>
		<br><br><br>
	</div>
</body>
</html>