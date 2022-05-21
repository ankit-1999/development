package com.nagarro.trainee.advanceJava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	String book_code;
	String book_name;
	String author;
	String added_on_date;

	public String getBook_code() {
		return book_code;
	}

	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAdded_on_date() {
		return added_on_date;
	}

	public void setAdded_on_date(String added_on_date) {
		this.added_on_date = added_on_date;
	}

}
