package tushargaurautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tushargaurautomation.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{

	WebDriver driver;
	
	@FindBy(xpath="//table[contains(@class,'table-hover')] //tr/td[2]")
	private List<WebElement> productNames;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	
	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(name -> name.getText().equalsIgnoreCase(productName));
		return match;

	}
}
