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
import com.yash.model.City;
import com.yash.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CityService cityService;

	@GetMapping("/details")
	public List<City> findAll() {
		List<City> c = cityService.findAll();
		if (c.isEmpty()) {
			throw new EmptyInputException();
		}
		return c;
	}

	@GetMapping("/{id}")
	public City findById(@PathVariable int id) {
		return cityService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return cityService.deleteById(id);
	}

	@PostMapping("/insert")
	public String save(@RequestBody City c) {
		if (c.getCityName().isEmpty() || c.getCityName().length() == 0 || c.getCityState().isEmpty()
				|| c.getCityState().length() == 0) {
			throw new EmptyInputException();
		}

		else if (c.getPincode() <= 0 || Integer.valueOf(c.getPincode()).toString().isEmpty()) {
			throw new IncorrectInputException();

		} else
			return cityService.save(c);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody City c, @PathVariable int id) {

		if (c.getCityName().isEmpty() || c.getCityName().length() == 0 || c.getCityState().isEmpty()
				|| c.getCityState().length() == 0) {
			throw new EmptyInputException();
		}

		else if (c.getPincode() <= 0 || Integer.valueOf(c.getPincode()).toString().isEmpty()) {
			throw new IncorrectInputException();

		} else
			return cityService.update(c, id);

	}
}
