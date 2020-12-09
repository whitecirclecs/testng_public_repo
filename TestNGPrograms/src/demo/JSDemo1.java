package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSDemo1 {
	
	WebDriver driver; // Declaration of a Global variable

	@BeforeTest
	public void launchApplication() {
		// 1) Open the browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(); // Initialization of driver.

		// Maximize the browser
		driver.manage().window().maximize();

		// 2) Navigate to the application
		driver.get("https://www.youtube.com/watch?v=V00lgSS7J_s");
	}
	
	@Test
	public void enterUsername() throws InterruptedException {
		
		Thread.sleep(3000);
		
		WebElement fullscreen = driver.findElement(By.xpath("//button[contains(@class,'fullscreen')]"));
		WebElement theatreMode = driver.findElement(By.xpath("//button[contains(@aria-label,'Theater')]"));
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", theatreMode);
		
		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", fullscreen);
		
		
		js.executeScript("document.getElementsByTagName('video')[0].pause()");
		
		
		
		
		
	
		
	}

}
