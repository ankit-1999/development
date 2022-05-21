package com.nagarro.trainee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.model.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, String> {

	// ("SELECT p FROM Product p where p.productBrand like %:b%")
	@Query("SELECT p FROM Product p where p.productBrand like %:b% and p.productName like %:n% and p.productId like %:id% and  p.productPrice between :min and :max")
	public List<Product> getMatchingProducts(@Param("b") String b, @Param("n") String n, @Param("id") String id,
			@Param("min") int min, @Param("max") int max);

	// @Query("SELECT p FROM Product p where p.productId like %:id%")
	// public List<Product> get(@Param("id") String id);
	
	@Query("SELECT p FROM Product p where p.productBrand like %:b% or p.productName like %:b% ")
	public List<Product> getMatchingProducts(@Param("b") String b);
	
	

}
