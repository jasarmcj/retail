package com.mashreq.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jasar_jamaludheen
 * 
 * POJO for holding user checkout request
 *
 */
public class CheckoutRequest {

	private Long userId;
	private List<Long> selectedProducts = new ArrayList<Long>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<Long> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

	
}
