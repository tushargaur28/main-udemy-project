package tushargaurautomation.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {
	
	ExtentReports extent = new ExtentReports();
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results Extent");
		
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Tushar Gaur");
	}
	
	
	// ExtentReports, ExtentSparkReporter
	
	
	@Test
	public void initialDemo() {
		ExtentTest test =extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Results do not match");	
		extent.flush();
		
		
	}
}
