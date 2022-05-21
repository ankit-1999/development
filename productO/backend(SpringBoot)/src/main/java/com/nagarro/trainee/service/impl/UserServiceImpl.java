package com.nagarro.trainee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainee.dao.IUserDao;
import com.nagarro.trainee.model.User;
import com.nagarro.trainee.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao iUserDao;

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		try {
			iUserDao.save(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			user=iUserDao.findById(email).orElse(new User());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user; // will return new empty user if no user is found.....
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> users = null;
		try {
			users=iUserDao.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 // will return all users
		return users;
	}
	
	

}
