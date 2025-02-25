import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String monthNumber = "6";
		String date = "15";
		String year = "2027";
		String[] expectedList = {monthNumber,date,year};

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[contains(@class,'react-date-picker')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'label__labelText')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'label__labelText')]")).click();
		// Select year 2027
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		// Select month June
		driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile')]")).get(Integer.parseInt(monthNumber)-1).click();
		// Select Date 15
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		
		List<WebElement> actualList = driver.findElements(By.xpath("//input[contains(@class,'react-date-picker__inputGroup__input')]"));
		for (int i=0; i<actualList.size();i++) {
			System.out.println(actualList.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
		}
		driver.close();
	}

}
