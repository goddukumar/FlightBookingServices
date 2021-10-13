
package com.flightapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_Details")
public class FlightDetails {

	@Id
	private String flightNumber;
	private Integer avaiableSeats;
	private String instrumentUsed;
	private double price;
	@ManyToOne
	@JoinColumn(name="air_line_code")
	private AirLine airLine;
	
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
	
	public AirLine getAirLine() {
		return airLine;
	}
	public void setAirLine(AirLine airLine) {
		this.airLine = airLine;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
