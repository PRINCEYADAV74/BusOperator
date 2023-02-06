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
import com.yash.model.Route;
import com.yash.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	@Autowired
	private RouteService routeService;

	@GetMapping("/details")
	public List<Route> findAll() {
		List<Route> r = routeService.findAll();
		if (r.isEmpty()) {
			throw new EmptyInputException();
		}
		return r;
	}

	@GetMapping("/{id}")
	public Route findById(@PathVariable int id) {
		return routeService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return routeService.deleteById(id);
	}

	@PostMapping("/insert")
	public String save(@RequestBody Route r) {

		if (r.getSourceCityId() < 0 || r.getDestinationCityId() < 0) {
			throw new IncorrectInputException();

		} else
			return routeService.save(r);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Route r, @PathVariable int id) {

		if (r.getSourceCityId() < 0 || r.getDestinationCityId() < 0) {
			throw new IncorrectInputException();

		} else
			return routeService.update(r, id);
	}

}
