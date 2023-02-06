package com.yash.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yash.model.Conductor;
import com.yash.user.mapper.UserMapperConductor;

@Repository
@PropertySource(value = { "classpath:/conductor.properties" })
public class ConductorRepositoryImpl implements ConductorRepository {
    
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Value("${detailsForConductor}")
	private String detail;

	@Value("${searchByIdConductor}")
	private String search;

	@Value("${deleteConductor}")
	private String delete;

	@Value("${insertConductor}")
	private String insert;

	@Value("${updateConductor}")
	private String update;

	@SuppressWarnings("unchecked")
	@Override
	public List<Conductor> findAll() {
		return namedParameterJdbcTemplate.query(detail, new UserMapperConductor());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Conductor findById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("conductorId", id);
		return (Conductor) namedParameterJdbcTemplate.queryForObject(search, parameters, new UserMapperConductor());
	}

	@Override
	public int deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("conductorId", id);
		return (int) namedParameterJdbcTemplate.update(delete, parameters);
	}

	@Override
	public int save(Conductor c) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("conductorName", c.getConductorName())
				.addValue("dob", c.getDob()).addValue("gender", c.getGender())
				.addValue("licenceNumber", c.getLicenceNumber()).addValue("licenceExpiryDate", c.getLicenceExpiryDate())
				.addValue("mobileNumber", c.getMobileNumber()).addValue("salary", c.getSalary())
				.addValue("status", c.getStatus());

		return namedParameterJdbcTemplate.update(insert, nameParameters);
	}

	@Override
	public int update(Conductor c, int id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("conductorId", id);
		mapSqlParameterSource.addValue("conductorName", c.getConductorName()).addValue("dob", c.getDob())
				.addValue("gender", c.getGender()).addValue("licenceNumber", c.getLicenceNumber())
				.addValue("licenceExpiryDate", c.getLicenceExpiryDate()).addValue("mobileNumber", c.getMobileNumber())
				.addValue("salary", c.getSalary()).addValue("status", c.getStatus());
		return namedParameterJdbcTemplate.update(update, mapSqlParameterSource);

	}

}
