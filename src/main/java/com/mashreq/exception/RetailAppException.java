package com.mashreq.exception;

public class RetailAppException extends RuntimeException {

	public RetailAppException() {
		
	}
	
	public RetailAppException(String errorMsg) {
		super(errorMsg);
	}
}
