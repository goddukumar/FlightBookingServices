
package com.flightapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity

@Table(name = "Flight_Details")
public class FlightDetails {

	@Id
	private String flightNumber;
	
	private String fromPlace;
	
	private String toPlace;


	private Integer avaiableSeats;
	
	private String instrumentUsed;
	
	private String meal;

	@Transient
	private String start_Date_Time;

	@Transient
	private String end_Date_Time;

	

}
