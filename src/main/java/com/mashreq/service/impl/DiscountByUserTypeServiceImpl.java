package com.mashreq.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mashreq.dto.CheckoutResponse;
import com.mashreq.dto.SelectedProduct;
import com.mashreq.dto.UserDto;
import com.mashreq.service.DiscountService;

@Service
public class DiscountByUserTypeServiceImpl implements DiscountService {

	private final double employeeDiscountPercenage = 30.00;
	private final double affiliateDiscountPercenage = 10.00;
	private final double loyalUserDiscountPercenage = 5.00;
	
	private static final Logger _LOGGER = LogManager.getLogger(DiscountByUserTypeServiceImpl.class);
	
	@Override
	public void applyDiscounts(CheckoutResponse checkoutResponse) {
		
		UserDto user = checkoutResponse.getUser();
		
		double discountPercentage = 0.00;
		if("EMPLOYEE".equalsIgnoreCase(user.getUserType())) {
			discountPercentage = employeeDiscountPercenage;
		} else if("AFFILIATE".equalsIgnoreCase(user.getUserType())) {
			discountPercentage = affiliateDiscountPercenage;
		}  else if("LOYAL".equalsIgnoreCase(user.getUserType())) {
			discountPercentage = loyalUserDiscountPercenage;
		} 
		
		if(discountPercentage > 0.00) {
			
			double totalDiscount = 0.00;
			for(SelectedProduct product : checkoutResponse.getSelectedProducts()) {
				if(product.getDiscountAllowed()) {
					product.setDiscountPercentage(discountPercentage);
					double discount = product.getProductPrice().doubleValue() * discountPercentage / 100.00;
					totalDiscount = totalDiscount + discount;
					product.setProductPriceAfterDiscount(product.getProductPrice().doubleValue() - discount);
				} else {
					_LOGGER.info("Discount not applicable for product type :: " + product.getProductType());
					product.setDiscountPercentage(0.00);
					product.setProductPriceAfterDiscount(product.getProductPrice());
				}
			}
			
			_LOGGER.info("Applied discount before DiscountByUserTyper: " + checkoutResponse.getTotalDiscount());
			if(null == checkoutResponse.getTotalDiscount() || checkoutResponse.getTotalDiscount().doubleValue() < totalDiscount) {
				checkoutResponse.setTotalDiscount(totalDiscount);
				checkoutResponse.setTotalPriceAfterDiscount(checkoutResponse.getTotalPrice().doubleValue() - totalDiscount);
				_LOGGER.info("Discount applied by DiscountByUserTyper: " + checkoutResponse.getTotalDiscount());
			} else {
				_LOGGER.info("Applied discount by DiscountByAmount is greater than DiscountByUserTyper. So resetting product wise discount");
				resetDiscount(checkoutResponse);
			}
		}
	}

	private void resetDiscount(CheckoutResponse checkoutResponse) {
		for(SelectedProduct product : checkoutResponse.getSelectedProducts()) {
			product.setDiscountPercentage(0.00);
			product.setProductPriceAfterDiscount(product.getProductPrice());
			product.setDiscountAllowed(false);
		}
	}
	
}
