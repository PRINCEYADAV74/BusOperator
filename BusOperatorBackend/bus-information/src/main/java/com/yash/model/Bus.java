package com.yash.model;

public class Bus {
	private int busId;
	private String busNumber;
	private String busName;
	private String fuelType;
	private int noOfPassengers;
	private int noOfStaff;
	private String seatType;
	private String busStatus;

	public Bus(int busId, String busNumber, String busName, String fuelType, int noOfPassengers, int noOfStaff,
			String seatType, String busStatus) {
		super();
		this.busId = busId;
		this.busNumber = busNumber;
		this.busName = busName;
		this.fuelType = fuelType;
		this.noOfPassengers = noOfPassengers;
		this.noOfStaff = noOfStaff;
		this.seatType = seatType;
		this.busStatus = busStatus;
	}

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
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

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public int getNoOfStaff() {
		return noOfStaff;
	}

	public void setNoOfStaff(int noOfStaff) {
		this.noOfStaff = noOfStaff;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busNumber=" + busNumber + ", busName=" + busName + ", fuelType=" + fuelType
				+ ", noOfPassengers=" + noOfPassengers + ", noOfStaff=" + noOfStaff + ", seatType=" + seatType
				+ ", busStatus=" + busStatus + "]";
	}

}