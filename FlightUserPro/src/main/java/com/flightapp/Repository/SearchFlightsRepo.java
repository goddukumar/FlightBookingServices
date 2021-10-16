
package com.flightapp.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.Entity.FlightSchedule;
import com.flightapp.dto.SearchFlightDto;

public interface SearchFlightsRepo extends JpaRepository<FlightSchedule,Integer> {


	@Query("SELECT fs FROM FlightSchedule fs WHERE fs.fromLocation=?1 and fs.toLocation=?2")
	List<FlightSchedule> searchFlights(String fromLocation, String toLocation);

	@Query("SELECT fs FROM FlightSchedule fs WHERE fs.flightNumber = ?1")
	Optional<FlightSchedule> findScheduledFlight(String flightNumber);

	@Query("SELECT new com.flightapp.dto.SearchFlightDto(sc.fromLocation,sc.toLocation,sc.startDateTime,sc.endDateTime,sc.meal,"
			+ "sc.ticketPrice,ai.airLineName,fc.flightNumber,fc.avaiableSeats)  FROM FlightSchedule sc inner join  FlightDetails fc "
			+ " on sc.flightDtls.flightNumber=fc.flightNumber inner join AirLine ai on fc.airLine.airLineCode=ai.airLineCode "
			+ "where ai.status='1' and sc.fromLocation=?1 and sc.toLocation=?2 and date(sc.startDateTime)=?3")
	List<SearchFlightDto> serachFlightsTwo(String fromLocation, String toLocation, Date startDate);

}
