import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3CheckoutCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[text()=' User']/following-sibling::span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']"))).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		dropdown.click();
		Select option = new Select(dropdown);
		option.selectByVisibleText("Consultant");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		addToCart(driver);

		// Validate by asserting checkout button
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-default']")).isDisplayed());

	}

	public static void addToCart(WebDriver driver) {
		// add elements to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card h-100']")));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card h-100']"));

		for (int i = 0; i < products.size(); i++) {

			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();

		}

		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

}
