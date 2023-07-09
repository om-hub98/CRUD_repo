<%@page import="com.omraj.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" 	href="CSS/mystyle.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
<script type="text/javascript" src="message.js"></script>
</head>
<body class="main-body">
<div class="main-div">
   <h1>Login Page</h1> 
	    
		<form action="login" method="post" onsubmit="return validateLoginForm()">
			
				<input type="text" name="userName"  placeholder="Enter username" id="uname"><br>
			
				<input type="password" name="password"  placeholder="Enter password"  id="password">
				<i class="fa-light fa-eye-slash"></i><br>
			
				<input type="password" name="confirmPassword"  placeholder="Enter ConfirmPassword"  id="confirmPassword"><br>
				<button type="submit" >Login</button><br>
				  
				  <a href="signup.jsp">Don't have an account? Register here</a>
				
		</form>
	</div>
</body>
</html>