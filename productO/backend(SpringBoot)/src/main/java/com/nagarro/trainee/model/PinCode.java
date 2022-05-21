package com.nagarro.trainee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PinCode {

	@Id
	@Column(name = "s_no")
	int sNo;

	@Column(name = "product_code", length = 255)
	String productCode;

	@Column(name = "pin_code", length = 6)
	String pinCode;

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
