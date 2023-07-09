
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
<link rel="stylesheet"  href="CSS/mystyle.css">
<script type="text/javascript"  src="JS/message.js"></script>

</head>
<body class="main-body">
	<div class="main-div">
		<h1>SignUp</h1>
		
		<c:if test="${not empty error}">
	        <p style="color:red;" class="text-center text-success">${error}</p>
	        <c:remove var="error"/>
	     </c:if>

		<form  name="myform" action="signup" method="post" onsubmit="return validateform()">
			<input type="text" name="fname" placeholder="Enter First Name" id="fname"><br>
			
			<input type="text" name="lname"	placeholder="Enter Last Name" id="lname"><br>
				
		   <input type="text" name="uname"	placeholder="Enter User Name" id="uname"><br>
				
		   <input type="password" name="password" placeholder="Enter password" id="password"><br>
		   
			<button type="submit" >SignUp</button>
		</form>
		      Already Have Account?<a href="login.jsp" >Login Here</a>
	</div>
</body>
</html>