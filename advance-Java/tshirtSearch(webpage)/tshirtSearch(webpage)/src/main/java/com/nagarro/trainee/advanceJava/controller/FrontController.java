package com.nagarro.trainee.advanceJava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.trainee.advanceJava.model.Tshirt;
import com.nagarro.trainee.advanceJava.service.impl.*;
import com.nagarro.trainee.advanceJava.thread.WatcherService;

@Controller
public class FrontController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	TshirtServiceImpl tshirtServiceImpl;

	@RequestMapping("/loginUser")
	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("in login main");
		WatcherService ws = new WatcherService();
		Thread t = new Thread(ws);
		t.start();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		tshirtServiceImpl.praseFromCsv();
		if (userServiceImpl.validateUser(userName, password) == true) {
			response.sendRedirect("input.jsp");
		} else {
			System.out.println("invalid username or password");
			response.sendRedirect("login.jsp");
		}

	}

	@RequestMapping("/searchProduct")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		String colour = request.getParameter("colour");
		String size = request.getParameter("size");
		String gender = request.getParameter("gender");
		String outputPreference = request.getParameter("outputPreference");
		List<Tshirt> list = tshirtServiceImpl.searchTshirt(colour, size, gender, outputPreference);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("result", list);
		return mv;
	}
}
