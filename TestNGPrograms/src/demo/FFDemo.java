package demo;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FFDemo {
	
	@Test
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://facebook.com");
	}

}
