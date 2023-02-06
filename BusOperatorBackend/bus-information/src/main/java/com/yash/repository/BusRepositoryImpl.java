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
import com.yash.model.Bus;
import com.yash.user.mapper.UserMapperBus;

@Repository
@PropertySource(value = { "classpath:/bus.properties" })
public class BusRepositoryImpl implements BusRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Value("${detailsForBus}")
	private String detail;

	@Value("${searchByIdBus}")
	private String search;

	@Value("${deleteBus}")
	private String delete;
	
	@Value("${delete}")
	private String softDelete;

	@Value("${insertBus}")
	private String insert;

	@Value("${updateBus}")
	private String update;

	@SuppressWarnings("unchecked")
	@Override
	public List<Bus> findAll() {
		return namedParameterJdbcTemplate.query(detail, new UserMapperBus());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bus findById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("busId", id);
		return (Bus) namedParameterJdbcTemplate.queryForObject(search, parameters, new UserMapperBus());
	}

	@Override
	public int deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("busId", id);
		return (int) namedParameterJdbcTemplate.update(delete, parameters);
	}
	
	@Override
	public int softDeleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("busId", id);
		return (int) namedParameterJdbcTemplate.update(softDelete, parameters);
	}
	
	

	@Override
	public int save(Bus e) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("busNumber", e.getBusNumber())
				.addValue("busName", e.getBusName()).addValue("fuelType", e.getFuelType())
				.addValue("noOfPassengers", e.getNoOfPassengers()).addValue("noOfStaff", e.getNoOfStaff())
				.addValue("seatType", e.getSeatType()).addValue("busStatus", e.getBusStatus());

		return namedParameterJdbcTemplate.update(insert, nameParameters);
	}

	@Override
	public int update(Bus e, int id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("busId", id);
		mapSqlParameterSource.addValue("busNumber", e.getBusNumber()).addValue("busName", e.getBusName())
				.addValue("fuelType", e.getFuelType()).addValue("noOfPassengers", e.getNoOfPassengers())
				.addValue("noOfStaff", e.getNoOfStaff()).addValue("seatType", e.getSeatType())
				.addValue("busStatus", e.getBusStatus());
		return namedParameterJdbcTemplate.update(update, mapSqlParameterSource);

	}

	

}
