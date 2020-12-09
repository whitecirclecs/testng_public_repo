package demo;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class EdgeDemo {
	
	@Test
	public void openBrowser() {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://facebook.com");
	}

}
