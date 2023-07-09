package com.omraj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omraj.JPA.UserJPADao;
import com.omraj.model.User;

@WebServlet("/fetchalluser")
public class GetAllUsersData extends HttpServlet{
       public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   UserJPADao dao=new UserJPADao();
    	   List<User> list=dao.fetchAllData();
    	   
    	   HttpSession session=request.getSession();
    	   if (session.getAttribute("username") == null) {
				response.sendRedirect("login.jsp");
    	   }
			else {
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
				rd.forward(request, response);
			}
       }
}
