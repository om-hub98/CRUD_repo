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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		//if (RegexTest.passwordIsValid(password)) {
			User user = new User(id, fname, lname, uname, password);
		    UserJPADao dao = new UserJPADao();
		    boolean check = dao.updateData(user);
				if (check) {
					request.setAttribute("fname", user.getFirstname());
					request.setAttribute("lname", user.getLastname());
					request.setAttribute("uname", user.getUserName());

					RequestDispatcher rd = request.getRequestDispatcher("updateSuccess.jsp");
					rd.include(request, response);
				} else {
					response.sendRedirect("updateError.jsp");
				}

//		} else {
//			request.setAttribute("error",
//					"Password must contain only 8 letters, including 1 uppercase,1 lowercase,special characters,numbers");
//			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
//			rd.include(request, response);
//		}

	}
}
