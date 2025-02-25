import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. Click on a check box
		WebElement chkbox = driver.findElement(By.id("checkBoxOption2"));
		chkbox.click();
		Assert.assertTrue(chkbox.isSelected());

		// 2. Grab the label of that check box
		String label = chkbox.getDomAttribute("value");
		System.out.println("label of selected checkbox is: " + label);

		// 3. Select the same label from the drop down without hard coding
		WebElement dropdownButton = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select (dropdownButton);
		dropdown.selectByValue(label);

		// 4. Enter the label from step 2 into Alert input box
		driver.findElement(By.id("name")).sendKeys(label);

		// 5. Click Alert and verify if text grabbed from step 2 is present in the pop up
		driver.findElement(By.id("alertbtn")).click();
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
		Assert.assertTrue(alertMessage.contains(label));
		
	}

}
