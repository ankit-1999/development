package com.nagarro.trainee.advanceJava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.dao.IUserDao;
import com.nagarro.trainee.advanceJava.model.User;
import com.nagarro.trainee.advanceJava.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao iUserDao;

	public boolean validateUser(String userName, String password) {
		User user = iUserDao.getUser(userName);// to avoid null value
		System.out.println(user);
		if (user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

}
