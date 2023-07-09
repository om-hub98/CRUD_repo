<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet" href="CSS/welcome.css">
</head>
<body class="body">
<%
           /// this page is allow to access only when login is done......
           if(session.getAttribute("username")==null){
        	   response.sendRedirect("login.jsp");
           }
%>
    <nav>
		<ul class="welcome-ul">
			<li class="welcome-li"><a class="welcome-li-a" href="fetchalluser">ViewAllUser</a></li>
			
			<li class="welcome-li"><a class="welcome-li-a" href="logout">Logout</a></li>
		</ul> 
	</nav>
        <div class="welcome-div">
			<h1>Welcome to Web Page</h1>
			
	    </div>
			 
				
</body>
</html>