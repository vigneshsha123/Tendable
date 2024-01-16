# Tendable
<h1># Cucumber-BDD-Automation-Framework</h1>
<h2>Behavior Driven Development Cucumber - Selenium based automation framework including JVM report</h2>
<h3>Project name Tendable

<h2>This framework contains sample code containing:</h2>
	<ul><li>1 feature (feature file)</li></ul>
	<ul><li>4 Scenarios</li>
	<li>Simple scenario Url Launch and verify the accessibilitylevel of menus home,our story,our solution, and why Tendable.</li>
	<li>Scenario 3 To check the demo button
 </li>User validates contact as button funtion and Validating the message field

 <h2>Steps to run at your system:</h2>
	<ul>
	<li>Clone the repository using "git clone <repository url>"</li>
	<li>Change "Username" and "Password" in both scenarios in feature file</li>
	<li>Run "mvn clean test"</li>
	<li>Run "mvn site"</li>
	</ul>
 
#Runner class
</h4>Using Anotation 
@runwith
@cucumber options
</h>Tags,Dryrun,monochrome,snipts,features,format

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"stepDefinition"}
		)

public class TestRunner {

}

#Hooks class
<h5>
  Executing all the funtions before and after execution
  Using Two anotations
  @before 
  @after

#Baseclass
Using main class only we can use all the Reusable method in java
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
#StepDefinition files
Here only I will Write all the Scripts

#Page object model
Maintaining the locator in pagewise
Using Four annotations

@Findby,@Findall,@Findbys and @catchlookup

#Pom.xml
Maintaining the Dependencies in pom .xml

<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>org.task</groupId>
	<artifactId>Tendable</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<dependencies>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.16.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>3.8</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.4</version>
		</dependency>
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>4.8.0</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>4.8.0</version>
</dependency>


	</dependencies>
</project>



</h5>

 
	  
<h2>Directory structure:</h2>
