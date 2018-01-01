package common;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class ExcelMethods {

	
	//***********************************************************//
	//***                                  			         ***//
	//*** Created by Angela Tong Dec 2017                     ***//
	//*** This piece of code got help from Virtumedix project ***//
	//***********************************************************//
	
	
	final static Logger log = Logger.getLogger(ExcelMethods.class);
    private static final String FILE_NAME = "/Users/atong/Documents/EclipseProjects/FamilyLocator/src/testdata/TestData.xlsx";
    
	// Read and Provide value to Data Provider
    // Make sure the name of the test is on the tab of the excel sheet and make sure there are no leading and trailing spaces in the name or get nullpointer
    public static Object[][] getDataFromExcelTestData(String testName) throws Exception {
	String[][] arrayExcelData = null;
	FileInputStream fs = null;
	Workbook wb = null;
	try {
	    FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	    DataFormatter objDefaultFormat = new DataFormatter();
		wb = WorkbookFactory.create(excelFile);

		Sheet sh = wb.getSheet(testName);
		int totalNoOfCols = sh.getRow(0).getLastCellNum();
		int totalNoOfRows = sh.getLastRowNum() + 1; //including header
		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
		for (int i = 1; i < totalNoOfRows; i++) { 
			Row row = sh.getRow(i);
			for (int j = 0; j < totalNoOfCols; j++) {
				Cell cellValue = row.getCell(j);
				String cellValueStr = objDefaultFormat.formatCellValue(cellValue);
				arrayExcelData[i - 1][j] = cellValueStr;
			}
		}

		
		
		/***
		Sheet sh = wb.getSheet(testName);
		int totalNoOfCols = sh.getRow(0).getLastCellNum();
		int totalNoOfRows = sh.getLastRowNum() + 1; //including header
		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
		for (int i = 1; i < totalNoOfRows; i++) { 
			Row row = sh.getRow(i);
			for (int j = 0; j < totalNoOfCols; j++) {
				Cell cellValue = row.getCell(j);
				String cellValueStr = objDefaultFormat.formatCellValue(cellValue);
				arrayExcelData[i - 1][j] = cellValueStr;
			}
		}
		***/
	} catch (Exception exp) {
		throw exp;
	} finally{
		try {
			if (fs != null) {
				fs.close();
			}
			if(wb != null){
				wb.close();
			}
		} catch (IOException ioExp) {
			log.error("Exception closing...", ioExp);
			}
		}
		return arrayExcelData;
	}
    
 

	
}
