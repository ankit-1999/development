package com.nagarro.trainee.advanceJava.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nagarro.trainee.advanceJava.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLogin
 */
@SuppressWarnings("serial")
public class UserLogin extends HttpServlet {

	UserServiceImpl ip = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (ip.validateUser(userName, password) == true) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			response.sendRedirect("productManagement.jsp");
		} else {
			response.sendRedirect("login.jsp");
			System.out.println("invalid username or password");
		}

	}

}
