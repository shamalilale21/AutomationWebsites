package Automation;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class goIbibo {
       
	static WebDriver driver;
	
	@BeforeTest
	public static void setup() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/header/ul/li[1]/a/span[2]")).click();
		
	}
	
	@Test
	public static void ticketBooking() throws Exception {
		WebElement from = driver.findElement(By.xpath("//div[@class=\"sc-12foipm-16 wRKJm fswFld \"] "));
		from.click();
		
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Mumbai");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[@tabindex=\"0\"]")).click();
		
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Delhi");
        Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[@tabindex=\"0\"]")).click();
		
		Thread.sleep(2000);
		
		
		String month = driver.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]")).getText();
		System.out.println(month);
		
		while(!month.equalsIgnoreCase("August 2024")) {
			
			driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
		    month = driver.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]")).getText();
		}
		
		driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--prev\"]")).click();
		Thread.sleep(2000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"DayPicker-Month\"][1]/div[3]/div/div/p"));
		
		for (WebElement dates : elements) {
			
			String date = dates.getText();
			
			
			if (date.equalsIgnoreCase("15")) {
				
				dates.click();
			}
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class=\"fswTrvl__done\"]")).click();
		
		driver.findElement(By.xpath("//a[@class=\"sc-12foipm-77 jYnAuG\"]")).click();
		driver.findElement(By.xpath("//span[@class=\"sc-12foipm-85 fUaVPB\"]")).click();
		
		
	}

}
