package com.nagarro.trainee.dto;

public class SearchParamDO {

	String productName;

	String productBrand;

	int productId;

	int maxPrice;

	int minPrice;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	@Override
	public String toString() {
		return "DummyProduct [productName=" + productName + ", productBrand=" + productBrand + ", productId="
				+ productId + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + "]";
	}

}
