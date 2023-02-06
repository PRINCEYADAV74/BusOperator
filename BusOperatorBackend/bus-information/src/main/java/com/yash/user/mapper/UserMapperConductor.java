package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.Conductor;

public class UserMapperConductor implements RowMapper {

	public Conductor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Conductor conductor = new Conductor();
		conductor.setConductorId(rs.getInt("ConductorId"));
		conductor.setConductorName(rs.getString("ConductorName"));
		conductor.setDob(rs.getDate("DOB"));
		conductor.setGender(rs.getString("Gender"));
		conductor.setLicenceNumber(rs.getString("LicenceNumber"));
		conductor.setLicenceExpiryDate(rs.getDate("LicenceExpiryDate"));
		conductor.setMobileNumber(rs.getString("MobileNumber"));
		conductor.setSalary(rs.getInt("Salary"));
		conductor.setStatus(rs.getString("Status"));

		return conductor;
	}
}
