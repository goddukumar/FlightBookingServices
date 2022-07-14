package com.flightapp.Exception;

public class CustomizedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg1;

	public CustomizedException(String msg1) {
		this.msg1 = msg1;
	}
}
