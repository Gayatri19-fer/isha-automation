package org.isha.automation.basetest;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;

import Resources.ExtentReportManager;

public class Listener extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports Extends = ExtentReportManager.getExtentReports();
	ThreadLocal<ExtentTest> testblock = new ThreadLocal<>();
	EmailUtils eu = new EmailUtils();
	 @Override
	    public void onTestStart(ITestResult result) {
		 test = Extends.createTest(result.getMethod().getMethodName());
	        System.out.println("Test Started: " + result.getMethod().getMethodName());
	        testblock.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println(" Test Passed: " + result.getMethod().getMethodName());
	        testblock.get().log(Status.PASS, "Test Pass");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test Failed :" + result.getMethod().getMethodName());
	        BaseTest baseTest = (BaseTest) result.getInstance();
	        Page page = baseTest.getPage();
	        if (page != null) {
	            String screenshotPath = baseTest.takeScreenshot(page, result.getMethod().getMethodName());
	            System.out.println("Screenshot saved at: " + screenshotPath);
	            // Convert screenshot to Base64 and attach
	            try {
	                testblock.get().fail("Test Failed: " + result.getThrowable())
	                            .addScreenCaptureFromBase64String(
	                                java.util.Base64.getEncoder().encodeToString(
	                                    java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(screenshotPath))
	                                ),
	                                result.getMethod().getMethodName()
	                            );
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("Page is null. Screenshot not taken for " + result.getMethod().getMethodName());
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println(">>> Test Skipped: " + result.getName());
	    }
	    
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Optional to implement
	    }
 
	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        // Optional to implement
	    }
 
	    @Override
	    public void onStart(ITestContext context) {
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println(">>> All tests finished in suite: " + context.getName());
	        Extends.flush();
	        // Send Extent Report via email
	    //  String[] recipients = {"bodakegayatri@gmail.com","harshalip@fermion.in"}; // naveen.raj@sadhguru.org add your emails
	     //  eu.sendReportToRecipients(recipients);
	    }
	

}