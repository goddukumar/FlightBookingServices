package com.flightapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.FlightSchedule;
import com.flightapp.Entity.AirLine;
import com.flightapp.Entity.BookTicket;
import com.flightapp.Entity.Flight;
import com.flightapp.Repository.AirlineRepository;
import com.flightapp.Repository.BookTicketRepository;
import com.flightapp.Repository.FlightRepository;
import com.flightapp.Repository.SearchFlightRepository;
import com.flightapp.dto.BookTicketDTO;

@Service
public class UserService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private SearchFlightRepository searchFlightRepository;

	@Autowired
	private BookTicketRepository bookTicketRepository;

	public List<FlightSchedule> findFlightSchedule(String fromLocation, String toLocation)  {
        if (fromLocation != null && toLocation != null) {
            List<FlightSchedule> flightSchedule = searchFlightRepository.findScheduledFlights(fromLocation, toLocation);
            List<FlightSchedule> flightSchedules = new ArrayList<>();
            if (!flightSchedule.isEmpty()) {
                for (FlightSchedule fs : flightSchedule) {
                    FlightSchedule schedule = new FlightSchedule();
                    if (fs.getAirLineCode() != null) {
                        Optional<AirLine> airline = airlineRepository.findById(fs.getAirLineCode());
                        if (airline.isPresent()) {
                            if (airline.get().isStatus()==false) {
                                flightSchedules.add(fs);
                            }
                        }
                    }
                }
                return flightSchedules;
            } 
        }
		return null;
    }

	public BookTicket bookTicket(String flightNumber, BookTicketDTO bookTicketDTO) {
		if (flightNumber != null) {
			BookTicket ticket = new BookTicket();
			Optional<FlightSchedule> flightSchedule = searchFlightRepository.findScheduledFlight(flightNumber);
			if (flightSchedule.isPresent()) {
				BeanUtils.copyProperties(bookTicketDTO, ticket, bookTicketDTO.getDepartureDate());
				ticket.setPnrNo("PNR" + new Random().nextInt());
				ticket.setFlightNumber(flightSchedule.get().getFlightNumber());
				ticket.setArrivalDate(flightSchedule.get().getEndDateTime());
				ticket.setStatus("Booked");
				if (bookTicketDTO.getDepartureDate() != null) {
					//ticket.setDepartureDate((LocalDateTime) convertToFbsFormat(bookTicketDTO.getDepartureDate()));
				}
				Optional<Flight> flight = flightRepository.findById(flightNumber);
				if (flight.isPresent()) {
					flight.get().setAvailableSeats(flight.get().getAvailableSeats() - bookTicketDTO.getSeats());
					flightRepository.save(flight.get());
				}
				return bookTicketRepository.save(ticket);
			} else {

			}
		} else {

		}
		return null;
	}

	public List<BookTicket> searchByEmail(String email){
		return bookTicketRepository.searchByEmail(email);
	}

	public List<BookTicket> searchByPnr(String pnrNo)  {
		return bookTicketRepository.searchByPnr(pnrNo);
	}

	public String cancelTicket(String pnrNo, String status) {
		if (status.equalsIgnoreCase("cancel")) {
			int count = bookTicketRepository.cancelTicket(pnrNo, "Cancelled");
			if (count == 1) {
				List<BookTicket> bookTickets = bookTicketRepository.searchByPnr(pnrNo);
				if (bookTickets != null && !bookTickets.isEmpty()) {
					bookTickets.forEach(bookTicket -> {
						if (bookTicket.getFlightNumber() != null && !bookTickets.isEmpty()) {
							Optional<Flight> flight = flightRepository.findById(bookTicket.getFlightNumber());
							if (flight.isPresent()) {
								flight.get()
										.setAvailableSeats(bookTicket.getSeats() + flight.get().getAvailableSeats());
								flightRepository.save(flight.get());
							}
						}
					});
				}
				status = "ticket cancelled";
			}
		}
		return status;
	}

}
