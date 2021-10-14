package com.flightapp.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.Exception.CustomizedException;
import com.flightapp.dto.AirLineDto;
import com.flightapp.entity.AirLine;
import com.flightapp.repo.AirLineRepo;

@Service
public class AirLineService {

	private AirLineRepo repo;

	@Autowired
	public AirLineService(AirLineRepo repo) {
		this.repo = repo;
	}

	public ResponseEntity<List<AirLine>> findAllAirlines() {
		try {
			List<AirLine> airLines = new ArrayList<AirLine>();
			repo.findAll().forEach(airLines::add);
			if (airLines.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(airLines, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<AirLine> save(AirLineDto airLineDto) throws CustomizedException {
		try {
			AirLine airline = new AirLine();
			if (airLineDto.getStatus().toString().equalsIgnoreCase("1")) // block
				airline.setStatus(true);
			else if (airLineDto.getStatus().toString().equalsIgnoreCase("0")) // unblock
				airline.setStatus(false);
			BeanUtils.copyProperties(airLineDto, airline);
			AirLine airLine = repo.save(airline);
			return new ResponseEntity<>(airLine, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public boolean delateAirLine(String airLineCode) {

		boolean isDeleted = false;
		Optional<AirLine> recordExistfindById = recordExistfindById(airLineCode);
		if (recordExistfindById.isPresent()) {
			repo.deleteById(airLineCode);
			isDeleted = true;
		}
		return isDeleted;
	}

	public ResponseEntity<AirLine> upDateAirLine(String airLineCode, @Valid AirLineDto airLineDto) {
		Optional<AirLine> airLineData = repo.findById(airLineCode);

		if (airLineData.isPresent()) {
			AirLine existingAirLine = airLineData.get();
			BeanUtils.copyProperties(airLineDto, existingAirLine);
			if (airLineDto.getStatus().toString().equalsIgnoreCase("1")) // block
				existingAirLine.setStatus(true);
			else if (airLineDto.getStatus().toString().equalsIgnoreCase("0")) // unblock
				existingAirLine.setStatus(false);
			return new ResponseEntity<>(repo.save(existingAirLine), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<AirLine> findById(String airLineCode) throws CustomizedException {
		Optional<AirLine> airLineData = repo.findById(airLineCode);
		if (airLineData.isPresent())
			return new ResponseEntity<>(airLineData.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public Optional<AirLine> recordExistfindById(String airLineCode) {
		return repo.findById(airLineCode);
	}

}
