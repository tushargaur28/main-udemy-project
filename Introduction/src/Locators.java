import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("tushar");
		driver.findElement(By.name("inputPassword")).sendKeys("abc");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// Forgot password
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h2[contains(text(),'Forgot password')]")).getText();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Tushar");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("tushkister@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7022612591");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

		// Extract password from the message
		String errorMessage = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String[] splittedErrorMessage = errorMessage.split("'");
		String newPassword = splittedErrorMessage[1];
		System.out.println(newPassword);

		// Go back to Login Page
		driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")).click();

		// Login with correct password
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys("tushar");
		driver.findElement(By.name("inputPassword")).sendKeys(newPassword);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		// driver.close();

	}

}
