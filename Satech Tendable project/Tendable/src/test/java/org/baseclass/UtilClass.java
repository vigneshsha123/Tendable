package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UtilClass {
	public static WebDriver driver;
	public static Workbook book;
	public static FileInputStream fi;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;

	public static void launchChromeBrowser() {
		driver = new ChromeDriver();

	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();

	}
	
	public static void applyWaitToAllElements() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public static String textFromElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	
	public static boolean CheckElementPresent(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	
	public static void elementToClick(WebElement element) {
		element.click();

	}
	
	public static void passValueToElement(WebElement element,String value) {
				element.sendKeys(value);
	}
	
	public static void selectValueFromDropdown(WebElement element,int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	
	public static String readData(String sheetName,int rowNo,int cellNo) {
		File f= new File("C:\\Users\\Asfiya\\eclipse-workspace\\Ass\\Tendable\\src\\test\\resources\\sheet\\data.xlsx");
	
			try {
				fi= new FileInputStream(f);
			} catch (FileNotFoundException e) {	
			}
		
			try {
				 book= new  XSSFWorkbook(fi);
			} catch (IOException e) {	
			}
		 
			Sheet sheet = book.getSheet(sheetName);
			Row row = sheet.getRow(rowNo);
			Cell cell = row.getCell(cellNo);
			int cellType = cell.getCellType();
			
			String value=null;
			
			if (cellType==1) {
				 value = cell.getStringCellValue();
			}else if (DateUtil.isCellDateFormatted(cell)) {
				
				Date d = cell.getDateCellValue();
				
				SimpleDateFormat s= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				 value = s.format(d);
			}
			else {
				double d = cell.getNumericCellValue();
					long l=(long)d;
					 value = String.valueOf(l);
	}
	return value;}


}
