<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Employee</title>
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
        
        .loginButton{
        	background-color: #333231;
            color: #c5d4c9;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        .loginButton:hover{
        	background-color: #757472;
        }
        
        button.reset {
            background-color: #f44336;
        }

        button.reset:hover {
            background-color: #d32f2f;
        }
        h2{
        	text-align: center;
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
		
		span {
			font-size: 50px;
		}
    </style>
</head>
<body>
	<%
		String message = (String)request.getAttribute("message");
		if(message!=null){
	%>
	
	<div class="message"><%=message%></div>
	<% } %>
	<div class="container">
        <h2 >Sign Up Employee</h2>
        <form action="signup" method="post">
			
            <label >Employee ID:</label>
            <input type="text" name="id" required>

            <label >Employee Name:</label>
            <input type="text" name="name" required>

            <label >Employee Phone:</label>
            <input type="text" name="phone" required>

            <label >Employee Address:</label>
            <input type="text" name="address" required>

            <label >Employee Email Id:</label>
            <input type="text" name="email" required>
            
            <label >Employee Password:</label>
            <input type="password" name="password" required>

            <button type="submit">Save</button>
            <button type="reset" class="reset">Reset</button>
            
        </form>
        <br><br><br>
        <a href="Login.jsp"><button class="loginButton">Login</button></a>
    </div>

</body>
</html>