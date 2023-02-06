package com.yash.repository;

import java.util.List;

import com.yash.model.Conductor;

public interface ConductorRepository {

	public List<Conductor> findAll();

	public Conductor findById(int id);

	public int deleteById(int id);

	public int save(Conductor c);

	public int update(Conductor c, int id);
}
