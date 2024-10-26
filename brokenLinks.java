package Automation;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class brokenLinks {
	
static WebDriver driver;
	
	@BeforeTest
    public static void setup() {
    	
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
    	
    }
	
	@Test
	public static void elements() throws Exception {
		
		driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 300);");
		driver.findElement(By.xpath("//li[@id=\"item-6\"]")).click();
		
		WebElement link = driver.findElement(By.linkText("Click Here for Valid Link"));
		
		String url = link.getAttribute("href");
		
		URL linkurl = new URL(url);
		
		HttpURLConnection connection = (HttpURLConnection)linkurl.openConnection();
		
		int code= connection.getResponseCode();
		
		if(code!=200) {
			System.out.println("link is broken");
		} else {
			System.out.println("link is ok");
		}
		
		connection.disconnect();

}
}
