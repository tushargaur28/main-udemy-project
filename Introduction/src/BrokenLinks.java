import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Initiate soft assertion
		
		
		List<WebElement> links = driver.findElements(By.xpath("//li/a"));
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links) {
			String urlvalue = link.getDomAttribute("href");
			
			
			URI uri = URI.create(urlvalue);
			URL url = uri.toURL();
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with text : " + link.getText() + " is broken with code " + respCode);
			
//			if(respCode>400) {
//				System.out.println("The link with text : " + link.getText() + " is broken with code " + respCode);
//				Assert.assertTrue(false);
			}
		
			a.assertAll();
			
		}
	
	}


