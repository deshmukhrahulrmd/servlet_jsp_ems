<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Employee</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
        	display:flex;
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
        
        .regButton{
        	background-color: #333231;
            color: #c5d4c9;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top:200px;
        }
        
        .regButton:hover{
        	background-color: #757472;
        }

        button.reset {
            background-color: #f44336;
        }

        button.reset:hover {
            background-color: #d32f2f;
        }
        
        .message {
		    background-color: #a4a7ab;
		    color: black;
		    font-weight: bolder;
		    font-size: 15px;
		    margin: 20px;
		    padding: 20px;
		    padding-top:30px;
		    border: 1px solid #ccc;
		    border-radius: 8px;
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		    max-width: 150px;
		    width: 25%;
		    text-align: center;
		    font-family: 'Arial', sans-serif;
		}

		h2{
			margin:40px;
			margin-top:120px;
			margin-bottom: 20px
		}
		form{
			margin:35px;
		}
		span {
		  	font-size: 50px;
		}
    </style>
</head>
<body>
	<%
		String message = (String)request.getAttribute("message");	/* 'request' is implecit object  there are total 9 implesit object one is 'request' */
		if(message==null){
			message="Register First/Enter Correct Credentials";
		}
	%>
		
		<div class="container">
		<div class="message"><%=message%><p><span>&#128073;&#127996;</span></p></div>
	        <h2>Login Employee</h2>
	        <form action="login" method="post">
	
	            <label>Employee Email Id:</label>
	            <input type="text" name="email" required>
	            
	            <label>Employee Password:</label>
	            <input type="password" name="password" required>
	
	            <button type="submit">Login</button>
	            <button type="reset" class="reset">Reset</button>
			</form>
			<a href="Signup.jsp"><button class="regButton">Register</button></a>   
	    </div>
</body>
</html>