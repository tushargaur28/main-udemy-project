import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		//System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_middle']")));
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.switchTo().defaultContent();
		
	}

}
