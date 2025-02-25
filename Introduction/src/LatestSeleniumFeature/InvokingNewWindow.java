package LatestSeleniumFeature;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingNewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");

		String firstCourse = driver
				.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1)
				.getText();
		System.out.println(firstCourse);
		driver.switchTo().window(parentWindow);

		WebElement inputNameBox = driver.findElement(By.xpath("//input[@name='name']"));
		inputNameBox.sendKeys(firstCourse);
		
		// Screenshot
		File file = inputNameBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File ("screenshot.png"));
		
		// Width and height of WebElement
		System.out.println(inputNameBox.getRect().getDimension().getHeight());
		System.out.println(inputNameBox.getRect().getDimension().getWidth());
		

	}

}
