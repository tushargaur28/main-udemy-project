package tushargaurautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tushargaurautomation.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'col-lg-4')]")
	List<WebElement> products;
	
//	@FindBy(css="toast-container")
//	WebElement toastMessage;
	
	@FindBy(css=".ng-testing")
	WebElement spinner;
	
	
	
	By productsBy = By.xpath("//div[contains(@class,'col-lg-4')]");
	By addToCart = By.xpath(".//button[@class='btn w-10 rounded']");
	By toastMessage = By.cssSelector(".toast-container");
//	By spinner = By.cssSelector(".ng-testing");
	
	public List<WebElement> getProductList() {
		waitForWebElementsToAppear(products);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

}
