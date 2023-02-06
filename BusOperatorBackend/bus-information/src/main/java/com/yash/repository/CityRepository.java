package com.yash.repository;

import java.util.List;

import com.yash.model.City;

public interface CityRepository {

	public List<City> findAll();

	public City findById(int id);

	public int deleteById(int id);

	public int save(City d);

	public int update(City c, int id);

}
