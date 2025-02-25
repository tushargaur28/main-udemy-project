package JavaStreamsPractice;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamsGreenKartDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		// Click on column to sort it
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		
		
		// Capture list of vegetable WebElements
		List<WebElement> vegetables = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]//tr/td[1]"));
		
		
		// Capture text of WebElements into new list
		List<String> vegetableNames = vegetables.stream().map(s->s.getText()).toList();
		//System.out.println(vegetableNames);
		
		
		// Sort the list of text captured in previous step	
		@SuppressWarnings("unused")
		List<String> sortedNames = vegetableNames.stream().sorted().toList();
		
		List<String> price;
		do {
		// Get price of Beans
			List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]//tr/td[1]"));
		price = rows.stream().filter(s->s.getText().contains("Orange")).map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
	
}
