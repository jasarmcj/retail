package com.mashreq.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	private Long productId;
	private String productType;
	private String productName;
	private Double productPrice;
	private Boolean discountAllowed;

	@Id
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Boolean getDiscountAllowed() {
		return discountAllowed;
	}

	public void setDiscountAllowed(Boolean discountAllowed) {
		this.discountAllowed = discountAllowed;
	}
}
