package com.nagarro.trainee.advanceJava.service.impl;

import java.io.File;

import com.nagarro.trainee.advanceJava.dao.ProductDao;
import com.nagarro.trainee.advanceJava.service.IProductService;

public class ProductServiceImpl implements IProductService {

	@Override
	public void addProduct(String title, int quantity, int size, String image) {
		// TODO Auto-generated method stub
		ProductDao.addProduct(title, quantity, size, image);

	}

	@Override
	public void editProduct(String title, int quantity, int size, String image) {
		// TODO Auto-generated method stub
		ProductDao.editProduct(title, quantity, size, image);

	}

	@Override
	public long getImageSize(String image) {
		// TODO Auto-generated method stub
		String fileName = "Photos/" + image;
		File file = new File(fileName);
		if (file.exists()) {
			// size of a file (in bytes)
			long bytes = file.length();

			long kilobytes = (bytes / 1024);
			return kilobytes;
		} else {
			System.out.println("File does not exist!");
		}

		return 0;
	}

	@Override
	public boolean validateImageSize(String image) {

		if (getImageSize(image) <= 1024) {
			return true;
		}
		return false;
	}

	@Override
	public void deletProduct(String title) {
		// TODO Auto-generated method stub
		ProductDao.deleteProduct(title);
	}

}
