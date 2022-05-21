package com.nagarro.trainee.advanceJava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.advanceJava.model.Book;

@Repository
public interface IBookDao extends JpaRepository<Book, Integer> {

}
