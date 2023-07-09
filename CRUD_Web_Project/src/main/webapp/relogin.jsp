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
</head>
<body class="main-body">
<div class="main-div">
   <h1>Login Page</h1>
	     
	     <c:if test="${not empty error}">
	        <p style="color:red;" class="text-center text-success">${error}</p>
	        <c:remove var="error"/>
	     </c:if>
	     <%
	         String userName=(String)request.getAttribute("userName");
	         String password=(String)request.getAttribute("password");
	         String confirmPassword=(String)request.getAttribute("confirmPassword");
	     %>
		<form action="login" method="post">

			<input type="text" name="userName" placeholder="Enter username"
				value="<%=userName%>"><br> <input type="password"
				name="password" placeholder="Enter password" value="<%=password%>"><br>

			<input type="password" name="confirmPassword"
				placeholder="Enter ConfirmPassword" value="<%=confirmPassword%>"><br>
				
			<button type="submit">Login</button>
			<br> <a href="signup.jsp">Don't have an account? Register
				here</a>
		</form>
	</div>
</body>
</html>