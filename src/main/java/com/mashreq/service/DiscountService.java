package com.mashreq.service;

import org.springframework.stereotype.Service;

import com.mashreq.dto.CheckoutResponse;

/**
 * 
 * @author jasar_jamaludheen
 * Interface to be implemented for applying discounts to the chck out bill
 *
 */
public interface DiscountService {

	public void applyDiscounts(CheckoutResponse checkoutResponse) throws Exception;
}
