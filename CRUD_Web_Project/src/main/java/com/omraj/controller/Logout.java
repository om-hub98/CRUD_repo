package com.omraj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class Logout extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		 HttpSession session =request.getSession();
		 session.removeAttribute("username");
		  RequestDispatcher rd=request.getRequestDispatcher("logout.jsp");
		   rd.forward(request, response);
		 // response.sendRedirect("logout.jsp");
		 
	}

}
