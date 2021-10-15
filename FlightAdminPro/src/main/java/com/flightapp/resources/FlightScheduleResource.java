package com.flightapp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.dto.FlightScheduleDto;
import com.flightapp.entity.FlightSchedule;
import com.flightapp.service.FlightScheduleService;

@RestController
public class FlightScheduleResource {

	private FlightScheduleService flightScheduleService;

	public FlightScheduleResource(FlightScheduleService flightScheduleService) {
		this.flightScheduleService = flightScheduleService;
	}

	@PostMapping(value = "/scheduleFlights")
    public ResponseEntity<FlightSchedule> addFlightSchedule(@RequestBody FlightScheduleDto flightScheduleDTO) {
           return  flightScheduleService.addFlightSchedule(flightScheduleDTO);
    }

    @GetMapping(value = "searchAllScheduleFlights")
    public void searchAllFlightSchedule() {
        flightScheduleService.findAllFlightSchedules();
    }

}
