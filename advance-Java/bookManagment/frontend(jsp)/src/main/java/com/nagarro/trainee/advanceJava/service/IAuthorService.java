package com.nagarro.trainee.advanceJava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.model.Author;

@Service

public interface IAuthorService {

	public List<Author> getAuthors();

}
