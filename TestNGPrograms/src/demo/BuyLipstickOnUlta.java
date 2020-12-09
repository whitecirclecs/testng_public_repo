package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyLipstickOnUlta {
	
	public static void main(String[] args) throws InterruptedException {		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ulta.com/");
		
		WebElement makeup = driver.findElement(By.linkText("Makeup"));
		Actions actions = new Actions(driver);
		actions.moveToElement(makeup).build().perform();
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Lipstick")));
		driver.findElement(By.linkText("Lipstick")).click();		
		
		
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//a[contains(@class,'toggle-arrow')]"), "aria-expanded", "true"));
		
		driver.findElement(By.xpath("(//h4[contains(@class,'prod-title')])[1]")).click();
				
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Select-value')]")));
		//	1) Click on the drop-down so that values become visible
		driver.findElement(By.xpath("//div[contains(@class,'Select-value')]")).click();
		
		// Wait for all the items to be visible
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[contains(@class,'Select-menu')])[2]/div")));
		
		//	2) Take all the values from the drop-down and put them in a list
		List<WebElement> colors = driver.findElements(By.xpath("(//div[contains(@class,'Select-menu')])[2]/div"));
		
		//	3) Iterate through the list and click on the desired item
		for(WebElement x : colors) {
			if (x.getText().equals("Lolita II (terra cotta nude)")) {
				x.click();
				break;
				//Dont buy Lipstick
			}
		}
		
		
		
	}

}
