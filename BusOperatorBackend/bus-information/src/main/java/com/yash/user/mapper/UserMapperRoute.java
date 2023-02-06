package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.Route;

public class UserMapperRoute implements RowMapper {

	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
		Route route = new Route();

		route.setRouteId(rs.getInt("RouteId"));
		route.setSourceCityId(rs.getInt("SourceCityId"));
		route.setDestinationCityId(rs.getInt("DestinationCityId"));

		return route;
	}

}
