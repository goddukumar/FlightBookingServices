
package com.flightapp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@OneToMany(mappedBy="airLine")
	private List<FlightDetails> flightDetails;



	public AirLine() {
	}

	public AirLine(String airLineCode, String airLineName, boolean status) {
		this.airLineCode = airLineCode;
		this.airLineName = airLineName;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<FlightDetails> getFlightDetails() {
		return flightDetails;
	}

}
