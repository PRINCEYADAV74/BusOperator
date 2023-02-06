package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.model.Bus;
import com.yash.repository.BusRepository;

@Service
public class BusService {

	@Autowired
	private BusRepository busRepository;

	public List<Bus> findAll() {
		return busRepository.findAll();
	}

	public Bus findById(int id) {
		return busRepository.findById(id);
	}

	public String deleteById(int id) {
		if (busRepository.deleteById(id) > 0)
			return busRepository.deleteById(id) + " Bus(s) deleted from the database";
		else
			return busRepository.deleteById(id)
					+ " Bus(s) deleted from the database because There is no data available for this Primary key ,Please look into it";

	}

	public String softDeleteById(int id) {
		if (busRepository.softDeleteById(id) > 0)
			return busRepository.softDeleteById(id) + " Bus(s) deleted from the database";
		else
			return busRepository.softDeleteById(id)
					+ " Bus(s) deleted from the database because There is no data available for this Primary key ,Please look into it";
	}

	public String save(Bus b) {
		return busRepository.save(b) + " Employee(s) saved successfully";
	}

	public String update(Bus b, int id) {
		if (busRepository.update(b, id) > 0)
			return busRepository.update(b, id) + " Bus(s) updated successfully";

		else {
			return busRepository.update(b, id)
					+ " Bus(s) updated from the database because There is no data available for this Primary key ,Please look into it";

		}
	}

}
