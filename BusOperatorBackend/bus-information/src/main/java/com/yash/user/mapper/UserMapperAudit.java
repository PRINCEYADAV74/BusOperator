package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.Audit;

public class UserMapperAudit implements RowMapper {

	public Audit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Audit audit = new Audit();

		audit.setAuditId(rs.getInt("AuditId"));
		audit.setScheduleId(rs.getInt("ScheduleId"));
		audit.setDate(rs.getDate("Date"));
		audit.setOccupiedSeats(rs.getInt("OccupiedSeats"));

		return audit;
	}

}
