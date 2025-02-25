import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2Form {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).sendKeys("Tushar Gaur");
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input"))
				.sendKeys("tushkister@gmail.com");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("Tushar@123");
		driver.findElement(By.id("exampleCheck1")).click();

		driver.findElement(By.id("exampleFormControlSelect1")).click();
		Select genderDropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		genderDropdown.selectByVisibleText("Male");

		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//label[text()='Date of Birth']/following-sibling::input")).sendKeys("28111990");
		driver.findElement(By.xpath("//div[@class='form-group']/following-sibling::input")).click();

		String successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText().trim();
		System.out.println(successMessage);
		Assert.assertEquals(successMessage, "×\n" + "Success! The Form has been submitted successfully!.");
	}

}
