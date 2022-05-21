package com.nagarro.trainee.advanceJava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.trainee.advanceJava.model.Author;
import com.nagarro.trainee.advanceJava.model.Book;
import com.nagarro.trainee.advanceJava.service.IAuthorService;
import com.nagarro.trainee.advanceJava.service.IBookService;

@Controller
public class BookController {

	@Autowired
	private IBookService iBookService;

	@Autowired
	private IAuthorService iAuthorService;

	@RequestMapping("/showEditPage")
	public String show() {
		return "editBook";
	}

	@RequestMapping("/editBook/{aid}")
	public ModelAndView displayEditPage(@PathVariable int aid) {
		System.out.println("In edit page");
		ModelAndView mv = new ModelAndView();
		Book book = iBookService.getBook(aid);
		List<Author> authors = iAuthorService.getAuthors();
		mv.addObject("book", book);
		System.out.println(book.getBook_name());
		mv.addObject("authors", authors);
		mv.setViewName("editBook");
		return mv;
	}

	@RequestMapping("/editBook/logoutUser")
	public String logoutUser(HttpServletRequest request, HttpServletRequest response) {
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		session.invalidate(); // to remove all data
		return "login";

	}

	@RequestMapping("/deleteBook/{aid}")
	public ModelAndView deleteBook(@PathVariable int aid) {
		iBookService.deleteBook(aid);
		System.out.println("Book deleted Succesfully");
		List<Object> list = iBookService.getBooks();
		ModelAndView mv = new ModelAndView();
		mv.addObject("books", list);
		mv.setViewName("bookListing");
		return mv;
	}

	@RequestMapping("/displayAddBook")
	public ModelAndView displayAddBookPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addBook");
		List<Author> authors = iAuthorService.getAuthors();
		System.out.println("hi");
		System.out.println(authors);
		System.out.println("hello");
		mv.addObject("authors", authors);
		return mv;
	}

	@RequestMapping("/addBook")
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) {

		String book_code = request.getParameter("book_code");
		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String added_on_date = request.getParameter("added_on_date");
		System.out.println(book_code);
		System.out.println(book_name);
		System.out.println(author);
		System.out.println(added_on_date);
		Book book = new Book();
		book.setBook_code(book_code);
		book.setBook_name(book_name);
		book.setAuthor(author);
		book.setAdded_on_date(added_on_date);
		iBookService.addBook(book);
		List<Object> list = iBookService.getBooks();
		ModelAndView mv = new ModelAndView();
		mv.addObject("books", list);
		mv.setViewName("bookListing");
		return mv;
	}

	
	@RequestMapping("/editBook/editBook")
	public ModelAndView editBook(HttpServletRequest request, HttpServletResponse response) {
		
		String book_code = request.getParameter("book_code");
		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String added_on_date = request.getParameter("added_on_date");
		System.out.println(book_code);
		System.out.println(book_name);
		System.out.println(author);
		System.out.println(added_on_date);
		Book book = new Book();
		book.setBook_code(book_code);
		book.setBook_name(book_name);
		book.setAuthor(author);
		book.setAdded_on_date(added_on_date);
		iBookService.editBook(book);
		List<Object> list = iBookService.getBooks();
		ModelAndView mv = new ModelAndView();
		mv.addObject("books", list);
		mv.setViewName("bookListing");
		return mv;
		

	}

}
