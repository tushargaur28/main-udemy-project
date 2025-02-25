import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelfIntroduction {

	public static void main(String[] args) {

		// Invoking Browser
		// Selenium Manager automatically detects the browser installed on your system
		// and downloads the corresponding WebDriver
		// Chrome Browser

		System.setProperty("wedriver.chrome.driver", "/Users/tushargaur/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();

//		System.setProperty("wedriver.gecko.driver", "/Users/tushargaur/Documents/geckodriver");
//		WebDriver driver = new FirefoxDriver();

//		System.setProperty("webdriver.edge.driver", "/Users/tushargaur/Documents/msedgedriver");
//		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		// get page source
		System.out.println(driver.getPageSource());
		driver.quit();

	}

}
