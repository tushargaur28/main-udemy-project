package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="tushargaurautomation.stepDefinitions",
monochrome=true,tags="@Regression",plugin= {"html:target/cucumber.html"})												// insert tags here
		
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
}