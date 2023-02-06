package com.yash.model;

import java.util.Date;

public class Conductor {
	private int conductorId;
	private String conductorName;
	private Date dob;
	private String gender;
	private String licenceNumber;
	private Date licenceExpiryDate;
	private String mobileNumber;
	private int salary;
	private String status;

	public Conductor(int conductorId, String conductorName, Date dob, String gender, String licenceNumber,
			Date licenceExpiryDate, String mobileNumber, int salary, String status) {
		super();
		this.conductorId = conductorId;
		this.conductorName = conductorName;
		this.dob = dob;
		this.gender = gender;
		this.licenceNumber = licenceNumber;
		this.licenceExpiryDate = licenceExpiryDate;
		this.mobileNumber = mobileNumber;
		this.salary = salary;
		this.status = status;
	}

	public Conductor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getConductorId() {
		return conductorId;
	}

	public void setConductorId(int conductorId) {
		this.conductorId = conductorId;
	}

	public String getConductorName() {
		return conductorName;
	}

	public void setConductorName(String conductorName) {
		this.conductorName = conductorName;
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
		return "Conductor [conductorId=" + conductorId + ", conductorName=" + conductorName + ", dob=" + dob
				+ ", gender=" + gender + ", licenceNumber=" + licenceNumber + ", licenceExpiryDate=" + licenceExpiryDate
				+ ", mobileNumber=" + mobileNumber + ", salary=" + salary + ", status=" + status + "]";
	}

}
