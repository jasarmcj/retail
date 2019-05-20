package com.mashreq.service;

import com.mashreq.dto.CheckoutResponse;

public interface DiscountService {

	public void applyDiscounts(CheckoutResponse checkoutResponse);
}
