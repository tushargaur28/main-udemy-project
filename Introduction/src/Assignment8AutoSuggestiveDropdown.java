import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		
		searchBox.sendKeys("uni");
		Thread.sleep(Duration.ofSeconds(5));
		searchBox.sendKeys(Keys.DOWN);
		searchBox.sendKeys(Keys.DOWN);
		searchBox.sendKeys(Keys.DOWN);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println(js.executeScript("return arguments[0].value", searchBox));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//driver.findElement(By.id("autocomplete")).sendKeys("ind");
//
//driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//
//
//JavascriptExecutor js = (JavascriptExecutor) driver;
//System.out.println(js.executeScript("return arguments[0].value",driver.findElement(By.id("autocomplete"))));
