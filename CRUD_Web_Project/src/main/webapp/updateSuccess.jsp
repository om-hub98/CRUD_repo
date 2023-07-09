<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Success message</title>
<style type="text/css">
 body{    
 
      font-size:40px;
     text-align: center;
     background-color: lightblue;
     margin-top: 100px;
      line-height: 1.8;
 
  }
</style>
</head>
<body>
         <%
             String firstName=(String)request.getAttribute("fname");
            String lastName=(String)request.getAttribute("lname");
            String userName=(String)request.getAttribute("uname");
            
         %>
        
              User Data Updated Successfully... with <br>
               FirstName = <%=firstName%> ,  LastName = <%=lastName%> , UserName = <%=userName%> <br>
        Click here to <a href="fetchalluser" >ViewAllUsers</a><br>
        
         
</body>
</html>