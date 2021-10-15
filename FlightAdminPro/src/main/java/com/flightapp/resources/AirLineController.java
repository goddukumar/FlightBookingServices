package com.flightapp.resources;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.Exception.CustomizedException;
import com.flightapp.dto.AirLineDto;
import com.flightapp.entity.AirLine;
import com.flightapp.service.AirLineService;

@RestController
public class AirLineController {

	private AirLineService service;

	@Autowired
	public AirLineController(AirLineService service) {
		this.service = service;
	}

	@GetMapping("/showAllAirLines")
	public ResponseEntity<List<AirLine>> getAllAirLines() {
		return service.findAllAirlines();
	}
	
	@GetMapping("/getAirLineByCode/{airLineCode}")
	public ResponseEntity<AirLine> getAirLineByAirLineCode(@PathVariable String airLineCode) throws CustomizedException
	{
		return service.findById(airLineCode);
	}

	@PostMapping("/addAirLine")
	public ResponseEntity<AirLine> addAirLine(@Valid @RequestBody AirLineDto airLineDto) throws CustomizedException {
		return service.save(airLineDto);
	}

	@PutMapping("/updateAirLineBlockOrUnblock")
	public ResponseEntity<AirLine> updateAirLine(@Valid @RequestBody AirLineDto airLineDto) {
		return service.upDateAirLine(airLineDto);
	}

	@DeleteMapping("deleteAirLineId/{airLineCode}")
	public boolean deleteAirLine(@Valid @PathVariable String airLineCode) throws CustomizedException {
			return service.delateAirLine(airLineCode);
	}

}
