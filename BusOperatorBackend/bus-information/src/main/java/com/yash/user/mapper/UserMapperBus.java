package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.*;
import org.springframework.jdbc.core.RowMapper;
import com.yash.model.Bus;

public class UserMapperBus implements RowMapper {

	public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bus bus = new Bus();
		bus.setBusId(rs.getInt("BusId"));
		bus.setBusNumber(rs.getString("BusNumber"));
		bus.setBusName(rs.getString("BusName"));
		bus.setFuelType(rs.getString("FuelType"));
		bus.setNoOfPassengers(rs.getInt("NoOfPassengers"));
		bus.setNoOfStaff(rs.getInt("NoOfstaff"));
		bus.setSeatType(rs.getString("SeatType"));
		bus.setBusStatus(rs.getString("BusStatus"));

		return bus;
	}

}