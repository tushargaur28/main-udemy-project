package testFrameworkBasics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class PS {
	
	@BeforeMethod
	public void Hello() {
		System.out.println("Hello");
	}
	@Test
	public void doThis() {
		System.out.println("Test from PS");
	}
	
	@AfterMethod
	public void Bye() {
		System.out.println("Bye");
	}
}
