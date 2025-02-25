import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7HandlingTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement table = driver.findElement(By.id("product"));
		
		
		// Print number of rows
		System.out.println("Number of rows : " + table.findElements(By.tagName("tr")).size());
		
		// Print number of columns
		WebElement firstRow = table.findElement(By.tagName("tr"));
		System.out.println("Number of columns : " + firstRow.findElements(By.tagName("th")).size());
		
		// Print second row values
		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondRow.get(0).getText());
		System.out.println(secondRow.get(1).getText());
		System.out.println(secondRow.get(2).getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
	}
}
		
//		// Print number of rows
//		WebElement table = driver.findElement(By.id("product"));
//		System.out.println(table.findElements(By.tagName("tr")).size());
//		
//		// Print number of columns
//		WebElement firstRow = table.findElement(By.tagName("th"));
//		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
//		
//		// Print second row values
//		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
//		System.out.println(secondRow.get(0).getText());
//		System.out.println(secondRow.get(1).getText());
//		System.out.println(secondRow.get(2).getText());
