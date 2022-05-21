package com.nagarro.trainee.advanceJava.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.trainee.advanceJava.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ProductServiceImpl p = new ProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));
		String image = request.getParameter("image");
		if (p.validateImageSize(image) == true) {
			p.addProduct(title, quantity, size, image);
			System.out.println("product added Succesfully");
		} else {
			System.out.println("Product not added");
		}

		response.sendRedirect("productManagement.jsp");
	}

}
