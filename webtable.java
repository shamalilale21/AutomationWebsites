package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webtable {
	
	static WebDriver driver;
	
	@BeforeTest
    public static void setup() {
    	
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
    	
    }
	
	@Test
	public static void webtable() {
		
		driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"]")).click();
		driver.findElement(By.xpath("//li[@id=\"item-3\"]")).click();
		
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"rt-td\"]"));
		for(WebElement element : elements) {
			String value = element.getText();
			
			if(!value.equalsIgnoreCase(null)) {
				System.out.print(value + " ");
			}
			
		}
		
		driver.findElement(By.id("addNewRecordButton")).click();
		
		
		driver.findElement(By.id("firstName")).sendKeys("shamali");
		driver.findElement(By.id("lastName")).sendKeys("Lale");
		driver.findElement(By.id("userEmail")).sendKeys("shamali@gmail.com");
		driver.findElement(By.id("age")).sendKeys("27");
		driver.findElement(By.id("salary")).sendKeys("25000");
		driver.findElement(By.id("department")).sendKeys("mechanical");
		
		driver.findElement(By.id("submit")).click();
		
		List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class=\"rt-td\"]"));
		for(WebElement element : elements1) {
			String value1 = element.getText();
			
			if(!value1.equalsIgnoreCase(null)) {
				System.out.print(value1 + " ");
			}
			
		}
		
	}

}
