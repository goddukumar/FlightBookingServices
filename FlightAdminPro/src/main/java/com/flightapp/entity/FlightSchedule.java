package com.flightapp.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Scheduled_Dtls")
public class FlightSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private int scheduleId;

	@Column(name = "start_date_time")
	private LocalDateTime startDateTime;

	@Column(name = "end_date_time")
	private LocalDateTime endDataTime;

	@Column(name = "from_location")
	private String fromLocation;

	@Column(name = "toLocation")
	private String toLocation;

	@Column(name = "meal")
	private String meal;

	@ManyToOne(targetEntity = FlightDetails.class,cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	@JoinColumn(name = "flight_number")
	private FlightDetails flightDtls;

	@Transient
	private String startDatTim;

	@Transient
	private String endDateTim;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDataTime() {
		return endDataTime;
	}

	public void setEndDataTime(LocalDateTime endDataTime) {
		this.endDataTime = endDataTime;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public FlightDetails getFlightDtls() {
		return flightDtls;
	}

	public void setFlightDtls(FlightDetails flightDtls) {
		this.flightDtls = flightDtls;
	}

	public String getStartDatTim() {
		return startDatTim;
	}

	public void setStartDatTim(String startDatTim) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		if (startDatTim != null) {
			this.startDateTime = LocalDateTime.parse(startDatTim, formatter);
		}
		this.startDatTim = startDatTim;
	}

	public String getEndDateTim() {
		return endDateTim;
	}

	public void setEndDateTim(String endDateTim) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		if (endDateTim != null) {
			this.endDataTime = LocalDateTime.parse(endDateTim, formatter);
		}
		this.endDateTim = endDateTim;
	}

}
