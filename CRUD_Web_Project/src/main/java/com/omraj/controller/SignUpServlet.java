package com.omraj.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omraj.JPA.UserJPADao;
import com.omraj.model.User;

@WebServlet("/signup")
public class SignUpServlet  extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		//if(RegexTest.passwordIsValid(password)) {
		String password=encrypt(pass);
		boolean check=false;
			User user = new User(fname, lname, uname, password);
			UserJPADao	dao = new UserJPADao();
			check=dao.fetchData(user);
			if(fname=="" || lname=="" || uname=="" || password=="" || check== true) {
				request.setAttribute("error","User account already exist!!!");
				RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
				rd.include(request, response);
			}else {
				try {
					dao.insertData(user); 
		 				response.sendRedirect("signUpSuccess.jsp");
				} catch (Exception e) {
	
					e.printStackTrace();
				}
		}
//		else {
//			request.setAttribute("error","Password must contain only 8 letters, including 1 uppercase,1 lowercase,special characters,numbers");
//			RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
//			rd.include(request, response);
//		}
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
