package com.yash.springExcelExport.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yash.model.ExcelReport;

public class UserExcelExporter1 {

	public static ByteArrayInputStream reportToExcel(List<ExcelReport> listExcelReport) throws IOException {

		String[] columns = { "Audit Id", "Date", "Occupied Seat", "Bus Number", "Bus Name", "No Of Staff", "Driver Name",
				"Driver Mobile Number", "Conductor Name", "Conductor Mobile Number", "Source City Name",
				"Source City State", "Source City Pincode", "Destination City", "Destination City State",
				"Destination City Pincode", "Arrival Time", "Departure Time" };
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		try(
			Workbook workbook=new XSSFWorkbook();
				ByteArrayOutputStream out=new ByteArrayOutputStream();
				
			){
			Sheet sheet=workbook.createSheet("Audit");
			Font headerFont=workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			
			CellStyle headerCellStyle=workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			
			//Row For Header
			Row headerRow=sheet.createRow(0);
			
			//Header 
			for(int col=0;col<columns.length;col++) {
				Cell cell=headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
				
			}
			int rowIdx=1;
			for(ExcelReport e:listExcelReport) {
				Row row=sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(e.getAuditId());
				row.createCell(1).setCellValue(dateFormat.format(e.getDate()));
				row.createCell(2).setCellValue(e.getOccupiedSeats());
				row.createCell(3).setCellValue(e.getBusNumber());
				row.createCell(4).setCellValue(e.getBusName());
				row.createCell(5).setCellValue(e.getNoOfStaff());
				row.createCell(6).setCellValue(e.getDriverName());
				row.createCell(7).setCellValue(e.getDriverMobileNumber());
				row.createCell(8).setCellValue(e.getConductorName());
				row.createCell(9).setCellValue(e.getConductorMobileNumber());
				row.createCell(10).setCellValue(e.getSourceCityName());
				row.createCell(11).setCellValue(e.getSourceCityState());
				row.createCell(12).setCellValue(e.getSourcePincode());
				row.createCell(13).setCellValue(e.getDestinationCityName());
				row.createCell(14).setCellValue(e.getDestinationCityState());
				row.createCell(15).setCellValue(e.getDestinationPincode());
				row.createCell(16).setCellValue(timeFormat.format(e.getArrivalTime()));
				row.createCell(17).setCellValue(timeFormat.format(e.getDepartureTime()));
				
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

}
