package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.model.City;
import com.yash.repository.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;

	public List<City> findAll() {
		return cityRepository.findAll();
	}

	public City findById(int id) {
		return cityRepository.findById(id);
	}

	public String deleteById(int id) {

		if (cityRepository.deleteById(id) > 0)
			return cityRepository.deleteById(id) + " City(s) deleted from the database";
		else
			return cityRepository.deleteById(id)
					+ " City(s) deleted from the database because There is no data available for this Primary key ,Please look into it";

	}

	public String save(City c) {
		return cityRepository.save(c) + " City(s) saved successfully";
	}

	public String update(City c, int id) {

		if (cityRepository.update(c, id) > 0)
			return cityRepository.update(c, id) + " City(s) updated successfully";

		else {
			return cityRepository.update(c, id)
					+ " City(s) updated from the database because There is no data available for this Primary key ,Please look into it";

		}

	}

}
