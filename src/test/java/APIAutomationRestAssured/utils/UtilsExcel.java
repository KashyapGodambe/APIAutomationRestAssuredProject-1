package APIAutomationRestAssured.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class UtilsExcel {
	
//	Open that FileInputStream
//	Understand the workbook
//	Sheet
//	Row
//	Columns
//	Cell
//	Close the stream
	
	
//	It will be used by who ? > DataProvider of the TestNG
//	Object[][]
	
	
	public static String FILE_NAME = "src/test/resources/TD.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	
	
	public static Object[][] getTestData(String sheetName)
	{	
		FileInputStream file = null;
		
		try
		{
			file = new FileInputStream(FILE_NAME);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i < sheet.getLastRowNum(); i++)
		{
			for(int j=0; j < sheet.getRow(0).getLastCellNum(); j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		
		
		return data;
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		
//		In future we can write logic to select which sheet we want to open
//		Ask user which sheet to open
//		Data.Properties -> sheet1 or sheet2
//		sheet1 -> QA
//		sheet2 -> prod
		
		
		return getTestData("Sheet1");
		
		
		
	}

}
