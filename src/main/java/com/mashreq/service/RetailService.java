package com.mashreq.service;

import org.springframework.stereotype.Service;

import com.mashreq.dto.CheckoutRequest;
import com.mashreq.dto.CheckoutResponse;

/**
 * 
 * @author jasar_jamaludheen
 * Retail service interface
 *
 */
public interface RetailService {

	public CheckoutResponse checkoutProducts(CheckoutRequest checkoutRequest) throws Exception;

}
