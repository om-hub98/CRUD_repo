<%@page import="com.omraj.JPA.UserJPADao"%>
<%@page import="com.omraj.model.User"%>
<%@page import="com.omraj.DBConnection.DBConn"%>
<%@page import="com.omraj.jdbcdao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Data</title>
<link rel="stylesheet"  href="mystyle.css">

</head>
<body>
  <div class="main-div">
    <h1>Update Details::: </h1>
    <%                                          // Scriptlet tags to write java code in jsp 
    	 int id=Integer.parseInt(request.getParameter("id"));
         UserJPADao dao=new UserJPADao();
    	 User user=dao.fetchById(id);
    %>
    <c:if test="${not empty error}">                <!--  JSTL core tags to  -->
	        <p style="color:red;" class="text-center text-success">${error}</p>
	        <c:remove var="error"/>
	     </c:if>
    <form action="update" method="post">
       		 <input type="hidden" name="id" value="<%=user.getId()%>"><br>
  		<label>FirstName</label><br>
     		 <input type="text" name="fname" value="<%=user.getFirstname()%>"><br>
        <label>LastName</label><br>
       		<input type="text" name="lname" value="<%=user.getLastname()%>"><br>
        <label>UserName</label><br>
       		<input type="text" name="uname" value="<%=user.getUserName()%>"><br>
        <label>Password</label><br>
      		 <input type="password" name="password" value="<%=user.getPassword()%>"><br>
      	      		 
      		      <button type="submit">Update</button>
       </form>
    </div>
</body>
</html>