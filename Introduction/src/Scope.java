import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// 1. Get count of links present on the page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2. Limiting WebDriver Scope - Get count of links only in footer section
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// 3. Get count of links only in left column of bottom footer
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		// 4. Click on each link and check if it is working

		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000);

		}
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
