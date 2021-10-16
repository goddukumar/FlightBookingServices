package com.flightapp.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.Entity.BookTicket;
import com.flightapp.Entity.FlightDetails;
import com.flightapp.Entity.FlightSchedule;
import com.flightapp.Repository.AirLineRepo;
import com.flightapp.Repository.BookTicketRepository;
import com.flightapp.Repository.FlightRepository;
import com.flightapp.Repository.SearchFlightsRepo;
import com.flightapp.dto.BookTicketDTO;
import com.flightapp.dto.SearchFlightDto;

@Service
public class UserService {

	@Autowired
	private SearchFlightsRepo repo;

	@Autowired
	private AirLineRepo airRepo;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private BookTicketRepository bookTicketRepository;

	public ResponseEntity<List<SearchFlightDto>> serachFlights(String fromLocation, String toLocation) {
		try {
			//Date startDate=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(start_date);
			/*
			 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 * LocalDateTime localDateTime = null; if (start_date != null) { localDateTime =
			 * LocalDateTime.parse(start_date, formatter); }
			 */
			
			List<SearchFlightDto> flightSchedules = repo.serachFlightsTwo(fromLocation, toLocation);
			if (!flightSchedules.isEmpty()) {
				return new ResponseEntity<>(flightSchedules, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		/*
		 * System.out.println(serachFlightsTwo); List<FlightSchedule> flightSchedule =
		 * repo.searchFlights(fromLocation, toLocation); List<FlightSchedule>
		 * flightSchedules = new ArrayList<FlightSchedule>(); if
		 * (!flightSchedule.isEmpty()) { for (FlightSchedule fs : flightSchedule) { if
		 * (fs.getAirLineCode() != null) { Optional<AirLine> airline =
		 * airRepo.findById(fs.getAirLineCode()); if (airline.isPresent()) { if
		 * (airline.get().isStatus()) { flightSchedules.add(fs); } } } } return new
		 * ResponseEntity<>(flightSchedules, HttpStatus.OK); } else { return new
		 * ResponseEntity<>(HttpStatus.NO_CONTENT); }
		 */

	}

	public ResponseEntity<BookTicket> bookTicket(String flightNumber, BookTicketDTO dto) {

		BookTicket ticket = new BookTicket();
		Optional<FlightSchedule> flightSchedule = repo.findScheduledFlight(flightNumber);
		if (flightSchedule.isPresent()) {
			BeanUtils.copyProperties(dto, ticket, dto.getDepartureDate());
			ticket.setPnrNo(String.valueOf(new Random().nextInt()));
			ticket.setFlightNumber(flightSchedule.get().getFlightNumber());
			ticket.setArrivalDate(flightSchedule.get().getEndDateTime());
			ticket.setDepartureDate(flightSchedule.get().getStartDateTime());
			ticket.setFromPlace(flightSchedule.get().getFromLocation());
			ticket.setToPlace(flightSchedule.get().getToLocation());
			ticket.setStatus("Booked");

			Optional<FlightDetails> flight = flightRepository.findById(flightNumber);
			if (flight.isPresent()) {
				flight.get().setAvaiableSeats(flight.get().getAvaiableSeats() - dto.getSeats());
				flightRepository.save(flight.get());
			}
			BookTicket bookTicket = bookTicketRepository.save(ticket);
			return new ResponseEntity<>(bookTicket, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	public List<BookTicket> searchByEmail(String email) {
		return bookTicketRepository.searchByEmail(email);
	}

	public List<BookTicket> searchByPnr(String pnrNo) {
		return bookTicketRepository.searchByPnr(pnrNo);
	}

	public String cancelTicket(String pnrNo) {
		String status = null;
		int count = bookTicketRepository.cancelTicket(pnrNo, "Cancelled");
		if (count == 1) {
			status = "ticket cancelled";
		}
		return status;
	}

}
