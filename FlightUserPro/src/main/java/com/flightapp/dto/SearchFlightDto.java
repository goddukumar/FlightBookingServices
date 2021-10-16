package com.flightapp.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class SearchFlightDto {

	private String fromLocation;
	private String toLocation;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;

	private String meal;
	private double ticketPrice;
	private String airLineName;
	private String flightNumber;
	private Integer avaiableSeats;

	public SearchFlightDto(String fromLocation, String toLocation, LocalDateTime startDateTime,
			LocalDateTime endDateTime, String meal, double ticketPrice, String airLineName, String flightNumber,
			Integer avaiableSeats) {
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

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
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
