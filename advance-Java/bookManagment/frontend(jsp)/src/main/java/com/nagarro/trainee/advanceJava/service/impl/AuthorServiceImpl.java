package com.nagarro.trainee.advanceJava.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.trainee.advanceJava.constant.AuthorRestApiUrl;
import com.nagarro.trainee.advanceJava.model.Author;
import com.nagarro.trainee.advanceJava.service.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService {

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Author> list = restTemplate.getForObject(AuthorRestApiUrl.GETAUTHORAPI, List.class);
		return list;
	}

}
