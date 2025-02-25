package tushargaurautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tushargaurautomation.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@class='cartSection']/h3")
	private List<WebElement> cartItems;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement chckoutBtn;

	public Boolean VerifyProductDisplay(String productName) {

		Boolean match = cartItems.stream()
				.anyMatch(product -> product.getText().trim().equalsIgnoreCase(productName.trim()));
		return match;

	}

	public CheckoutPage goToCheckout() {
		waitForWebElementToAppear(chckoutBtn);
		chckoutBtn.click();
		return new CheckoutPage(driver);

	}
}
