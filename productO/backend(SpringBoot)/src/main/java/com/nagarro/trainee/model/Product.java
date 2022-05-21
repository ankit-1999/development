package com.nagarro.trainee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

	@Id
	@Column(name = "product_id")
	String productId;

	@Column(name = "product_name", length = 255)
	String productName;

	@Column(name = "product_brand", length = 255)
	String productBrand;

	@Lob
	@Column(name = "product_image_url")
	String productImage;

	public String getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", productImage=" + productImage + ", productPrice=" + productPrice + ", productDetail="
				+ productDetail + "]";
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

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

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	@Column(name = "product_price")
	int productPrice;

	@Column(name = "product_detail", length = 1000)
	String productDetail;

}
