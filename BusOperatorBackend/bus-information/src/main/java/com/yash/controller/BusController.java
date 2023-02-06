package com.yash.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.yash.model.Bus;
import com.yash.service.BusService;


@CrossOrigin(origins ="http://localhost:3002")
@RestController
@RequestMapping("/bus")
public class BusController {
	@Autowired
	private BusService busService;

	public Logger LOGGER = LoggerFactory.getLogger(BusController.class);

	@GetMapping("/details")
	public List<Bus> findAll() {
		LOGGER.info("Showing Bus Details");
		List<Bus> b = busService.findAll();
		if (b.isEmpty()) {
			throw new EmptyInputException();
		}
		return b;
	}

	@GetMapping("/{id}")
	public Bus findById(@PathVariable int id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.error("Inside " + methodName + " id " + id);
		return busService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		LOGGER.info("Deleting Bus details");
		return busService.deleteById(id);
	}
	
	@DeleteMapping("/softdelete/{id}")  
	public String softDeleteById(@PathVariable int id) {
		LOGGER.info("Deleting Bus details");
		return busService.softDeleteById(id);
	}

	@PostMapping("/insert")
	public String save(@RequestBody Bus b) {
		LOGGER.info("Inserting Bus details");
		if (b.getBusNumber().length() == 0 || b.getBusName().length() == 0 || b.getFuelType().length() == 0
				|| b.getSeatType().length() == 0 || b.getBusStatus().length() == 0) {
			throw new EmptyInputException();
		}

		else if (b.getNoOfPassengers() < 0 || b.getNoOfStaff() < 0) {
			throw new IncorrectInputException();

		} else
			return busService.save(b);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Bus b, @PathVariable int id) {
		LOGGER.info("You are inside update method of Bus");
		if (b.getBusNumber().length() == 0 || b.getBusName().length() == 0 || b.getFuelType().length() == 0
				|| b.getSeatType().length() == 0 || b.getBusStatus().length() == 0) {
			throw new EmptyInputException();
		}

		else if (b.getNoOfPassengers() < 0 || b.getNoOfStaff() < 0) {
			throw new IncorrectInputException();

		} else
			return busService.update(b, id);
	}
}
