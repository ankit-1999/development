package com.nagarro.trainee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainee.dto.SearchParamDO;
import com.nagarro.trainee.model.Product;
import com.nagarro.trainee.service.IProductService;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	IProductService iProductService;

	@GetMapping("/Product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product product = iProductService.getProduct(id);
		System.out.println("product got succesfully");
		System.out.println(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/Products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = iProductService.getProducts();
		System.out.println("products got succesfully");
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping("/searchProduct")
	public ResponseEntity<List<Product>> getSearchProducts(@RequestBody SearchParamDO cProduct) {
		// iProductService.getMatchingProducts(cProduct);
		List<Product> products = iProductService.getMatchingProducts(cProduct);
		System.out.println("hi");
		return new ResponseEntity<>(products, HttpStatus.OK);

	}

	@GetMapping("/Products/{id}")
	public ResponseEntity<List<Product>> getProduct(@PathVariable("id") String id) {
		List<Product> product = iProductService.getProduct(id);
		System.out.println("product got succesfully");
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

}
