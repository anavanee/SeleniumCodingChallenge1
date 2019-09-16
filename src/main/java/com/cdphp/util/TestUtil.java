package com.cdphp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cdphp.base.TestBase;

public class TestUtil extends TestBase {
	
	public static Workbook book;
	public static Sheet sheet;
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void switchFrame( String Name)
	{
		driver.switchTo().frame(Name);
	}

	public Object[][] getTestData(String FileName, String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream ip=new FileInputStream(new File(FileName));
		
		book=WorkbookFactory.create(ip);
		
		sheet=book.getSheet(SheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0;i<sheet.getLastRowNum();i++)
		{
			for (int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
			
		
		
	
	public  static void takeScreenShot() throws IOException
	{
		File ts=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ts,new File("C:\\users\\pavit\\test.png"));
		
	}
}
