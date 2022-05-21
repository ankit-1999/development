package com.nagarro.trainee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.model.PinCode;

@Repository
public interface IPinCodeDao extends JpaRepository<PinCode, Integer> {

	@Query("SELECT p FROM PinCode p where p.productCode=:b")
	public List<PinCode> getPinCode(@Param("b") String b);
}
