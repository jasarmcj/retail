package com.mashreq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashreq.dao.ProductDao;
import com.mashreq.dao.UserDao;
import com.mashreq.dto.CheckoutRequest;
import com.mashreq.dto.CheckoutResponse;
import com.mashreq.dto.SelectedProduct;
import com.mashreq.dto.UserDto;
import com.mashreq.entity.Product;
import com.mashreq.entity.User;
import com.mashreq.service.DiscountService;
import com.mashreq.service.RetailService;

@Service
public class RetailServiceImpl implements RetailService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private List<DiscountService> discountServices;
	
	@Override
	public CheckoutResponse checkoutProducts(CheckoutRequest checkoutRequest) throws Exception {
		
		CheckoutResponse checkoutResp = new CheckoutResponse();
		User user = userDao.getOne(checkoutRequest.getUserId());
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		checkoutResp.setUser(userDto);
		
		List<SelectedProduct> selectedProductList = new ArrayList<SelectedProduct>();
		double totalPrice = 0.00;
		for(Long productId : checkoutRequest.getSelectedProducts()) {
			Product product = productDao.getOne(productId);
			SelectedProduct selectedProduct = new SelectedProduct();
			selectedProduct.setProductId(product.getProductId());
			selectedProduct.setProductName(product.getProductName());
			selectedProduct.setProductType(product.getProductType());
			selectedProduct.setProductPrice(product.getProductPrice());
			selectedProduct.setProductPriceAfterDiscount(product.getProductPrice());
			selectedProduct.setDiscountAllowed(product.getDiscountAllowed());
			
			selectedProductList.add(selectedProduct);			
			totalPrice = totalPrice + product.getProductPrice();
		}
		checkoutResp.setSelectedProducts(selectedProductList);
		checkoutResp.setTotalPrice(totalPrice);
		
		System.out.println("sizeeee=> " + discountServices.size());
		for(DiscountService discountService : discountServices) {
			discountService.applyDiscounts(checkoutResp);
		}
		
		return checkoutResp;
	}
}
