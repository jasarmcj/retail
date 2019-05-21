package com.mashreq.exception;

/**
 * 
 * @author jasar_jamaludheen
 * 
 * Exception class to handle application exceptions
 *
 */
public class RetailAppException extends RuntimeException {

	public RetailAppException() {
		
	}
	
	public RetailAppException(String errorMsg) {
		super(errorMsg);
	}
}
