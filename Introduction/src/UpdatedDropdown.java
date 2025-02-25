import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();

		// Select Check box for Indian Army

		// System.out.println(driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).isSelected());

		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).isSelected());

		// System.out.println(driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).isSelected());

		// Find number of Check boxes on the page
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkboxes.size());

		// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date1")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("Element is enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("Element is disabled");
			Assert.assertFalse(false);
		}

		// validation before selecting passengers
		// System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// using while loop
//		int i=1;
//		while (i<5){
//			driver.findElement(By.id("hrefIncAdt")).click();	//selecting 5 adult passengers
//			i++;
//		}
//		
//		//using for loop
////		for(int i=1;i<5;i++) {
////			driver.findElement(By.id("hrefIncAdt")).click();
////		}
//		
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		
//		//validation after selecting passengers
//		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

	}

}
