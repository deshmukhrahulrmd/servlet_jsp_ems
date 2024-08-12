<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="java.util.List"%>
<%@page import="servlets_jsp_ems.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Controller</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

button {
	background-color: #4caf50;
	color: #fff;
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 15px;
	margin: 10px;
	transition: background-color 0.3s ease;
}

.table-container {
	width: 80%;
	margin: 50px auto;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	overflow: hidden;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #4caf50;
	color: white;
}

tr:hover {
	background-color: #f5f5f5;
}

.table-heading {
	text-align: center;
	text-decoration: underline;
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

button:hover {
	background-color: gray;
}

.logoutButton {
	background-color: #333231;
	color: #c5d4c9;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.logoutButton:hover {
	background-color: #757472;
}
</style>
</head>
<body>
	<%
		String email = (String) session.getAttribute("session");
		if (email != null) {
	%>

		<%
		List<Employee> list = (List) request.getAttribute("list"); /* There are more the one data of student so we take list in request object & in jsp with the hepl of loop we display that list */
		%>
	
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
	
		<div class="message"><%=message%>
		</div>
		<%
		}
		%>
	
		<%
		String name = (String) request.getAttribute("cookie");
		if (name != null) {
		%>
		<div class="message">
			Changed by:
			<%=name%>
		</div>
		<%
		}
		%>
	
		<div class="table-container">
			<h2 class="table-heading">Employee Details</h2>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Employee Name</th>
						<th>Employee Phone</th>
						<th>Employee Address</th>
						<th>Employee Email</th>
						<th>Employee Password</th>
						<th>Delete</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
	
					<%
					for (Employee employee : list) {
					%>
					<tr>
						<td><%=employee.getId()%></td>
						<td><%=employee.getName()%></td>
						<td><%=employee.getPhone()%></td>
						<td><%=employee.getAddress()%></td>
						<td><%=employee.getEmail()%></td>
						<td><%=employee.getPassword()%></td>
						<td><a href="delete?id=<%=employee.getId()%>"><button>Delete</button></a></td>
						<td><a href="update?id=<%=employee.getId()%>"><button>Update</button></a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<br>
		<br>
	
		<a href="logout"><button class="logoutButton">LogOut</button></a>
	<%
		} else {
			request.setAttribute("message", "Session expired, Please Login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	%>

</body>
</html>