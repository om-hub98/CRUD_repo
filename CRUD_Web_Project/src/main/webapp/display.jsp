<%@page import="com.omraj.JPA.UserJPADao"%>
<%@page import="com.omraj.DBConnection.DBConn"%>
<%@page import="com.omraj.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display User Details</title>
<link rel="stylesheet" href="CSS/display.css">
</head>
<body id="body">

	<%
			/// this page is allow to access only when login is done......
			/* if (session.getAttribute("username") == null) {
				response.sendRedirect("login.jsp");
			} else {
				UserJPADao dao = new UserJPADao();
				List<User> list = dao.fetchAllData();
				
			} */
	                   request.getAttribute("list");
	%>
	<div id="main-div">
		<h1 id="h1">Fetch All Users Data ::</h1>
		<div class="table">
			<table border="1" width="90%">
				<tr>
					<th>Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>UserName</th>
					<th>Password</th>
					<th>Edit</th>
					<th>Delete</th>


				</tr>
				<c:forEach items="${list}" var="l">
					<tr>
						<td>${l.getId()}</td>
						<td>${l.getFirstname()}</td>
						<td>${l.getLastname()}</td>
						<td>${l.getUserName()}</td>
						<td>${l.getPassword()}</td>
						<td><a href="update.jsp?id=${l.getId()}">Edit</a></td>
						<td><a href="delete.jsp?id=${l.getId()}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
		    <br> <br> Click Here to go back to <a href="welcome.jsp">WelcomePage</a>
	</div>
</body>
</html>