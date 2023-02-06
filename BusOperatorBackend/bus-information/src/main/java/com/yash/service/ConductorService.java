package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.model.Conductor;
import com.yash.repository.ConductorRepository;

@Service
public class ConductorService {

	@Autowired
	private ConductorRepository conductorRepository;

	public List<Conductor> findAll() {
		return conductorRepository.findAll();
	}

	public Conductor findById(int id) {
		return conductorRepository.findById(id);
	}

	public String deleteById(int id) {
		if (conductorRepository.deleteById(id) > 0)
			return conductorRepository.deleteById(id) + " Conductor(s) deleted from the database";
		else
			return conductorRepository.deleteById(id)
					+ " Conductor(s) deleted from the database because There is no data available for this Primary key ,Please look into it";

	}

	public String save(Conductor c) {
		return conductorRepository.save(c) + " Conductor(s) saved successfully";
	}

	public String update(Conductor c, int id) {
		if (conductorRepository.update(c, id) > 0)
			return conductorRepository.update(c, id) + " Conductor(s) updated successfully";

		else {
			return conductorRepository.update(c, id)
					+ " Conductor(s) updated from the database because There is no data available for this Primary key ,Please look into it";

		}
	}
}
