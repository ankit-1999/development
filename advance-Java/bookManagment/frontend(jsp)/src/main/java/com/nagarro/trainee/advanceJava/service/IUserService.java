package com.nagarro.trainee.advanceJava.service;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {

	public boolean validateUser(String userName, String password);

}
