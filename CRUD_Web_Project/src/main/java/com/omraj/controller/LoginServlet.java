package com.omraj.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omraj.DBConnection.DBConn;
import com.omraj.JPA.UserJPADao;
import com.omraj.jdbcdao.UserDao;
import com.omraj.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getParameter("userName");
		String pass = request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String password=encrypt(pass);
		User user = new User(username, password);
		boolean check = false;
			UserJPADao dao = new UserJPADao();
			check = dao.fetchLoginData(user);
		
		if (check == true && confirmPassword.equals(pass)) {
			HttpSession session=request.getSession();
			session.setAttribute("username",username);
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			//response.sendRedirect("welcome.jsp"); 
		} else {
			request.setAttribute("error","Invalid username or password");
			request.setAttribute("userName",user.getUserName());
			request.setAttribute("password",user.getPassword());
			request.setAttribute("confirmPassword",confirmPassword);
			RequestDispatcher rd=request.getRequestDispatcher("relogin.jsp");
			rd.include(request,response);
		}
	}

	private String encrypt(String password) {
		String result="";
		int key=5;
		char[] chars=password.toCharArray();
		for(char c: chars) {
			c+=key;
			result=result+c;
		}
		System.out.println(result);
		return result;
	}

}
