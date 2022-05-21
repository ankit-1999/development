package com.nagarro.trainee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.trainee.dto.SearchParamDO;
import com.nagarro.trainee.model.Product;

@Service
public interface IProductService {

	public Product getProduct(int id);

	public List<Product> getProducts();

	public List<Product> getMatchingProducts(SearchParamDO dProduct);
	
	public List<Product> getProduct(String id);

}
