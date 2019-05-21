package com.mashreq.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jasar_jamaludheen
 * 
 * POJO for holding checkout response data
 *
 */
public class CheckoutResponse {

	private UserDto user;
	private Double totalPrice;
	private Double totalDiscount;
	private Double totalPriceAfterDiscount;
	private List<SelectedProduct> selectedProducts = new ArrayList<SelectedProduct>();

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<SelectedProduct> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<SelectedProduct> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Double getTotalPriceAfterDiscount() {
		return totalPriceAfterDiscount;
	}

	public void setTotalPriceAfterDiscount(Double totalPriceAfterDiscount) {
		this.totalPriceAfterDiscount = totalPriceAfterDiscount;
	}

}
