package com.flightapp.Entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BookTicket {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @JsonIgnore
	    private Integer ticketId;
	    private String pnrNo;
	    private String flightNumber;
	    private LocalDateTime departureDate;
	    private LocalDateTime arrivalDate;
	    private String fromPlace;
	    private String toPlace;
	    private String email;
	    private String name;
	    private int seats;
	    private String meal;
	    private String status;

	    @OneToMany(cascade =javax.persistence.CascadeType.ALL)
	    @Fetch(FetchMode.JOIN)
	    @JoinColumn(name = "ticketId")
	    private List<Passanger> passengers;

		

		public Integer getTicketId() {
			return ticketId;
		}

		public void setTicketId(Integer ticketId) {
			this.ticketId = ticketId;
		}

		public String getPnrNo() {
			return pnrNo;
		}

		public void setPnrNo(String pnrNo) {
			this.pnrNo = pnrNo;
		}

		public String getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}

		

		public LocalDateTime getDepartureDate() {
			return departureDate;
		}

		public void setDepartureDate(LocalDateTime departureDate) {
			this.departureDate = departureDate;
		}

		public LocalDateTime getArrivalDate() {
			return arrivalDate;
		}

		public void setArrivalDate(LocalDateTime arrivalDate) {
			this.arrivalDate = arrivalDate;
		}

		public String getFromPlace() {
			return fromPlace;
		}

		public void setFromPlace(String fromPlace) {
			this.fromPlace = fromPlace;
		}

		public String getToPlace() {
			return toPlace;
		}

		public void setToPlace(String toPlace) {
			this.toPlace = toPlace;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSeats() {
			return seats;
		}

		public void setSeats(int seats) {
			this.seats = seats;
		}

		public String getMeal() {
			return meal;
		}

		public void setMeal(String meal) {
			this.meal = meal;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<Passanger> getPassengers() {
			return passengers;
		}

		public void setPassengers(List<Passanger> passengers) {
			this.passengers = passengers;
		}
	    
	    
	
	

}
