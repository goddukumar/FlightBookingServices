package com.flightapp.dto;

import java.util.List;

import com.flightapp.entity.FlightDetails;

public class AirLineBasedFlightDtls {
	private String airLineCode;
	private String airLineName;
	private List<FlightDetails> flightDetails;
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
	public List<FlightDetails> getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(List<FlightDetails> flightDetails) {
		this.flightDetails = flightDetails;
	}
}
