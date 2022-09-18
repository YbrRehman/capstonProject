package com.homeinsurance.exceptions;

public class InsuranceIdNotFoundException extends  RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsuranceIdNotFoundException() {
		super();
	}

	public InsuranceIdNotFoundException(String message) {
		super(message);
	}

}
