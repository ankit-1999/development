package com.nagarro.trainee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainee.dao.IProductDao;
import com.nagarro.trainee.dto.SearchParamDO;
import com.nagarro.trainee.model.Product;
import com.nagarro.trainee.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDao iProductDao;

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			String s = String.valueOf(id);
			product = iProductDao.findById(s).orElse(new Product());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products = null;
		try {
			products = iProductDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getMatchingProducts(SearchParamDO dProduct) {
		// TODO Auto-generated method stub

		if (dProduct.getMaxPrice() == 0) {
			dProduct.setMaxPrice(999999);
		}
		System.out.println("max" + dProduct.getMaxPrice());
		String s;
		if (dProduct.getProductId() == 0) {
			s = "";
		} else {
			s = String.valueOf(dProduct.getProductId());

		}
		System.out.println(s);
		List<Product> products = null;
		try {
			products = iProductDao.getMatchingProducts(dProduct.getProductBrand(), dProduct.getProductName(), s,
					dProduct.getMinPrice(), dProduct.getMaxPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// List<Product> products = iProductDao.get(s);
		System.out.println(dProduct.toString());
		return products;
	}

	@Override
	public List<Product> getProduct(String id) {
		// TODO Auto-generated method stub
		List<Product> products = null;
		try {
			products = iProductDao.getMatchingProducts(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

}
