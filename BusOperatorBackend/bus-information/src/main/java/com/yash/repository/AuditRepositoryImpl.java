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

import com.yash.model.Audit;
import com.yash.model.ExcelReport;
import com.yash.user.mapper.UserMapperAudit;
import com.yash.user.mapper.UserMapperExcelReport;

@Repository
@PropertySource(value = { "classpath:/audit.properties" })
public class AuditRepositoryImpl implements AuditRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Value("${detailsForAudit}")
	private String detail;

	@Value("${searchByIdAudit}")
	private String search;

	@Value("${deleteAudit}")
	private String delete;

	@Value("${insertAudit}")
	private String insert;

	@Value("${updateAudit}")
	private String update;

	@Value("${excelReport}")
	private String report;

	@Value("${excelReportForSourceAndDestination}")
	private String reportUsingSourceAndDestination;

	@Value("${excelReportByDate}")
	private String reportByDate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Audit> findAll() {
		return namedParameterJdbcTemplate.query(detail, new UserMapperAudit());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExcelReport> generateReport() {
		return namedParameterJdbcTemplate.query(report, new UserMapperExcelReport());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExcelReport> generateReportUsingSourceAndDestination(String a, String b) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("sourceCityName", a);
		parameters.put("destinationCityName", b);
		return namedParameterJdbcTemplate.query(reportUsingSourceAndDestination, parameters,
				new UserMapperExcelReport());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExcelReport> generateReportByDate(String date) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("date", date);
		return namedParameterJdbcTemplate.query(reportByDate, nameParameters, new UserMapperExcelReport());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Audit findById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("auditId", id);
		return (Audit) namedParameterJdbcTemplate.queryForObject(search, parameters, new UserMapperAudit());
	}

	@Override
	public int deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("auditId", id);
		return (int) namedParameterJdbcTemplate.update(delete, parameters);
	}

	@Override
	public int save(Audit a) {
		SqlParameterSource nameParameters = new MapSqlParameterSource("scheduleId", a.getScheduleId())
				.addValue("date", a.getDate()).addValue("occupiedSeats", a.getOccupiedSeats());

		return namedParameterJdbcTemplate.update(insert, nameParameters);
	}

	@Override
	public int update(Audit a, int id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("auditId", id);
		mapSqlParameterSource.addValue("scheduleId", a.getScheduleId()).addValue("date", a.getDate())
				.addValue("occupiedSeats", a.getOccupiedSeats());
		return namedParameterJdbcTemplate.update(update, mapSqlParameterSource);

	}

}
