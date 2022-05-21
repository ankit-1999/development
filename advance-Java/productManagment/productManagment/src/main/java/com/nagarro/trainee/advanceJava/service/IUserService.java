package com.nagarro.trainee.advanceJava.service;

public interface IUserService {
	
	public boolean validateUser(String userName, String password);
	
	public String getPassword(String username);
	
	
}
