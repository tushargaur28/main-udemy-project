package tushargaurautomation.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tushargaurautomation.TestComponents.BaseTest;
import tushargaurautomation.pageobjects.CartPage;
import tushargaurautomation.pageobjects.CheckoutPage;
import tushargaurautomation.pageobjects.ConfirmationPage;
import tushargaurautomation.pageobjects.LandingPage;
import tushargaurautomation.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	ConfirmationPage confrmPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}
	
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username,String password) {
		productCatalogue = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_produc_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	 @When("^Checkout (.+) and submit the order$")
	 public void checkout_submit_order(String productName) {
		 CartPage cartPage = productCatalogue.goToCartPage();

			Boolean match = cartPage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			
			
			CheckoutPage chckoutPage = cartPage.goToCheckout();
			chckoutPage.selectCountry("India");
			confrmPage = chckoutPage.submitOrder();
	 }
	 
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string) throws InterruptedException {
		String confrmMessage = confrmPage.getSuccessMsg();
		Assert.assertTrue(confrmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	 @Then("{string} message is displayed")
	    public void something_message_is_displayed(String string) throws Throwable {
	   
	    	Assert.assertEquals(string, landingPage.getErrorMessage());
	    	driver.close();
	    }

}
		