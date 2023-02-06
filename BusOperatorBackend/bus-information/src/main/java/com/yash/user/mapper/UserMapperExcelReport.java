package com.yash.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.ExcelReport;

public class UserMapperExcelReport implements RowMapper {

	public ExcelReport mapRow(ResultSet rs, int rowNum) throws SQLException {

		ExcelReport excel = new ExcelReport();

		excel.setAuditId(rs.getInt("AuditId"));
		excel.setDate(rs.getDate("Date"));
		excel.setOccupiedSeats(rs.getInt("OccupiedSeats"));

		excel.setBusNumber(rs.getString("BusNumber"));
		excel.setBusName(rs.getString("BusName"));
		excel.setNoOfStaff(rs.getInt("NoOfstaff"));

		excel.setDriverName(rs.getString("DriverName"));
		excel.setDriverMobileNumber(rs.getString("MobileNumber"));

		excel.setConductorName(rs.getString("ConductorName"));
		excel.setConductorMobileNumber(rs.getString("MobileNumber"));

		excel.setSourceCityName(rs.getString("SourceCity"));
		excel.setSourceCityState(rs.getString("SourceCityState"));
		excel.setSourcePincode(rs.getInt("SourceCityPinCode"));

		excel.setDestinationCityName(rs.getString("DestinationCity"));
		excel.setDestinationCityState(rs.getString("DestinationCityState"));
		excel.setDestinationPincode(rs.getInt("DestinationCityPinCode"));

		excel.setArrivalTime(rs.getTime("ArrivalTime"));
		excel.setDepartureTime(rs.getTime("DepartureTime"));

		return excel;

	}

}
