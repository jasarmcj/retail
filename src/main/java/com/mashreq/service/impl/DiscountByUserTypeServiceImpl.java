package com.mashreq.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mashreq.dto.CheckoutResponse;
import com.mashreq.dto.SelectedProduct;
import com.mashreq.dto.UserDto;
import com.mashreq.service.DiscountService;

/**
 * 
 * @author jasar_jamaludheen
 * Class to apply discount by user type
 * 
 * 1.	If the user is an employee of the store, he gets a 30% discount
 * 2.	If the user is an affiliate of the store, he gets a 10% discount
 * 3.	If the user has been a customer for over 2 years, he gets a 5% discount.
 * 4.	The percentage based discounts do not apply on groceries.
 * 5.	A user can get only one of the percentage based discounts on a bill.
 *
 */
@Service
public class DiscountByUserTypeServiceImpl implements DiscountService {

	private final double employeeDiscountPercenage = 30.00;
	private final double affiliateDiscountPercenage = 10.00;
	
	private final int loyalUserYear = 2;
	private final double loyalUserDiscountPercenage = 5.00;
	
	private static final Logger _LOGGER = LogManager.getLogger(DiscountByUserTypeServiceImpl.class);
	
	@Override
	public void applyDiscounts(CheckoutResponse checkoutResponse) throws Exception {
		
		UserDto user = checkoutResponse.getUser();
		
		double discountPercentage = 0.00;
		if("EMPLOYEE".equalsIgnoreCase(user.getUserType())) {
			discountPercentage = employeeDiscountPercenage;
		} else if("AFFILIATE".equalsIgnoreCase(user.getUserType())) {
			discountPercentage = affiliateDiscountPercenage;
		}  else {
			
			if(isLoyaluser(user.getUserRegisterDate().getTime())) {
				discountPercentage = loyalUserDiscountPercenage;
			}
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
	
	private boolean isLoyaluser(long date2) throws Exception {
		
		long date1 = new Date().getTime();
		LocalDate localDate1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(date1), ZoneId.systemDefault()).toLocalDate();
		LocalDate localDate2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(date2), ZoneId.systemDefault()).toLocalDate();
		
		return Period.between(localDate2, localDate1).getYears() >= 2 ? true : false;
	}
	
}
