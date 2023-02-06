package com.yash.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yash.model.City;
import com.yash.user.mapper.UserMapperCity;

@Repository
@PropertySource(value = { "classpath:/city.properties" })
public class CityRepositoryImpl implements CityRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Value("${detailsForCity}")
	private String detail;

	@Value("${searchByIdCity}")
	public String search;

	@Value("${deleteCity}")
	private String delete;

	@Value("${insertCity}")
	private String insert;

	@Value("${updateCity}")
	private String update;

	@SuppressWarnings("unchecked")
	@Override
	public List<City> findAll() {
		return namedParameterJdbcTemplate.query(detail, new UserMapperCity());
	}

	@SuppressWarnings("unchecked")
	@Override
	public City findById(int id) {
		String query = "SELECT * FROM City WHERE CityId= :cityId";
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("cityId", id);
		return (City) namedParameterJdbcTemplate.queryForObject(query, parameters, new UserMapperCity());
	}

	@Override
	public int deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("cityId", id);
		return (int) namedParameterJdbcTemplate.update(delete, parameters);
	}

	@Override
	public int save(City c) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("cityName", c.getCityName())
				.addValue("cityState", c.getCityState()).addValue("pincode", c.getPincode());
		return namedParameterJdbcTemplate.update(insert, nameParameters);
	}

	@Override
	public int update(City c, int id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("cityId", id);
		mapSqlParameterSource.addValue("cityName", c.getCityName()).addValue("cityState", c.getCityState())
				.addValue("pincode", c.getPincode());
		return namedParameterJdbcTemplate.update(update, mapSqlParameterSource);

	}

}
