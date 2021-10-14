package com.flightapp.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "book_ticket_dtls")
public class BookTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ticketId;
	private String pnr_id;
	private String email;
	private String name;
	private int noOfSeats;
	private String meal;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id")
	private Status status_id;

	@OneToMany(cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "ticketId")
	private List<PassengerDetails> passengers;

}
