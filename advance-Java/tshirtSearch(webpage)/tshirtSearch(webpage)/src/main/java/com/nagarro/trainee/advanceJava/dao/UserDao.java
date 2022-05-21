package com.nagarro.trainee.advanceJava.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.advanceJava.model.User;


@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// get the user
	public User getUser(String userName) {
		System.out.println("in dao");
		System.out.println(this.hibernateTemplate);
		User user=this.hibernateTemplate.get(User.class, userName);
		return user;
	}
	

}
