import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {
	public static void main(String[] args) {

		// Initialize browser
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Array of items to be added to cart
		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beetroot", "Mushroom" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(driver, itemsNeeded);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		// Initialize a variable 'j' for dynamic break looping
		int j = 0;

		// Fetch the list of products on the web page
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product']"));

		// Iterate through the list of items
		for (int i = 0; i < productList.size(); i++) {
			String[] product = productList.get(i).getText().split("-");
			String formattedText = product[0].trim();
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedText)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
