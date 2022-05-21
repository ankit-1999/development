package com.nagarro.trainee.advanceJava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	String password;
	@Id
    String user_name;
	

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
