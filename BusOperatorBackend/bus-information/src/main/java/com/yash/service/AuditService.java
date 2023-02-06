package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.model.Audit;
import com.yash.model.ExcelReport;
import com.yash.repository.AuditRepository;

@Service
public class AuditService {
	@Autowired
	private AuditRepository auditRepository;

	public List<Audit> findAll() {
		return auditRepository.findAll();
	}

	public List<ExcelReport> generateReport() {
		return auditRepository.generateReport();
	}

	public List<ExcelReport> generateReportUsingSourceAndDestination(String a, String b) {
		return auditRepository.generateReportUsingSourceAndDestination(a, b);
	}

	public List<ExcelReport> generateReportByDate(String date) {
		return auditRepository.generateReportByDate(date);
	}

	public Audit findById(int id) {
		return auditRepository.findById(id);
	}

	public String deleteById(int id) {

		if (auditRepository.deleteById(id) > 0)
			return auditRepository.deleteById(id) + " Audit(s) deleted from the database";
		else
			return auditRepository.deleteById(id)
					+ " Audit(s) deleted from the database because There is no data available for this Primary key ,Please look into it";

	}

	public String save(Audit a) {
		return auditRepository.save(a) + " Audit(s) saved successfully";
	}

	public String update(Audit a, int id) {
		if (auditRepository.update(a, id) > 0)
			return auditRepository.update(a, id) + " Audit(s) updated successfully";

		else {
			return auditRepository.update(a, id)
					+ " Audit(s) updated from the database because There is no data available for this Primary key ,Please look into it";

		}
	}
}