package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.model.Route;
import com.yash.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository routeRepository;

	public List<Route> findAll() {
		return routeRepository.findAll();
	}

	public Route findById(int id) {
		return routeRepository.findById(id);
	}

	public String deleteById(int id) {

		if (routeRepository.deleteById(id) > 0)
			return routeRepository.deleteById(id) + " Route(s) deleted from the database";
		else
			return routeRepository.deleteById(id)
					+ " Route(s) deleted from the database because There is no data available for this Primary key ,Please look into it";

	}

	public String save(Route r) {
		return routeRepository.save(r) + " Route(s) saved successfully";
	}

	public String update(Route r, int id) {
		if (routeRepository.update(r, id) > 0)
			return routeRepository.update(r, id) + " Route(s) updated successfully";

		else {
			return routeRepository.update(r, id)
					+ " Route(s) updated from the database because There is no data available for this Primary key ,Please look into it";

		}

	}
}
