package com.flightapp.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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

	public List<AirLine> findAllAirlines() {
		return repo.findAll();
	}

	public AirLine save(AirLineDto airLineDto) throws CustomizedException {
		Optional<AirLine> recordExistfindById = recordExistfindById(airLineDto.getAirLineCode());
		if (!recordExistfindById.isPresent()) {
			AirLine airline = new AirLine();
			if (airLineDto.getStatus().toString().equalsIgnoreCase("0")) // block
				airline.setStatus(true);
			else if (airLineDto.getStatus().toString().equalsIgnoreCase("1")) // unblock
				airline.setStatus(false);
			BeanUtils.copyProperties(airLineDto, airline);
			return repo.save(airline);
		} else
			throw new CustomizedException("AirLine Code Exist");
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

	public Map<String, String> upDateAirLine(@Valid AirLineDto airLineDto) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (repo.findById(airLineDto.getAirLineCode()).isPresent()) {
			AirLine existingAirLine = repo.findById(airLineDto.getAirLineCode()).get();
		    BeanUtils.copyProperties(airLineDto, existingAirLine);
			repo.save(existingAirLine);
			map.put("message :: ", "Update Succesfully With Air Line Code " + airLineDto.getAirLineCode());
			return map;
		} else {
			map.put("message :: ",
					"Update UnSuccesfull there is no existing record with Air Line Code" + airLineDto.getAirLineCode());
			return map;
		}
	}

	public Optional<AirLine> recordExistfindById(String airLineCode) {
		return repo.findById(airLineCode);
	}

}
