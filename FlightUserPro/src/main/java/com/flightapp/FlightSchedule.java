package com.flightapp;

import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightapp.Entity.Flight;

public class FlightSchedule {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int flightScheduleId;
	    private String flightNumber;
	    @JsonIgnore
	    private String airLineCode;
	    private String airLineName;
	    @OneToOne(fetch = FetchType.EAGER)
	    @JsonIgnore
	    private Flight flight;
	    private LocalDateTime startDateTime;
	    private LocalDateTime endDateTime;
	    private String fromLocation;
	    private String toLocation;
	    private String flightModel;
	    private String meal;
	    private Double ticketPrice;
		public int getFlightScheduleId() {
			return flightScheduleId;
		}
		public void setFlightScheduleId(int flightScheduleId) {
			this.flightScheduleId = flightScheduleId;
		}
		public String getFlightNumber() {
			return flightNumber;
		}
		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}
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
		public Flight getFlight() {
			return flight;
		}
		public void setFlight(Flight flight) {
			this.flight = flight;
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
		public String getFlightModel() {
			return flightModel;
		}
		public void setFlightModel(String flightModel) {
			this.flightModel = flightModel;
		}
		public String getMeal() {
			return meal;
		}
		public void setMeal(String meal) {
			this.meal = meal;
		}
		public Double getTicketPrice() {
			return ticketPrice;
		}
		public void setTicketPrice(Double ticketPrice) {
			this.ticketPrice = ticketPrice;
		}
	    
	    

}
