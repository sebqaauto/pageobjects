package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* This DataHelper class is used to fetch data from Excel sheet 
 * Apache POI API library it is used to interact with Excel application 
 * Streams - channel for accessing 
 * Checked(Compile Time) & Unchecked Exception(Runtime) int a =10, b=0 , c; c = a/b;
 * Excel Operation - first access the Workbook, then Sheet, then Row, and Cell
 * */
public class DataHelper {
	
	List<String> users = new ArrayList<String>();
	
	String cellData;
	public void fetchDataFromExcelSheet(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("/Users/sebastianselvarajaugustine/eclipse-workspace/demowebshop/IndianTeam.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		Iterator<Row> rows = sheet.iterator();
		//Loop to iterate over the Rows - 1
		int counter =1;
		while(rows.hasNext()) {
		Row row = rows.next();
		Iterator<Cell> cells =row.iterator();
			//Loop to iterate over the Cells - 2
			while(cells.hasNext()) {
				Cell cellValue = cells.next();
				cellData =cellValue.getStringCellValue();
				System.out.print(cellData+ " ");
				counter++;
			}
			System.out.println(" ");
		}
		
		System.out.println(counter);
		
	}

	

}
