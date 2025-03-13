package com.crm.genericutility.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityTest {
		public String fetchDataFromExcelFile(String sheetname, int rownum, int celvalue) throws IOException {
			FileInputStream fis = new FileInputStream("./configAppsData/testcases.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetname).getRow(rownum).getCell(celvalue).getStringCellValue();
			return data;
		}

		public int fetchRowCount(String sheetname) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./configAppsData/testcases.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			int rowCount = wb.getSheet(sheetname).getLastRowNum();
			return rowCount;
		}
		
		public Cell setDataBackToExcel(String sheetname, int rownum, int celnum) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./configAppsData/testcases.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Cell celData = wb.getSheet(sheetname).getRow(rownum).createCell(celnum);
			
			FileOutputStream fos = new FileOutputStream("./configAppsData/testcases.xlsx");
			wb.write(fos);
			return celData;
		}

}
