package com.yash.model;

public class Route {
	private int routeId;
	private int sourceCityId;
	private int destinationCityId;

	public Route(int routeId, int sourceCityId, int destinationCityId) {
		super();
		this.routeId = routeId;
		this.sourceCityId = sourceCityId;
		this.destinationCityId = destinationCityId;
	}

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getSourceCityId() {
		return sourceCityId;
	}

	public void setSourceCityId(int sourceCityId) {
		this.sourceCityId = sourceCityId;
	}

	public int getDestinationCityId() {
		return destinationCityId;
	}

	public void setDestinationCityId(int destinationCityId) {
		this.destinationCityId = destinationCityId;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", sourceCityId=" + sourceCityId + ", destinationCityId="
				+ destinationCityId + "]";
	}

}
