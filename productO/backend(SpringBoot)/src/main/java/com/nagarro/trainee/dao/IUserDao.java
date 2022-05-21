package com.nagarro.trainee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, String> {

}
