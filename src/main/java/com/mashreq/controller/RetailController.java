package com.mashreq.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashreq.dto.CheckoutRequest;
import com.mashreq.dto.CheckoutResponse;
import com.mashreq.dto.Response;
import com.mashreq.exception.RetailAppException;
import com.mashreq.service.RetailService;

/**
 * 
 * @author jasar_jamaludheen
 * 
 * Retail application main controller to handle the checkout requests
 *
 */
@RestController
@RequestMapping(value = "/api/v1")
public class RetailController {
	
	@Autowired
	private RetailService retailService;

	private static final Logger _LOGGER = LogManager.getLogger(RetailController.class);
	
	@PostMapping(value = "/checkout", produces = "application/json; charset=utf-8")
	public Response checkout(@RequestBody CheckoutRequest checkoutRequest) {
		System.out.println(checkoutRequest.getUserId());
		
		Response response = new Response();
		try {
			
			if(checkoutRequest.getSelectedProducts().isEmpty()) {
				throw new RetailAppException("Cart is empty. Please add some products to yuour cart and try checkout!");
			}
			
			CheckoutResponse checkoutResponse = retailService.checkoutProducts(checkoutRequest);
			response.setStatus("SUCCESS");
			response.setMessage("Operation successful");
			response.setData(checkoutResponse);
		} catch (RetailAppException e) {
			e.printStackTrace();
			
			response.setStatus("FAILURE");
			response.setMessage(e.getMessage());
			response.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			
			response.setStatus("FAILURE");
			response.setMessage("Operation failed");
			response.setData(null);
		}
		
		
		return response;
	}
}
