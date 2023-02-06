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

import com.yash.model.Route;
import com.yash.user.mapper.UserMapperRoute;

@Repository
@PropertySource(value = { "classpath:/route.properties" })
public class RouteRepositoryImpl implements RouteRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Value("${detailsForRoute}")
	private String detail;

	@Value("${searchByIdRoute}")
	private String search;

	@Value("${deleteRoute}")
	private String delete;

	@Value("${insertRoute}")
	private String insert;

	@Value("${updateRoute}")
	private String update;

	@SuppressWarnings("unchecked")
	@Override
	public List<Route> findAll() {
		return namedParameterJdbcTemplate.query(detail, new UserMapperRoute());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Route findById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("routeId", id);
		return (Route) namedParameterJdbcTemplate.queryForObject(search, parameters, new UserMapperRoute());
	}

	@Override
	public int deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("routeId", id);
		return (int) namedParameterJdbcTemplate.update(delete, parameters);
	}

	@Override
	public int save(Route r) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("sourceCityId", r.getSourceCityId())
				.addValue("destinationCityId", r.getDestinationCityId());
		return namedParameterJdbcTemplate.update(insert, nameParameters);
	}

	@Override
	public int update(Route c, int id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("routeId", id);
		mapSqlParameterSource.addValue("sourceCityId", c.getSourceCityId()).addValue("destinationCityId",
				c.getDestinationCityId());
		return namedParameterJdbcTemplate.update(update, mapSqlParameterSource);

	}

}
