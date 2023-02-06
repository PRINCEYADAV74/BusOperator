package com.yash.repository;

import java.util.List;

import com.yash.model.Route;

public interface RouteRepository {
	
	public List<Route> findAll();

	public Route findById(int id);

	public int deleteById(int id);

	public int save(Route r);

	public int update(Route r, int id);

}
