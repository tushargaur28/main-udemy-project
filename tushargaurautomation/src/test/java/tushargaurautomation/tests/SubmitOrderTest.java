package tushargaurautomation.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tushargaurautomation.TestComponents.BaseTest;
import tushargaurautomation.pageobjects.CartPage;
import tushargaurautomation.pageobjects.CheckoutPage;
import tushargaurautomation.pageobjects.ConfirmationPage;
import tushargaurautomation.pageobjects.OrdersPage;
import tushargaurautomation.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName = "IPHONE 13 PRO";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("username"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage chckoutPage = cartPage.goToCheckout();
		chckoutPage.selectCountry("India");
		ConfirmationPage confrmPage = chckoutPage.submitOrder();
		String confrmMessage = confrmPage.getSuccessMsg();
		Assert.assertTrue(confrmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")); //THANKYOU FOR THE ORDER.

	}

	@Test()
	public void OrderHistoryTest() {
		// String productName = "IPHONE 13 PRO";
		ProductCatalogue productCatalogue = landingPage.loginApplication("gaur.tushar281@gmail.com", "Test1234");
		OrdersPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//tushargaurautomation//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}