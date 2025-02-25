package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersPractice implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Success");
	}
	
}
