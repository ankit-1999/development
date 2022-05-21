package com.nagarro.trainee.advanceJava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.model.Book;

@Service
public interface IBookService {

	public void addBook(Book book);

	public void deleteBook(int id);

	public void editBook(Book book);

	public List<Object> getBooks();

	public Book getBook(int id);

}
