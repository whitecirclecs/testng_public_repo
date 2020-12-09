package demo;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class IEDemo {
	
	@Test
	public void openBrowser() {
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("https://facebook.com");
		
	}

}
