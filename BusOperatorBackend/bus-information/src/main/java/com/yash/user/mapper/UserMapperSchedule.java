package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.Schedule;

public class UserMapperSchedule implements RowMapper {

	public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		Schedule schedule = new Schedule();

		schedule.setScheduleId(rs.getInt("ScheduleId"));
		schedule.setBusId(rs.getInt("BusId"));
		schedule.setDriverId(rs.getInt("DriverId"));
		schedule.setConductorId(rs.getInt("ConductorId"));
		schedule.setRouteId(rs.getInt("RouteId"));
		schedule.setArrivalTime(rs.getTime("ArrivalTime"));
		schedule.setDepartureTime(rs.getTime("DepartureTime"));

		return schedule;
	}
}
