package com.flightapp.Exception;

public class CustomizedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public CustomizedException(String msg) {
		this.msg = msg;
	}
	
	

}
