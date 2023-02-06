package com.yash.model;

import java.sql.Time;

public class Schedule {
	private int scheduleId;
	private int busId;
	private int driverId;
	private int conductorId;
	private int routeId;
	private Time arrivalTime;
	private Time departureTime;

	public Schedule(int scheduleId, int busId, int driverId, int conductorId, int routeId, Time arrivalTime,
			Time departureTime) {
		super();
		this.scheduleId = scheduleId;
		this.busId = busId;
		this.driverId = driverId;
		this.conductorId = conductorId;
		this.routeId = routeId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getConductorId() {
		return conductorId;
	}

	public void setConductorId(int conductorId) {
		this.conductorId = conductorId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", busId=" + busId + ", driverId=" + driverId + ", conductorId="
				+ conductorId + ", routeId=" + routeId + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + "]";
	}

}
