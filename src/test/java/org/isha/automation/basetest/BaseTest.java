package org.isha.automation.basetest;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Resources.BaseExtentReport;
import Resources.ExtentReportManager;

public class BaseTest {

	 protected Playwright playwright;
	    protected Browser browser;
	    // changes in below line 32
	    protected BrowserContext context;
	    protected Page page;
	    private static ThreadLocal<Page> threadPage = new ThreadLocal<>();
	   
 

	    @BeforeMethod
	    public void setUp(ITestContext testContext) {
	        playwright = Playwright.create();
	        String browserName = System.getProperty("browser") != null 
	        	    ? System.getProperty("browser") 
	        	    : "chrome";
	        browser = browserName.equalsIgnoreCase("chrome") ? playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
	                : browserName.equalsIgnoreCase("firefox") ? playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false))
	                : browserName.equalsIgnoreCase("safari") ? playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false))
	                : playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // fallback default
	       context = browser.newContext(new Browser.NewContextOptions()
	               .setViewportSize(1366,607));
	        //change be below line 32 commented aboveline- now comen line33
	       // BrowserContext context = browser.newContext();
	        page = context.newPage();
	        threadPage.set(page);
	        testContext.setAttribute("page", page);
	    }
	   @AfterMethod (alwaysRun = true)
	   public void tearDown(ITestResult result) {
		   if (result.getStatus() == ITestResult.SUCCESS) {
	       context.close();
	        browser.close();
	       playwright.close();
		   }
	   }
	    public String takeScreenshot(Page page,String testName) {

	            String path = System.getProperty("user.dir") +"screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
	            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
	            
	            return path;
	   
	    } 
/*
	    @BeforeSuite(alwaysRun = true)
	    public void setupExtent() {
	        BaseExtentReport.initReports();
	    }

	    @AfterSuite(alwaysRun = true)
	    public void tearDownExtent() {
	        BaseExtentReport.flushReports();
	    }
	    */
	    public Page getPage() {
	        return threadPage.get();
	    }
	    
}

	   
