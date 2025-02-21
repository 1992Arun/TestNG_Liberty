package org.uitlity;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listene implements ITestListener {
	
	public static ExtentReports extendsreport;
	
	public static ExtentTest createTest ;

	@Override
	public void onTestStart(ITestResult result) {
		
		createTest = extendsreport.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		createTest.log(Status.PASS, result.getName()+" Test Has Started");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		createTest.log(Status.FAIL, result.getName()+" Test Has Failed");
		
		
		try {
			
			
			createTest.addScreenCaptureFromPath(BaseClas.takeScreenShots(result.getName()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		createTest.log(Status.SKIP, result.getName()+" Test Has Failed");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		extendsreport = ExtendReport.extendsreport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extendsreport.flush();
	}

}
