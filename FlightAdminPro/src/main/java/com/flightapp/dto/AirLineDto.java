package com.flightapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class AirLineDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Air Line Code Can Not Be Empty OR Null")
	private String airLineCode;
	@NotEmpty(message="Air Line Name Can Not Be Empty OR Null")
	private String airLineName;
	@NotEmpty(message="Air Line Status Can Not Be Empty OR Null")
	private String status;
	
	public String getAirLineCode() {
		return airLineCode;
	}
	public void setAirLineCode(String airLineCode) {
		this.airLineCode = airLineCode;
	}
	public String getAirLineName() {
		return airLineName;
	}
	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}

