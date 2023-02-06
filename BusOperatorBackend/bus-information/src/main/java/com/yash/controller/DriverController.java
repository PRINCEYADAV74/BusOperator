package com.yash.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.custom.exception.EmptyInputException;
import com.yash.custom.exception.IncorrectInputException;
import com.yash.model.Driver;
import com.yash.service.DriverService;

@RequestMapping("/driver")
@RestController
public class DriverController {
	@Autowired
	private DriverService driverService;

	@GetMapping("/details")
	public List<Driver> findAll() {
		List<Driver> d = driverService.findAll();
		if (d.isEmpty()) {
			throw new EmptyInputException();
		}
		return d;
	}

	@GetMapping("/{id}")
	public Driver findById(@PathVariable int id) {
		return driverService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return driverService.deleteById(id);
	}

	@PostMapping("/insert")
	public String save(@RequestBody Driver d) {
		if (d.getDriverName().length() == 0 || d.getDob().toString().length() == 0 || d.getGender().length() == 0
				|| d.getLicenceNumber().length() == 0 || d.getMobileNumber().length() == 0
				|| d.getLicenceExpiryDate().toString().length() == 0 || d.getStatus().length() == 0) {
			throw new EmptyInputException();
		}

		else if (d.getSalary() < 0) {
			throw new IncorrectInputException();

		} else
			return driverService.save(d);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Driver d, @PathVariable int id) {
		if (d.getDriverName().length() == 0 || d.getDob().toString().length() == 0 || d.getGender().length() == 0
				|| d.getLicenceNumber().length() == 0 || d.getMobileNumber().length() == 0
				|| d.getLicenceExpiryDate().toString().length() == 0 || d.getStatus().length() == 0) {
			throw new EmptyInputException();
		}

		else if (d.getSalary() < 0) {
			throw new IncorrectInputException();

		} else
			return driverService.update(d, id);

	}

}
