package com.omraj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		if(uname.equals("omraj") && password.equals("om123")) {
			RequestDispatcher rd=request.getRequestDispatcher("admindashboard.jsp");
			rd.forward(request,response);
		}
		else {
			System.out.println("Something wrong..");
		}
				
	}

}
