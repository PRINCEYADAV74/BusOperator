package com.yash.repository;

import java.util.List;

import com.yash.model.Driver;

public interface DriverRepository {
	
	public List<Driver> findAll();

	public Driver findById(int id);

	public int deleteById(int id);

	public int save(Driver d);

	public int update(Driver d, int id);


}
