package com.nagarro.trainee.advanceJava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.advanceJava.model.Author;

@Repository
public interface IAuthorDao extends JpaRepository<Author, Integer> {
	

}
