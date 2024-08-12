<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
@charset "UTF-8";
	body {
	    font-family: 'Arial', sans-serif;
	    margin: 0;
	    padding: 0;
	    display: flex;
	    align-items: center;
	    justify-content: center;
	    height: 100vh;
	    background-color: #f4f4f4;
	}
	
	.container {
	    text-align: center;
	    
	    margin: 50px;
	}
	
	h1 {
	    color: #333;
	    
	    font-size: 40px;
	}
	
	.button-container {
	    display: flex;
	    justify-content: space-between;
	    margin-top: 20px;
	}
	
	a{
		text-decoration: none;
		color: #333;
	}
	
	p{
		font-size: 22px;
		margin-top: 30px;
		font-weight: bolder;
	}
	
	.signup-button, .login-button {
	    display: inline-block;
	    text-decoration: none;
	    padding: 20px 20px 20px;
	    background-color: #4285f4;
	    color: #fff;
	    border-radius: 40px;
	    transition: background-color 0.3s ease-in;
	    
	    text-align: center;
	}
	
	.signup-button img, .login-button img {
	   	width: 300px;
	    height: 300px;
	    border-radius: 20px;
	}
	
	.signup-button {
	    margin-right: 60px;
	}
	
	.signup-button:hover, .login-button:hover {
	    background-color: #3367d6;
	}
</style>
</head>
<body>
	<%
		String message = (String)request.getAttribute("message");
		if(message!=null){
	%>
	
	<%= message %>
	<% } %>
    <div class="container">
        <h1>Welcome to Employee Registration</h1>
        <div class="button-container">
            <a href="Signup.jsp" class="signup-button">
                <img src="assets/signup-icon.jpg" alt="Signup Icon">
                <p>SignUp</p>
            </a>
            
            <a href="Login.jsp" class="login-button">
                <img src="assets/login-icon.png" alt="Login Icon">
                <p>Login</p>
            </a>
        </div>
    </div>
</body>
</html>