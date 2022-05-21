package com.nagarro.trainee.advanceJava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.advanceJava.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, String> {
	
	@Query("Select u From User u where u.user_name=:n")
	public User getUser(@Param("n") String userName);
	

}
