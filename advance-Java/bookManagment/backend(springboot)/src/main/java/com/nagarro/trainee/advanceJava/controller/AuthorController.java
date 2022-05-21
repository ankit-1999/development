package com.nagarro.trainee.advanceJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainee.advanceJava.model.Author;
import com.nagarro.trainee.advanceJava.service.IAuthorService;

@RestController
public class AuthorController {

	@Autowired
	IAuthorService iAuthorService;

	@RequestMapping("/home")
	public String home() {

		System.out.println("inside home");

		return "home";
	}

	@GetMapping(path = "/Authors")
	public List<Author> getAuthors() {
		List<Author> list = iAuthorService.getAuthors();
		return list;

	}

}
