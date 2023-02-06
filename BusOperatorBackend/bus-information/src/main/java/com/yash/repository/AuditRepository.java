package com.yash.repository;

import java.util.List;

import com.yash.model.Audit;
import com.yash.model.ExcelReport;

public interface AuditRepository {

	public List<Audit> findAll();

	public List<ExcelReport> generateReport();

	public List<ExcelReport> generateReportUsingSourceAndDestination(String a, String b);

	public List<ExcelReport> generateReportByDate(String date);

	public Audit findById(int id);

	public int deleteById(int id);

	public int save(Audit a);

	public int update(Audit a, int id);

}
