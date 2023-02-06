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
import com.yash.model.Driver;
import com.yash.user.mapper.UserMapperDriver;

@Repository
@PropertySource(value = { "classpath:/driver.properties" })
public class DriverRepositoryImpl implements DriverRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Value("${detailsForDriver}")
	private String detail;

	@Value("${searchByIdDriver}")
	private String search;

	@Value("${deleteDriver}")
	private String delete;

	@Value("${insertDriver}")
	private String insert;

	@Value("${updateDriver}")
	private String update;

	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> findAll() {
		return namedParameterJdbcTemplate.query(detail, new UserMapperDriver());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Driver findById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("driverId", id);
		return (Driver) namedParameterJdbcTemplate.queryForObject(search, parameters, new UserMapperDriver());
	}

	@Override
	public int deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("driverId", id);
		return (int) namedParameterJdbcTemplate.update(delete, parameters);
	}

	@Override
	public int save(Driver d) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("driverName", d.getDriverName())
				.addValue("dob", d.getDob()).addValue("gender", d.getGender())
				.addValue("licenceNumber", d.getLicenceNumber()).addValue("licenceExpiryDate", d.getLicenceExpiryDate())
				.addValue("mobileNumber", d.getMobileNumber()).addValue("salary", d.getSalary())
				.addValue("status", d.getStatus());

		return namedParameterJdbcTemplate.update(insert, nameParameters);
	}

	@Override
	public int update(Driver d, int id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("driverId", id);
		mapSqlParameterSource.addValue("driverName", d.getDriverName()).addValue("dob", d.getDob())
				.addValue("gender", d.getGender()).addValue("licenceNumber", d.getLicenceNumber())
				.addValue("licenceExpiryDate", d.getLicenceExpiryDate()).addValue("mobileNumber", d.getMobileNumber())
				.addValue("salary", d.getSalary()).addValue("status", d.getStatus());
		return namedParameterJdbcTemplate.update(update, mapSqlParameterSource);

	}

}
