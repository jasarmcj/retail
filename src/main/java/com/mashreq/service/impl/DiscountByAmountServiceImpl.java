package com.mashreq.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mashreq.dto.CheckoutResponse;
import com.mashreq.service.DiscountService;

@Service
public class DiscountByAmountServiceImpl implements DiscountService {
	
	private final double discountByAmount = 100.00;
	private final double discountAmount = 100.00;
	
	private static final Logger _LOGGER = LogManager.getLogger(DiscountByAmountServiceImpl.class);

	@Override
	public void applyDiscounts(CheckoutResponse checkoutResponse) {
		
		double totalDiscount = (checkoutResponse.getTotalPrice().doubleValue() / discountByAmount) * discountAmount;
		double totalPriceAfterDiscount = checkoutResponse.getTotalPrice().doubleValue() - totalDiscount;
		
		_LOGGER.info("Applied discount before DiscountByAmount: " + checkoutResponse.getTotalDiscount());
		if(null == checkoutResponse.getTotalDiscount() || checkoutResponse.getTotalDiscount().doubleValue() < totalDiscount) {
			checkoutResponse.setTotalDiscount(totalDiscount);
			checkoutResponse.setTotalPriceAfterDiscount(totalPriceAfterDiscount);
			_LOGGER.info("Discount applied by DiscountByAmount: " + checkoutResponse.getTotalDiscount());
		}
		
	}

}
