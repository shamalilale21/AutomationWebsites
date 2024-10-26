package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class irctc {
	       
	    static WebDriver driver;
	    
	    @BeforeTest
	    public static void setup() {
	    	
			driver = new ChromeDriver();
			driver.get("https://www.irctc.co.in/nget/train-search");
			driver.manage().window().maximize();
	    	
	    }
	    
	    @Test
	    public static void ticketBooking() throws Exception {
	    	
	    	driver.findElement(By.xpath("//input[@class=\"ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted\"]")).sendKeys("mumbai");
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//li[@role=\"option\"][2]")).click();
	    	
	    	driver.findElement(By.xpath("//input[@class=\"ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted\"]")).sendKeys("delhi");
	    	Thread.sleep(2000);
	    	
	    	driver.findElement(By.xpath("//li[@role=\"option\"]")).click();
	    	
	    	driver.findElement(By.xpath("//span[@class=\"ng-tns-c58-10 ui-calendar\"]")).click();
	    	
	    	String month = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month ng-tns-c58-10 ng-star-inserted\"]")).getText();
	    	
	    	while (!month.equalsIgnoreCase("June")) {
	    		
	    		driver.findElement(By.xpath("//a[@class=\"ui-datepicker-next ui-corner-all ng-tns-c58-10 ng-star-inserted\"]")).click();
	    		month = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month ng-tns-c58-10 ng-star-inserted\"]")).getText(); 
	    	}
	    	
	    	driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[2]/table/tbody/tr[3]/td[4]")).click();
	    	
	    	driver.findElement(By.xpath("//button[@class=\"search_btn train_Search\"]")).click();
	    	
	    	
	    	
	    	
	    }
	
	

}
