import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Tushar";
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
		// driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		System.out.println(
				driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText());
		Assert.assertEquals(
				driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText(),
				"You are successfully logged in.");
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String errorMessage = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String[] splittedErrorMessage = errorMessage.split("'");
		String newPassword = splittedErrorMessage[1];
		System.out.println(newPassword);
		return newPassword;
	}

}
