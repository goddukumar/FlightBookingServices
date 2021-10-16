package com.flightapp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.dto.FlightScheduleDto;
import com.flightapp.entity.AirLine;
import com.flightapp.entity.FlightDetails;
import com.flightapp.entity.FlightSchedule;
import com.flightapp.repo.AirLineRepo;
import com.flightapp.repo.FlightRepo;
import com.flightapp.repo.FlightScheduleRepo;

@Service
public class FlightScheduleService {

	private FlightScheduleRepo repo;
	private AirLineRepo airLineRepo;
	private FlightRepo flightRepo;

	public FlightScheduleService(FlightScheduleRepo repo, AirLineRepo airLineRepo, FlightRepo flightRepo) {
		this.repo = repo;
		this.airLineRepo = airLineRepo;
		this.flightRepo = flightRepo;
	}

	public ResponseEntity<FlightSchedule> addFlightSchedule(FlightScheduleDto dto) {
		FlightSchedule flightSchedule = new FlightSchedule();
		Optional<AirLine> airLineDtls = airLineRepo.findById(dto.getAirLineCode());
		if (airLineDtls.isPresent()) {
			if (airLineDtls.get().isStatus()) {
				Optional<FlightDetails> flighDtls = flightRepo.findById(dto.getFlightNumber());
				if (flighDtls.isPresent()) {
					flightSchedule.setFlightNumber(flighDtls.get().getFlightNumber());
					flightSchedule.setAirLineCode(airLineDtls.get().getAirLineCode());
					flightSchedule.setAirLineName(airLineDtls.get().getAirLineName());
					flightSchedule.setToLocation(dto.getToLocation());
					flightSchedule.setFromLocation(dto.getFromLocation());
					flightSchedule.setTicketPrice(flighDtls.get().getPrice());
					if (dto.getStartDateTime() != null) {
						flightSchedule.setStartDateTime(convetDateTime(dto.getStartDateTime()));
					}
					if (dto.getEndDateTime() != null) {
						flightSchedule.setEndDateTime(convetDateTime(dto.getEndDateTime()));
					}
					flightSchedule.setMeal(dto.getMeal());
					flightSchedule.setFlightDtls(flighDtls.get());
					FlightSchedule schedule = repo.save(flightSchedule);
					return new ResponseEntity<>(schedule, HttpStatus.OK);
				}
			}
		}
		return null;

	}

	public void findAllFlightSchedules() {
		// TODO Auto-generated method stub

	}

	private LocalDateTime convetDateTime(String dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		if (dateTime != null)
			return LocalDateTime.parse(dateTime, formatter);
		return null;
	}

}
