package com.flightapp.dto;

public class FlightDetailsDto {
	
	private String flightNumber;
	private Integer avaiableSeats;
	private String instrumentUsed;
	private double price;
	private AirLineDto airLine;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Integer getAvaiableSeats() {
		return avaiableSeats;
	}
	public void setAvaiableSeats(Integer avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}
	public String getInstrumentUsed() {
		return instrumentUsed;
	}
	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public AirLineDto getAirLine() {
		return airLine;
	}
	public void setAirLine(AirLineDto airLine) {
		this.airLine = airLine;
	}
	
	
	
}
