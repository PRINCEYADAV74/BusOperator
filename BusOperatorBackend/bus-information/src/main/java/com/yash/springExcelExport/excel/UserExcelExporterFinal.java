package com.yash.springExcelExport.excel;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yash.model.ExcelReport;

public class UserExcelExporterFinal {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<ExcelReport> listExcelReport;

	public UserExcelExporterFinal(List<ExcelReport> listExcelReport) {
		this.listExcelReport = listExcelReport;
		workbook = new XSSFWorkbook();

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof Date) {
			cell.setCellValue((Date) value);
		} else if (value instanceof Time) {
			cell.setCellValue((Time) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Audit");

		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(20);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		createCell(row, 0, "Audit Information", style);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 17));
		font.setFontHeightInPoints((short) (10));

		row = sheet.createRow(1);
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "Audit Id", style);
		createCell(row, 1, "Date", style);
		createCell(row, 2, "Occupied Seat", style);
		createCell(row, 3, "Bus Number", style);
		createCell(row, 4, "Bus Name", style);
		createCell(row, 5, "No Of Staff", style);
		createCell(row, 6, "Driver Name", style);
		createCell(row, 7, "Driver Mobile Number", style);
		createCell(row, 8, "Conductor Name", style);
		createCell(row, 9, "Conductor Mobile Number", style);
		createCell(row, 10, "Source City Name", style);
		createCell(row, 11, "Source City State", style);
		createCell(row, 12, "Source City Pincode", style);
		createCell(row, 13, "Destination City", style);
		createCell(row, 14, "Destination City State", style);
		createCell(row, 15, "Destination City Pincode", style);
		createCell(row, 16, "Arrival Time", style);
		createCell(row, 17, "Departure Time", style);

	}

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

	private void writeDataLines() {
		int rowCount = 2;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ExcelReport a : listExcelReport) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, a.getAuditId(), style);
			createCell(row, columnCount++, (dateFormat.format(a.getDate())), style);
			createCell(row, columnCount++, a.getOccupiedSeats(), style);

			createCell(row, columnCount++, a.getBusNumber(), style);
			createCell(row, columnCount++, a.getBusName(), style);
			createCell(row, columnCount++, a.getNoOfStaff(), style);

			createCell(row, columnCount++, a.getDriverName(), style);
			createCell(row, columnCount++, a.getDriverMobileNumber(), style);

			createCell(row, columnCount++, a.getConductorName(), style);
			createCell(row, columnCount++, a.getConductorMobileNumber(), style);

			createCell(row, columnCount++, a.getSourceCityName(), style);
			createCell(row, columnCount++, a.getSourceCityState(), style);
			createCell(row, columnCount++, a.getSourcePincode(), style);

			createCell(row, columnCount++, a.getDestinationCityName(), style);
			createCell(row, columnCount++, a.getDestinationCityState(), style);
			createCell(row, columnCount++, a.getDestinationPincode(), style);

			createCell(row, columnCount++, (timeFormat.format(a.getArrivalTime())), style);
			createCell(row, columnCount++, (timeFormat.format(a.getDepartureTime())), style);

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
//we need to return excel result in byte array form
