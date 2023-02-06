package com.yash.repository;

import java.util.List;

import com.yash.model.Bus;

public interface BusRepository {

	public List<Bus> findAll();

	public Bus findById(int id);

	public int deleteById(int id);
	
	public int softDeleteById(int id);

	public int save(Bus e);

	public int update(Bus e, int id);

}
