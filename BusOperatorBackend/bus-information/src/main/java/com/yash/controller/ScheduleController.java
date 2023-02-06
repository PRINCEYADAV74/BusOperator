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
import com.yash.model.Schedule;
import com.yash.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/details")
	public List<Schedule> findAll() {
		List<Schedule> s = scheduleService.findAll();
		if (s.isEmpty()) {
			throw new EmptyInputException();
		}
		return s;
	}

	@GetMapping("/{id}")
	public Schedule findById(@PathVariable int id) {
		return scheduleService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return scheduleService.deleteById(id);
	}

	@PostMapping("/insert")
	public String save(@RequestBody Schedule s) {
		if (s.getArrivalTime().toString().length() == 0 || s.getDepartureTime().toString().length() == 0) {
			throw new EmptyInputException();
		}

		else if (s.getBusId() < 0 || s.getDriverId() < 0 || s.getConductorId() < 0 || s.getRouteId() < 0) {
			throw new IncorrectInputException();

		} else
			return scheduleService.save(s);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Schedule s, @PathVariable int id) {
		if (s.getArrivalTime().toString().length() == 0 || s.getDepartureTime().toString().length() == 0) {
			throw new EmptyInputException();
		}

		else if (s.getBusId() < 0 || s.getDriverId() < 0 || s.getConductorId() < 0 || s.getRouteId() < 0) {
			throw new IncorrectInputException();

		} else
			return scheduleService.update(s, id);
	}

}
