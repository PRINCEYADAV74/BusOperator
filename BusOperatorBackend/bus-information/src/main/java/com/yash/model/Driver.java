package com.yash.model;

import java.util.Date;

public class Driver {
	private int driverId;
	private String driverName;
	private Date dob;
	private String gender;
	private String licenceNumber;
	private Date licenceExpiryDate;
	private String mobileNumber;
	private int salary;
	private String status;

	public Driver(int driverId, String driverName, Date dob, String gender, String licenceNumber,
			Date licenceExpiryDate, String mobileNumber, int salary, String status) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.dob = dob;
		this.gender = gender;
		this.licenceNumber = licenceNumber;
		this.licenceExpiryDate = licenceExpiryDate;
		this.mobileNumber = mobileNumber;
		this.salary = salary;
		this.status = status;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public Date getLicenceExpiryDate() {
		return licenceExpiryDate;
	}

	public void setLicenceExpiryDate(Date licenceExpiryDate) {
		this.licenceExpiryDate = licenceExpiryDate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", dob=" + dob + ", gender=" + gender
				+ ", licenceNumber=" + licenceNumber + ", licenceExpiryDate=" + licenceExpiryDate + ", mobileNumber="
				+ mobileNumber + ", salary=" + salary + ", status=" + status + "]";
	}

}
