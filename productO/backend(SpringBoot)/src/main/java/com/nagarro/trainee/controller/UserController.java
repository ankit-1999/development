package com.nagarro.trainee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainee.model.User;
import com.nagarro.trainee.service.IUserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	IUserService iUserService;

	@GetMapping("/User/{aid}")
	public ResponseEntity<User> getUser(@PathVariable("aid") String aid) {
		User user = iUserService.getUser(aid);
		System.out.println("user got succesfully");
		System.out.println(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/User")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		iUserService.saveUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/Users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = iUserService.getUsers();
		System.out.println("users got succesfully");
		System.out.println(users);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}
