import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/a/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/a/following-sibling::button[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/a/following-sibling::button[3]")).getText());
		driver.close();
	}

}

