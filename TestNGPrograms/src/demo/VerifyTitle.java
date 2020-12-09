package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	ChromeDriver driver; // Declaration of a Global variable

	@BeforeTest
	public void launchApplication() {
		// 1) Open the browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(); // Initialization of driver.

		// Maximize the browser
		driver.manage().window().maximize();

		// 2) Navigate to the application
		driver.get("https://whitecircleschool.com/");
	}

	@Test
	public void titleVerification() {
		String expectedTitle = "White Circle Code School";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
