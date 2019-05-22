package com.mashreq.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mashreq.dto.CheckoutResponse;
import com.mashreq.service.DiscountService;

/**
 * 
 * @author jasar_jamaludheen
 * Class to apply discount by total amount in the bill
 * 
 * 1.	For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).
 * 2. A user can get only one of the percentage based discounts on a bill.
 *
 */
@Service
public class DiscountByAmountServiceImpl implements DiscountService {
	
	private final double discountByAmount = 100.00;
	private final double discountAmount = 5.00;
	
	private static final Logger _LOGGER = LogManager.getLogger(DiscountByAmountServiceImpl.class);

	@Override
	public void applyDiscounts(CheckoutResponse checkoutResponse) throws Exception {
		
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
