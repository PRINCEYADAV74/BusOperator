package com.yash.model;

import java.sql.Date;
import java.sql.Time;

public class ExcelReport {
	// For Audit Table
	private int auditId;
	private Date date;
	private int occupiedSeats;

	// For Bus Table
	private String busNumber;
	private String busName;
	private int noOfStaff;

	// For Driver Table
	private String driverName;
	private String DriverMobileNumber;

	// For Conductor Table
	private String conductorName;
	private String ConductorMobileNumber;

	// For City Table
	private String sourceCityName;
	private String sourceCityState;
	private int sourcePincode;

	private String destinationCityName;
	private String destinationCityState;
	private int destinationPincode;

	// For Schedule Table
	private Time arrivalTime;
	private Time departureTime;

//      For Route Table
//		private int sourceCityId;
//		private int destinationCityId;

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOccupiedSeats() {
		return occupiedSeats;
	}

	public void setOccupiedSeats(int occupiedSeats) {
		this.occupiedSeats = occupiedSeats;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getNoOfStaff() {
		return noOfStaff;
	}

	public void setNoOfStaff(int noOfStaff) {
		this.noOfStaff = noOfStaff;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobileNumber() {
		return DriverMobileNumber;
	}

	public void setDriverMobileNumber(String driverMobileNumber) {
		DriverMobileNumber = driverMobileNumber;
	}

	public String getConductorName() {
		return conductorName;
	}

	public void setConductorName(String conductorName) {
		this.conductorName = conductorName;
	}

	public String getConductorMobileNumber() {
		return ConductorMobileNumber;
	}

	public void setConductorMobileNumber(String conductorMobileNumber) {
		ConductorMobileNumber = conductorMobileNumber;
	}

	public String getSourceCityName() {
		return sourceCityName;
	}

	public void setSourceCityName(String sourceCityName) {
		this.sourceCityName = sourceCityName;
	}

	public String getSourceCityState() {
		return sourceCityState;
	}

	public void setSourceCityState(String sourceCityState) {
		this.sourceCityState = sourceCityState;
	}

	public int getSourcePincode() {
		return sourcePincode;
	}

	public void setSourcePincode(int sourcePincode) {
		this.sourcePincode = sourcePincode;
	}

	public String getDestinationCityName() {
		return destinationCityName;
	}

	public void setDestinationCityName(String destinationCityName) {
		this.destinationCityName = destinationCityName;
	}

	public String getDestinationCityState() {
		return destinationCityState;
	}

	public void setDestinationCityState(String destinationCityState) {
		this.destinationCityState = destinationCityState;
	}

	public int getDestinationPincode() {
		return destinationPincode;
	}

	public void setDestinationPincode(int destinationPincode) {
		this.destinationPincode = destinationPincode;
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
		return "ExcelReport [auditId=" + auditId + ", date=" + date + ", occupiedSeats=" + occupiedSeats
				+ ", busNumber=" + busNumber + ", busName=" + busName + ", noOfStaff=" + noOfStaff + ", driverName="
				+ driverName + ", DriverMobileNumber=" + DriverMobileNumber + ", conductorName=" + conductorName
				+ ", ConductorMobileNumber=" + ConductorMobileNumber + ", sourceCityName=" + sourceCityName
				+ ", sourceCityState=" + sourceCityState + ", sourcePincode=" + sourcePincode + ", destinationCityName="
				+ destinationCityName + ", destinationCityState=" + destinationCityState + ", destinationPincode="
				+ destinationPincode + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}

}
