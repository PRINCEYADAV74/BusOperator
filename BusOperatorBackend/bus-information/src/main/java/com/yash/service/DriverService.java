package com.yash.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.model.Driver;
import com.yash.repository.DriverRepository;

@Service
public class DriverService {
	@Autowired
	private DriverRepository driverRepository;

	public List<Driver> findAll() {
		return driverRepository.findAll();
	}

	public Driver findById(int id) {
		return driverRepository.findById(id);
	}

	public String deleteById(int id) {
		if (driverRepository.deleteById(id) > 0)
			return driverRepository.deleteById(id) + " Driver(s) deleted from the database";
		else
			return driverRepository.deleteById(id)
					+ " Driver(s) deleted from the database because There is no data available for this Primary key ,Please look into it";

	}

	public String save(Driver d) {
		return driverRepository.save(d) + " Driver(s) saved successfully";
	}

	public String update(Driver d, int id) {

		if (driverRepository.update(d, id) > 0)
			return driverRepository.update(d, id) + " Driver(s) updated successfully";

		else {
			return driverRepository.update(d, id)
					+ " Driver(s) updated from the database because There is no data available for this Primary key ,Please look into it";

		}

	}
}
