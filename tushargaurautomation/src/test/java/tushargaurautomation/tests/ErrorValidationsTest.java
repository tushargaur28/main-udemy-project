package tushargaurautomation.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import tushargaurautomation.TestComponents.BaseTest;
import tushargaurautomation.TestComponents.Retry;
import tushargaurautomation.pageobjects.CartPage;
import tushargaurautomation.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{
	@Test(groups = {"ErrorHandling"},retryAnalyzer=Retry.class)							
	public void LoginErrorValidation () {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("gaur.tushar281@gmail.com", "Test124"); 
		landingPage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test(groups = {"ErrorHandling"})

	public void ProductErrorValidation () throws IOException, InterruptedException {
			String productName = "IPHONE 13 PRO";
			ProductCatalogue productCatalogue = landingPage.loginApplication("gaur.tushar281@gmail.com", "Test1234");
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();
			
			Boolean match = cartPage.VerifyProductDisplay("IPHONE 14 PRO");
			Assert.assertFalse(match);
			
			
		}
}
