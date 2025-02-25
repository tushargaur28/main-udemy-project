import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[contains(text(),'InterviewQues')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		String message = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].split(" ")[1];
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(message);
		
		
	}
}






















//WebDriver driver = new ChromeDriver();
//driver.get("https://rahulshettyacademy.com/loginpagePractise/");
//driver.findElement(By.xpath("//a[contains(text(),'Free Access')]")).click();
//
//Set<String> windows = driver.getWindowHandles();
//Iterator<String> it = windows.iterator();
//String parentWindowId = it.next();
//String childWindowId = it.next();
//driver.switchTo().window(childWindowId);
//
//String email = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].split(" ")[1];
//
//driver.switchTo().window(parentWindowId);
//driver.findElement(By.id("username")).sendKeys(email);