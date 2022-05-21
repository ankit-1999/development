package com.nagarro.trainee.advanceJava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.model.Book;

@Service
public interface IBookService {
	
	public List<Book> getBooks();
	
	public Book getBook(int id);
	
	public String editBook(Book book);
	
	public String addBook(Book book);
	
	public String deleteBook(int aid);
	
	

}
