package com.nagarro.trainee.advanceJava.service.impl;

import com.nagarro.trainee.advanceJava.dao.UserDao;
import com.nagarro.trainee.advanceJava.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public boolean validateUser(String userName, String password) {
		return UserDao.validateUser(userName, password);
	}

	@Override
	public String getPassword(String username) {
		// TODO Auto-generated method stub
		return UserDao.getPassword(username);
	}

}
