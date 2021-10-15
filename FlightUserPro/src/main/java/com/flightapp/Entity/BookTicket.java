package com.flightapp.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "book_ticket_dtls")
public class BookTicket {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ticketId;
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
	    
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    @Fetch(FetchMode.JOIN)
	    @JoinColumn(name = "ticketId")
	    private List<PassengerDetails> passengers;

	    public Long getTicketId() {
			return ticketId;
		}

		public void setTicketId(Long ticketId) {
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

		public List<PassengerDetails> getPassengers() {
			return passengers;
		}

		public void setPassengers(List<PassengerDetails> passengers) {
			this.passengers = passengers;
		}

		
	    
	    

	
	
}
