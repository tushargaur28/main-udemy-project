import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Chrome
		ChromeOptions options = new ChromeOptions();

		// Accept SSL certificate
		options.setAcceptInsecureCerts(true);

		// Set Proxy using object of Proxy class
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("proxy string to get from IT department");
		options.setCapability("proxy", proxy);

		// Add extensions to the invoked browser
		options.addExtensions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);

//		// Firefox
//		FirefoxOptions options1 = new FirefoxOptions();
//		options1.setAcceptInsecureCerts(true);
//		
//		// Edge
//		EdgeOptions options2 = new EdgeOptions();
//		options2.setAcceptInsecureCerts(true);
//		
//		// Safari
//		SafariOptions options3 = new SafariOptions();
//		options3.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());
	}

}
