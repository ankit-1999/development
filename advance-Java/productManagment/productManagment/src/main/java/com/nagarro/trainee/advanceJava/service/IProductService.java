package com.nagarro.trainee.advanceJava.service;

public interface IProductService {

	public void addProduct(String title, int quantity, int size, String image);

	public void editProduct(String title, int quantity, int size, String image);
	
	public long getImageSize(String image);
	
	public boolean validateImageSize(String image);
	
	public void deletProduct(String title);

}
