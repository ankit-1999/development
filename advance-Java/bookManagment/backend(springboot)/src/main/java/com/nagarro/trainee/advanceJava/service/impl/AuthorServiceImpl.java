package com.nagarro.trainee.advanceJava.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.dao.IAuthorDao;
import com.nagarro.trainee.advanceJava.model.Author;
import com.nagarro.trainee.advanceJava.service.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	IAuthorDao iAuthorDao;

	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		List<Author> list = iAuthorDao.findAll();
		return list;
	}

}
