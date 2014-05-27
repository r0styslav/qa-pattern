package com.intellias.web.qa.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.intellias.web.qa.configuration.Configuration;

/**
 * 
 * @author rpash
 * @version 1.0
 * 
 * Fetchs data from MS Excel for tests
 */

public class MsExcelDataProvider extends MainDataProvider {
	/**
	 * Method is used to fetch test configuration
	 * 
	 * @param filePath - path to excel file
	 * @return configuration - environment and browser setup
	 * 
	 */
	public static Iterator<Object[]> getMsExcelData(String fileName)
			throws IOException {
		// List for 1st row
		ArrayList<String> objectAttributes = new ArrayList<>();
		
		// The result will be returned through this list
		List<Object[]> result = new ArrayList<>();
		
		// Setting path to the excel file
		FileInputStream file = new FileInputStream(new File(
				"src/test/java/com/intellias/web/qa/test/settings/"
						+ fileName 
						+"_"
						+ Configuration.getConfiguration(null, null)
								.getAppLanguage() + ".xls"));
		
		// Get first sheet
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		// Initiate row collection
		Iterator<Row> rowIterator = sheet.iterator();
		
		// Get first row
		HSSFRow row = (HSSFRow) rowIterator.next();
		
		// Initiate cell collection
		Iterator<Cell> cellIterator = row.cellIterator();

		// Add first row into list
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			objectAttributes.add(cell.getStringCellValue());
		}
		System.out.println("Headers: " + objectAttributes);

		// Add next rows in HashMap
		while (rowIterator.hasNext()) {
			
			row = (HSSFRow) rowIterator.next();
			HashMap<String, Object> fileEntry = new HashMap<>();

			for (int i = 0; i < objectAttributes.size(); i++) {

				if (row.getCell(i) != null) {

					switch (row.getCell(i).getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						fileEntry.put(objectAttributes.get(i), getCellValueAsString(row.getCell(i)) != null ?
								 getCellValueAsString(row.getCell(i)) : "");
						break;
					case Cell.CELL_TYPE_STRING:
						fileEntry.put(objectAttributes.get(i), row.getCell(i)
								.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						fileEntry.put(objectAttributes.get(i), row.getCell(i)
								.getBooleanCellValue());
						break;

					default:
						fileEntry.put(objectAttributes.get(i), row.getCell(i)
								.getStringCellValue());
						break;
					}

				} else fileEntry.put(objectAttributes.get(i), null);

			}
			result.add(new Object[] { fileEntry });
			System.out.println("Fetched hash map : " + fileEntry);
		}
		return result.iterator();
	}
	
	private static String getCellValueAsString (HSSFCell cell) {
		return String.valueOf(((Double) cell.getNumericCellValue()).intValue());
	}

}
