package com.flightapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.dto.AirLineBasedFlightDtls;
import com.flightapp.dto.AirLineDto;
import com.flightapp.dto.FlightDetailsDto;
import com.flightapp.entity.AirLine;
import com.flightapp.entity.FlightDetails;
import com.flightapp.repo.AirLineRepo;
import com.flightapp.repo.FlightRepo;

@Service
public class FlightService {

	@Autowired
	private FlightRepo repo;

	@Autowired
	private AirLineRepo airLineRepo;

	public ResponseEntity<AirLineBasedFlightDtls> getAllFligthDetailsByAirLineCode(String airCode) {
		List<FlightDetailsDto> flightDtoList = new ArrayList<FlightDetailsDto>();
		try {
			AirLine findByAirLineCode = airLineRepo.findByAirLineCode(airCode);
			if (findByAirLineCode != null) {
				AirLineBasedFlightDtls a = new AirLineBasedFlightDtls();
				List<FlightDetails> flightDetailsByAirCode = repo.getFlightDetailsByAirCode(airCode);
				for (FlightDetails flightList : flightDetailsByAirCode) {
					FlightDetailsDto fligthDto = new FlightDetailsDto();
					fligthDto.setAvaiableSeats(flightList.getAvaiableSeats());
					fligthDto.setFlightNumber(flightList.getFlightNumber());
					fligthDto.setInstrumentUsed(flightList.getInstrumentUsed());
					fligthDto.setPrice(flightList.getPrice());
					flightDtoList.add(fligthDto);
				}

				a.setAirLineCode(findByAirLineCode.getAirLineCode());
				a.setAirLineName(findByAirLineCode.getAirLineName());
				a.setFlightDetails(flightDtoList);
				return new ResponseEntity<>(a, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<FlightDetails> addFligth(FlightDetails flight) {
		FlightDetails flightDetails = null;
		try {
			Optional<FlightDetails> findById = repo.findById(flight.getFlightNumber());
			if (!findById.isPresent()) {
				flightDetails = repo.save(flight);
				return new ResponseEntity<>(flightDetails, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.FOUND);
			}
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(flightDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<FlightDetails> updateFlight(FlightDetailsDto flight) {
		Optional<FlightDetails> flightData = repo.findById(flight.getFlightNumber());
		if (flightData.isPresent()) {
			FlightDetails existingFlightDetails = flightData.get();
			BeanUtils.copyProperties(flight, existingFlightDetails);
			AirLineDto airLine = flight.getAirLine();
			existingFlightDetails.getAirLine().setAirLineCode(airLine.getAirLineCode());
			return new ResponseEntity<>(repo.save(existingFlightDetails), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public boolean deleteFlight(String flightNumber) {
		boolean isDeleted = false;
		Optional<FlightDetails> recordExistfindById = repo.findById(flightNumber);
		if (recordExistfindById.isPresent()) {
			repo.deleteById(recordExistfindById.get().getFlightNumber());
			isDeleted = true;
		}
		return isDeleted;
	}

}
