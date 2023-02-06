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

import com.yash.model.Schedule;
import com.yash.user.mapper.UserMapperSchedule;

@Repository
@PropertySource(value = { "classpath:/schedule.properties" })
public class ScheduleRepositoryImpl implements ScheduleRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Value("${detailsForSchedule}")
	private String detail;

	@Value("${searchByIdSchedule}")
	private String search;

	@Value("${deleteSchedule}")
	private String delete;

	@Value("${insertSchedule}")
	private String insert;

	@Value("${updateSchedule}")
	private String update;

	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> findAll() {
		return namedParameterJdbcTemplate.query(detail, new UserMapperSchedule());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Schedule findById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("scheduleId", id);
		return (Schedule) namedParameterJdbcTemplate.queryForObject(search, parameters, new UserMapperSchedule());
	}

	@Override
	public int deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("scheduleId", id);
		return (int) namedParameterJdbcTemplate.update(delete, parameters);
	}

	@Override
	public int save(Schedule s) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("busId", s.getBusId())
				.addValue("driverId", s.getDriverId()).addValue("conductorId", s.getConductorId())
				.addValue("routeId", s.getRouteId()).addValue("arrivalTime", s.getArrivalTime())
				.addValue("departureTime", s.getDepartureTime());
		return namedParameterJdbcTemplate.update(insert, nameParameters);
	}

	@Override
	public int update(Schedule s, int id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("scheduleId", id);
		mapSqlParameterSource.addValue("busId", s.getBusId()).addValue("driverId", s.getDriverId())
				.addValue("conductorId", s.getConductorId()).addValue("routeId", s.getRouteId())
				.addValue("arrivalTime", s.getArrivalTime()).addValue("departureTime", s.getDepartureTime());
		return namedParameterJdbcTemplate.update(update, mapSqlParameterSource);

	}

}
