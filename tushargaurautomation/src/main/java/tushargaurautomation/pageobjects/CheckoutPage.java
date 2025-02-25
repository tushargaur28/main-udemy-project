package tushargaurautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tushargaurautomation.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'list-group')])[2]")
	WebElement selectCountry;

	@FindBy(xpath = "//a[contains(@class,'action__submit')]")
	WebElement submit;

	@FindBy(css=".ta-results")
	WebElement results;


	public void selectCountry(String countryName) {
		country.sendKeys(countryName);
		waitForWebElementToAppear(results);
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
		
		

	}
}