package com.nagarro.trainee.advanceJava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.trainee.advanceJava.model.Book;
import com.nagarro.trainee.advanceJava.service.IBookService;
import com.nagarro.trainee.advanceJava.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IBookService iBookService;

	@RequestMapping("/login")
	public String displayLoginPage() {
		System.out.println("In login page");
		return "login";
	}

	@RequestMapping("/loginUser")
	public ModelAndView loginUser(@Param("userName") String userName, @Param("password") String password,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println(userName);
		System.out.println(password);
		if (iUserService.validateUser(userName, password) == true) {
			System.out.println(userName + " loged in");
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			List<Object> list = iBookService.getBooks();
            ModelAndView mv=new ModelAndView();
            mv.setViewName("bookListing");
    		mv.addObject("books", list);
			return mv;

		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
			return mv;
		}

	}

	@RequestMapping("/logoutUser")
	public String logoutUser(HttpServletRequest request, HttpServletRequest response) {
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		session.invalidate(); // to remove all data
		return "login";

	}

}
