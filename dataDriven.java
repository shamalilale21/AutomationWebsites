package Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dataDriven {

	static WebDriver driver;
	
	@Test
	public static void readDataFromFile() throws Exception {
	FileInputStream fi = new FileInputStream("C:\\Users\\sle48\\Desktop\\test data\\test data.xlsx");
	
	XSSFWorkbook wb = new XSSFWorkbook(fi);
	XSSFSheet s = wb.getSheet("Sheet1");
	
	int rowCount = s.getLastRowNum()+1;
	int columnCount = s.getRow(0).getLastCellNum();
	
	System.out.println(rowCount);
	System.out.println(columnCount);
	
	for(int i=0; i<columnCount; i++) {
		
		String columnHead = s.getRow(0).getCell(i).getStringCellValue();
		
		if (columnHead.equalsIgnoreCase("Username")) {
		
			for(int j=1; j<rowCount; j++) {
				
				String username = s.getRow(j).getCell(i).getStringCellValue();
				System.out.println(username);
			}
			
		} else if (columnHead.equalsIgnoreCase("Password")){
			for(int j=1;j<rowCount; j++) {
				String pass = s.getRow(j).getCell(i).getStringCellValue();
				System.out.println(pass);
			}
			
			
		}
		
		
		
	}
	
	driver.findElement(By.name("email")).sendKeys(s.getRow(1).getCell(0).getStringCellValue());
	driver.findElement(By.name("pass")).sendKeys(s.getRow(1).getCell(1).getStringCellValue());
	driver.findElement(By.name("login")).click();
	
	}
	
	
	@BeforeTest
    public static void login() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	
        }
	
	
	
	
}
