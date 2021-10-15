package com.flightapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Air_Lines")
public class AirLine {
	
	@Id
	@Column(name = "Air_Line_Code")
	private String airLineCode;

	@Column(name = "Air_Line_Name")
	private String airLineName;

	@Column(name = "Air_Line_Status")
	private boolean status;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	    
	    

}
