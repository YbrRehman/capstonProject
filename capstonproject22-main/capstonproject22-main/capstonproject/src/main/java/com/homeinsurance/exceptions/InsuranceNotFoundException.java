package com.homeinsurance.exceptions;



public class InsuranceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsuranceNotFoundException() {
		super();
	}

	public InsuranceNotFoundException(String message) {
		super(message);
	}


}
