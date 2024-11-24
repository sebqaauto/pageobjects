package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* This DataHelper class is used to fetch data from Excel sheet 
 * Apache POI API library it is used to interact with Excel application 
 * Streams - channel for accessing file system to connect outside the program 
 * Checked(Compile Time) & Unchecked Exception(Runtime) int a =10, b=0 , c; c = a/b;
 * Excel Operation - first access the Workbook, then Sheet, then Row, and Cell
 * */
public class DataHelper {
	
	List<String> userData = new ArrayList<String>();
	
	String cellData;
	public List<String> fetchAllDataFromExcelSheet(String sheetName) throws IOException {
		
		String fileLocation ="/Users/sebastianselvarajaugustine/eclipse-workspace/demowebshop/IndianTeam.xlsx";
		// Channel is established & it is holding the location of the workbook
		FileInputStream fis = new FileInputStream(fileLocation);
		// Interact with the WorkBook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Interact with the Sheet - workbook object help you to create a new sheet or navigate to an existing sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//workbook.createSheet(sheetName);
		// Interact with Rows  - sheet object helps you to work on the rows - create a new row or navigate to an existing row 
		int lastRow = sheet.getLastRowNum();
		// sheet.getRow(lastRow)
		// sheet.createRow(lastRow)
		// Using the sheet object and the iterator() we are retrieving all the rows in excels sheet
		Iterator<Row> rows = sheet.iterator();
		// Loop-1 is used to iterate over the Rows
		int counter=1;
		// rows.hasNext() is going to check if the a row object - if a row is there or not
		while(rows.hasNext()) {
		// rows.next() is going to the particular row object
		Row row = rows.next();
		// Using the row object and the iterator() we are retrieving all the cells in excels sheet's corresponding Row
		Iterator<Cell> cells = row.iterator();
			Cell cell = row.getCell(0);
			String value = cell.getStringCellValue();
			//Loop-2 to iterate over the Cells
			while(cells.hasNext()) {
				// cells.next() is going to the particular cell object
				Cell cellValue = cells.next();
				cellData = cellValue.getStringCellValue();
				System.out.print(cellData+ " ");
				userData.add(cellData);
				counter++;
			}
			System.out.println(" ");
		}
		System.out.println(counter);
		return userData;
	}
	
	
	
public List<String> fetchDataFromExcelSheet(String sheetName, int rowNo) throws IOException {
		
		String fileLocation ="/Users/sebastianselvarajaugustine/eclipse-workspace/demowebshop/IndianTeam.xlsx";
		// Channel is established & it is holding the location of the workbook
		FileInputStream fis = new FileInputStream(fileLocation);
		// Interact with the WorkBook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Interact with the Sheet - workbook object help you to create a new sheet or navigate to an existing sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);
		// Interact with Rows  - sheet object helps you to work on the rows - create a new row or navigate to an existing row 
		int lastRow = sheet.getLastRowNum();
		// Logic to pick from only one specific Row
		XSSFRow row = sheet.getRow(rowNo);
			Iterator<Cell> cells =	row.cellIterator();
			//Loop to iterate over the Cells
			while(cells.hasNext()) {
				// cells.next() is going to the particular cell object
				Cell cellValue = cells.next();
				cellData = cellValue.getStringCellValue();
				System.out.print(cellData+ " ");
				userData.add(cellData);
			}
	
		return userData;
	}

public void writeToExcelSheet(String sheetName, String emailId) throws IOException {
	String fileLocation ="/Users/sebastianselvarajaugustine/eclipse-workspace/demowebshop/IndianTeam.xlsx";
	// Channel is established & it is holding the location of the workbook
	FileInputStream fis = new FileInputStream(fileLocation);
	// Interact with the WorkBook
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	// Interact with the Sheet - workbook object help you to create a new sheet or navigate to an existing sheet
	XSSFSheet sheet = workbook.getSheet(sheetName);
	//XSSFSheet sheet = workbook.createSheet(sheetName);
	// Interact with Rows  - sheet object helps you to work on the rows - create a new row or navigate to an existing row 
	int lastRow = sheet.getLastRowNum();
	// Logic to create a new Row after the last active row in the excel sheet
	XSSFRow row = sheet.createRow(lastRow+1);
	// Logic to create a new Cell and column index is specified
	XSSFCell cell = row.createCell(0);
	cell.setCellValue(emailId);
	// To write it back to the excel we need the help of FileOutputStream 
	FileOutputStream fileOut = new FileOutputStream(fileLocation);
	workbook.write(fileOut);

}
	

	

}
