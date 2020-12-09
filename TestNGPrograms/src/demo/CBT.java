package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBT {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void launchApplication(String browser) {
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		else if(browser.equals("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}	
		
		//	2) Maximize it
		driver.manage().window().maximize();
		
		//	3) Navigate to the application
		driver.get("https://en-gb.facebook.com/");

	}
	
	//	4) Verify the title is - 'Facebook - log in or sign up'
	@Test(priority=0)
	public void titleVerification() {
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	//	5) Verify text - Facebook helps you connect and share with the people in your life. - is there on the page.
	@Test(priority=1)
	public void verifyText() {
		String expectedText = "Facebook helps you connect and share with the people in your life.";
		String actualText = driver.findElement(By.cssSelector("#content > div > div > div > div > div.lfloat._ohe > div > div")).getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	//	6) Verify 'Male' radio button is not selected by default.
	@Test(priority=2)
	public void verifyMaleRadioBtn() {
		boolean radioBtn = driver.findElement(By.xpath("(//input[contains(@type,'radio')])[2]")).isSelected();
		Assert.assertFalse(radioBtn);
	}	
		
	//	7) Verify 'Sign Up' button is enabled  by default.
	@Test(priority=3)
	public void verifySignUpBtn() {
		boolean signUpBtn = driver.findElement(By.name("websubmit")).isEnabled();
		Assert.assertTrue(signUpBtn);
	}
	
	
	//	8) Close the browser
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
