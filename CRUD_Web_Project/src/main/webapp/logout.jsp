<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Page</title>
</head>
<style>
 body{    
     text-align: center;
     background-color: lightblue;
     margin-top: 100px;
     font-size: 40px;
 
  }
</style>
<body>
		 <%
		           /// this page is allow to access only when login is done......
		           if(session.getAttribute("username")==null){
		        	   response.sendRedirect("login.jsp");
		           }
		%> 
			Logout Successful.....		<br>
			CLick here to go<a href="home.jsp"> BackToHome</a>
			
</body>
</html>