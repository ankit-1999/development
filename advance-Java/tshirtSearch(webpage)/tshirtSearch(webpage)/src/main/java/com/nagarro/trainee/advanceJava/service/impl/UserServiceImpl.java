package com.nagarro.trainee.advanceJava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.dao.UserDao;
import com.nagarro.trainee.advanceJava.model.User;
import com.nagarro.trainee.advanceJava.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	public boolean validateUser(String userName, String password) {
		System.out.println(userName);
		User user = userDao.getUser(userName);
		System.out.println(user);
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
