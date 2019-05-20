package com.mashreq.service;

import org.springframework.stereotype.Service;

import com.mashreq.dto.CheckoutRequest;
import com.mashreq.dto.CheckoutResponse;

@Service
public interface RetailService {

	public CheckoutResponse checkoutProducts(CheckoutRequest checkoutRequest) throws Exception;

}
