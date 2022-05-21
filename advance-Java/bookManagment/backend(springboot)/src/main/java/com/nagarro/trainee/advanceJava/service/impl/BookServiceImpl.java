package com.nagarro.trainee.advanceJava.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.dao.IBookDao;
import com.nagarro.trainee.advanceJava.model.Book;
import com.nagarro.trainee.advanceJava.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookDao iBookDao;

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return iBookDao.findAll();
	}

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return iBookDao.findById(id).orElse(new Book()); // in order to return null if no book is there
	}

	@Override
	public String editBook(Book book) {
		// TODO Auto-generated method stub
		iBookDao.save(book);
		return "book Updated";
	}

	@Override
	public String addBook(Book book) {
		// TODO Auto-generated method stub
		iBookDao.save(book);
		return "book added sucessfully";
	}

	@Override
	public String deleteBook(int aid) {
		// TODO Auto-generated method stub
		Book book = iBookDao.findById(aid).orElse(new Book());
		iBookDao.delete(book);
		return "book deleted Sucessfully";
	}

}
