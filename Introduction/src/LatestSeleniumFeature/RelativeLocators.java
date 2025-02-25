package LatestSeleniumFeature;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Relative locator 'above'
		WebElement inputNameBox = driver.findElement(By.xpath("//input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(inputNameBox)).getText());

		// Relative locator 'below'
		WebElement dob = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();

		// Relative locator 'toLeftOf'
		WebElement icecream = driver.findElement(By.xpath("//label[contains(text(),'IceCreams')]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecream)).click();
		
		// Relative locator 'toRightOf'
		WebElement radioBtn1 = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioBtn1)).getText());
	}

}
