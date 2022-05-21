package com.nagarro.trainee.advanceJava.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.trainee.advanceJava.service.impl.UserServiceImpl;

/**
 * Servlet implementation class GetUserPassword
 */
public class GetUserPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserServiceImpl ip = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		System.out.println(username + " your password is " + ip.getPassword(username));
		response.sendRedirect("login.jsp");
	}

}
