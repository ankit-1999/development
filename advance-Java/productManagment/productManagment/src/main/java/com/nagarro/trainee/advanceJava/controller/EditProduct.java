package com.nagarro.trainee.advanceJava.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.trainee.advanceJava.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class EditProduct
 */
public class EditProduct extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ProductServiceImpl p = new ProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));
		String image;
		String oldImage = request.getParameter("oldImage");
		String newImage = request.getParameter("newImage");
		if (newImage.equals("")) {
			image = oldImage;
		} else {
			image = newImage;
		}
		p.editProduct(title, quantity, size, image);
		response.sendRedirect("productManagement.jsp");

	}

}
