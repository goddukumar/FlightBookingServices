package com.flightapp.dto;

import java.util.Date;

public class SearchFlightDto {

	private String fromLocation;
	private String toLocation;
	private String startDateTime;
	private String endDateTime;

	private String meal;
	private double ticketPrice;
	private String airLineName;
	private String flightNumber;
	private Integer avaiableSeats;

	public SearchFlightDto(String fromLocation, String toLocation, String startDateTime, String endDateTime,
			String meal, double ticketPrice, String airLineName, String flightNumber, Integer avaiableSeats) {
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.meal = meal;
		this.ticketPrice = ticketPrice;
		this.airLineName = airLineName;
		this.flightNumber = flightNumber;
		this.avaiableSeats = avaiableSeats;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getAirLineName() {
		return airLineName;
	}

	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}

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

}
