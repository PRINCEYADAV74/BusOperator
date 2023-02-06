package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.City;

public class UserMapperCity implements RowMapper {

	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		City city = new City();

		city.setCityId(rs.getInt("CityId"));
		city.setCityName(rs.getString("CityName"));
		city.setCityState(rs.getString("CityState"));
		city.setPincode(rs.getInt("PinCode"));

		return city;
	}
}
