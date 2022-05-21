package com.nagarro.trainee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.trainee.model.User;

@Service
public interface IUserService {

	public boolean saveUser(User user);  // to register new user
	
	public User getUser(String email);  // to get particular user
	
	public List<User> getUsers();
	
}
