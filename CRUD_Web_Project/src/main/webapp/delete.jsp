<%@page import="com.omraj.JPA.UserJPADao"%>
<%@page import="com.omraj.model.User"%>
<%@page import="com.omraj.DBConnection.DBConn"%>
<%@page import="com.omraj.jdbcdao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       
          <!--   <jsp:useBean id="u" class="com.omraj.model.User"></jsp:useBean>
           <jsp:setProperty property="*" name="u"/>  -->
           
           <%
           int id=Integer.parseInt(request.getParameter("id"));
             UserJPADao dao=new UserJPADao();
             boolean check=dao.deleteUser(id);
             if(check==true)
                 response.sendRedirect("deleteSuccess.jsp");
            else
            	 response.sendRedirect("deleteError.jsp");   
           
           %>
       		
   
</body>
</html>