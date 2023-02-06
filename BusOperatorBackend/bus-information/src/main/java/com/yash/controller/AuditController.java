package com.yash.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.custom.exception.EmptyInputException;
import com.yash.custom.exception.IncorrectInputException;
import com.yash.model.Audit;
import com.yash.model.ExcelReport;
import com.yash.service.AuditService;
import com.yash.springExcelExport.excel.UserExcelExporter1;
import com.yash.springExcelExport.excel.UserExcelExporterFinal;

@CrossOrigin(origins ="http://localhost:3002")
@RestController
@RequestMapping("/audit")
public class AuditController {

	@Autowired
	private AuditService auditService;

	@GetMapping("/details")
	public List<Audit> findAll() {
		List<Audit> a = auditService.findAll();
		if (a.isEmpty()) {
			throw new EmptyInputException();
		}
		return a;
	}


	@GetMapping("/report/excel")
	public void exportToExcelFinal(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Final_info.xlsx";

		response.setHeader(headerKey, headervalue);
		List<ExcelReport> listexcelReport = auditService.generateReport();
		UserExcelExporterFinal exp = new UserExcelExporterFinal(listexcelReport);
		exp.export(response);

	}
	
	@GetMapping("/report/excel/bytearray")
	public ResponseEntity<InputStreamResource> exportToExcelFinal1() throws IOException{
		List<ExcelReport> listexcelReport = auditService.generateReport();
		
		ByteArrayInputStream in =UserExcelExporter1.reportToExcel(listexcelReport);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Final_infoo.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
		
		

	}

	
	@GetMapping("/report/sourceanddestination/{source}/{destination}")
	public ResponseEntity<InputStreamResource> exportToExcelUsingSourceAndDestination(@PathVariable String source,
			@PathVariable String destination) throws IOException {
		
		List<ExcelReport> listexcelReport = auditService.generateReportUsingSourceAndDestination(source, destination);;
		ByteArrayInputStream in =UserExcelExporter1.reportToExcel(listexcelReport);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=ReportUsingSourceToDestination.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
		

	}

	
	@GetMapping("/report/bydate")
	public ResponseEntity<InputStreamResource> exportToExcelBydate(@RequestParam("date") String date)
			throws IOException {
      List<ExcelReport> listexcelReport = auditService.generateReportByDate(date);
		
		ByteArrayInputStream in =UserExcelExporter1.reportToExcel(listexcelReport);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=AuditReportUsingDate.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	

	@GetMapping("/{id}")
	public Audit findById(@PathVariable int id) {
		return auditService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return auditService.deleteById(id);
	}

	@PostMapping("/insert")
	public String save(@RequestBody Audit a) {
		if (a.getDate().toString().length() == 0) {
			throw new EmptyInputException();
		}

		else if (a.getScheduleId() < 0 || a.getOccupiedSeats() < 0) {
			throw new IncorrectInputException();

		} else
			return auditService.save(a);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Audit a, @PathVariable int id) {

		if (a.getDate().toString().length() == 0) {
			throw new EmptyInputException();
		}

		else if (a.getScheduleId() < 0 || a.getOccupiedSeats() < 0) {
			throw new IncorrectInputException();

		} else
			return auditService.update(a, id);
	}

}
