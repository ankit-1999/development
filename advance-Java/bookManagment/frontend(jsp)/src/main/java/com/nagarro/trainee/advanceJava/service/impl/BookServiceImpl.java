package com.nagarro.trainee.advanceJava.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.trainee.advanceJava.constant.BookRestApiUrl;
import com.nagarro.trainee.advanceJava.model.Book;
import com.nagarro.trainee.advanceJava.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	RestTemplate restTemplate = new RestTemplate();

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		HttpEntity<Book> request = new HttpEntity<Book>(book);
		restTemplate.postForObject(BookRestApiUrl.ADDBOOKAPI, request, Book.class);
		System.out.println("in book service impl add book");

	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		restTemplate.delete(BookRestApiUrl.DELETEBOOKAPI + id);
		System.out.println("in boook service impl deleteBook");
	}

	@Override
	public void editBook(Book book) {
		// TODO Auto-generated method stub
		HttpEntity<Book> request = new HttpEntity<Book>(book);
		restTemplate.put(BookRestApiUrl.UPDATEBOOKAPI, request);
		System.out.println("in book service impl editBook");

	}

	@Override
	public List<Object> getBooks() {
		// TODO Auto-generated method stub

		Object[] obj = restTemplate.getForObject(BookRestApiUrl.GETBOOKSAPI, Object[].class);
		return Arrays.asList(obj);
	}

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		Book book= restTemplate.getForObject(BookRestApiUrl.GETBOOKAPI + id, Book.class);
		System.out.println(book);
		return book;

	}

}
