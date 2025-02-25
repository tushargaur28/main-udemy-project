import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.findElement(By.id("autosuggest")).sendKeys("Be");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Bermuda")) {
				option.click();
				break;
			}

		}
		Thread.sleep(3000);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String enteredText = (String) js.executeScript("return document.getElementById('autosuggest').value;");
//		System.out.println(enteredText);

//		System.out.println(driver.findElement(By.id("autosuggest")).isDisplayed());
//		String enteredValue = driver.findElement(By.id("autosuggest")).getAttribute("value");
//		System.out.println(enteredValue);
		// driver.close();

	}

}
