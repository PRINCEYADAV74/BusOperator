package com.yash.model;

public class City {
	private int cityId;
	private String cityName;
	private String cityState;
	private int pincode;

	public City(int cityId, String cityName, String cityState, int pincode) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityState = cityState;
		this.pincode = pincode;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityState=" + cityState + ", pincode=" + pincode
				+ "]";
	}

}