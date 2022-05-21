package com.nagarro.trainee.advanceJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainee.advanceJava.model.Book;
import com.nagarro.trainee.advanceJava.service.IBookService;

@RestController
public class BookController {

	@Autowired
	IBookService iBookService;

	@GetMapping("/Books")
	public List<Book> getBooks() {
		List<Book> list = iBookService.getBooks();
		return list;

	}

	@PutMapping("/Book")
	public Book saveOrUpdateBook(@RequestBody Book book) {
		iBookService.editBook(book);
		return book;
	}

	// @RequestBody Book book

	@PostMapping("/Book")
	public Book addBook(@RequestBody Book book) {
		iBookService.addBook(book);
		return book;
	}

	@DeleteMapping("/delete/{aid}")
	public String deleteBook(@PathVariable int aid) {
		iBookService.deleteBook(aid);
		return "deleted";
	}

	@GetMapping("/Book/{aid}")
	public Book getBook(@PathVariable("aid") int aid) {
		Book book= iBookService.getBook(aid);
		 System.out.println("book got succesfully");
		 System.out.println(book);
		 return book;
	}

}
