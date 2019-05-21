package com.mashreq.dto;

/**
 * 
 * @author jasar_jamaludheen
 * 
 * POJO for holding selected product details
 *
 */
public class SelectedProduct {

	private Long productId;
	private String productName;
	private String productType;
	private Double productPrice;
	private Double productPriceAfterDiscount;
	private Double discountPercentage;
	private Boolean discountAllowed;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Double getProductPriceAfterDiscount() {
		return productPriceAfterDiscount;
	}

	public void setProductPriceAfterDiscount(Double productPriceAfterDiscount) {
		this.productPriceAfterDiscount = productPriceAfterDiscount;
	}

	public Boolean getDiscountAllowed() {
		return discountAllowed;
	}

	public void setDiscountAllowed(Boolean discountAllowed) {
		this.discountAllowed = discountAllowed;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
