<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<div class="main-div">
<h1>Admin Login</h1>
     <form action="adminlogin" method="post">
         <input type="text" name="username" placeholder="Enter Username"><br>
         <input type="password" name="password" placeholder="Enter password"><br>
         <button type="submit">Submit</button><br>
         <a href="home.jsp">Click Here to go back to Home Page</a>
     </form>
 </div>
</body>
</html>