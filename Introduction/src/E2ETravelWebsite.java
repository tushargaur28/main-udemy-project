import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2ETravelWebsite {

	public static void main(String[] args) throws InterruptedException {
		// Initialize browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Choose one way radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		// Choose From and To city from dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),' Delhi (DEL)')]")).click();
		driver.findElement(
				By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Jaipur (JAI)']"))
				.click();

		// Choose Departure Date
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();

		Thread.sleep(3000);
		// Check Return Date is disabled
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			System.out.println("Element is Disabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("Element is enabled");
			Assert.assertFalse(false);
		}

		// Choose number of passengers
		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();

		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		// Choose Currency
		Select currencyDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currencyDropdown.selectByVisibleText("USD");

		// Select friends & family checkbox
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();

		// click on Search
		driver.findElement(By.xpath("//input[contains(@id,'FindFlights')]")).click();

		driver.close();

	}

}
