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
import com.yash.model.Conductor;
import com.yash.service.ConductorService;

@RestController
@RequestMapping("/conductor")
public class ConductorController {

	@Autowired
	private ConductorService conductorService;

	@GetMapping("/details")
	public List<Conductor> findAll() {
		List<Conductor> c = conductorService.findAll();
		if (c.isEmpty()) {
			throw new EmptyInputException();
		}
		return c;
	}

	@GetMapping("/{id}")
	public Conductor findById(@PathVariable int id) {
		return conductorService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return conductorService.deleteById(id);
	}

	@PostMapping("/insert")
	public String save(@RequestBody Conductor c) {
		if (c.getConductorName().length() == 0 || c.getDob().toString().length() == 0 || c.getGender().length() == 0
				|| c.getMobileNumber().length() == 0 || c.getStatus().length() == 0) {
			throw new EmptyInputException();
		}

		else if (c.getSalary() < 0) {
			throw new IncorrectInputException();

		} else
			return conductorService.save(c);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Conductor c, @PathVariable int id) {
		if (c.getConductorName().length() == 0 || c.getDob().toString().length() == 0 || c.getGender().length() == 0
				|| c.getMobileNumber().length() == 0 || c.getStatus().length() == 0) {
			throw new EmptyInputException();
		}

		else if (c.getSalary() < 0) {
			throw new IncorrectInputException();

		} else
			return conductorService.update(c, id);
	}

}
