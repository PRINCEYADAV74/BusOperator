package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.Driver;

public class UserMapperDriver implements RowMapper {

	public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
		Driver driver = new Driver();
		driver.setDriverId(rs.getInt("DriverId"));
		driver.setDriverName(rs.getString("DriverName"));
		driver.setDob(rs.getDate("DOB"));
		driver.setGender(rs.getString("Gender"));
		driver.setLicenceNumber(rs.getString("LicenceNumber"));
		driver.setLicenceExpiryDate(rs.getDate("LicenceExpiryDate"));
		driver.setMobileNumber(rs.getString("MobileNumber"));
		driver.setSalary(rs.getInt("Salary"));
		driver.setStatus(rs.getString("Status"));

		return driver;
	}

}
