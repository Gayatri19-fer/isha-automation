package org.isha.automation.basetest;

import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Arrays;

import org.isha.automation.utils.ConfigReader;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class BaseTest {

	 protected Playwright playwright;
	    protected Browser browser;
	    // changes in below line 32
	    protected BrowserContext context;
	    protected Page page;
	    private static ThreadLocal<Page> threadPage = new ThreadLocal<>();
	   
 

	    @BeforeMethod
	    public void setUp(ITestContext testContext ,Method method) {
	        playwright = Playwright.create();
	        String browserName = System.getProperty("browser") != null 
	        	    ? System.getProperty("browser") 
	        	    : "chrome";
	        browser = browserName.equalsIgnoreCase("chrome") ? playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
	                : browserName.equalsIgnoreCase("firefox") ? playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false))
	                : browserName.equalsIgnoreCase("safari") ? playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false))
	                : playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // fallback default
	      
	        boolean needAuth = Arrays.asList(method.getAnnotation(Test.class).groups()) .contains("auth"); 
	        boolean authEnabled = Boolean.parseBoolean( ConfigReader.get("auth.enabled") ); 
	        Browser.NewContextOptions options = new Browser.NewContextOptions() .setViewportSize(1366, 607); 
	        if (needAuth && authEnabled)
	        {
	        	options.setHttpCredentials(
	        			ConfigReader.get("auth.user"),
	        		    ConfigReader.get("auth.pass")); 
	        }
	        
	        	context = browser.newContext(options); 
	        	startTracing(context); 
	        
	         // BrowserContext context = browser.newContext(); 
	         page = context.newPage(); 
	         threadPage.set(page); 
	         testContext.setAttribute("page", page);
	    }
	    
	    private void startTracing(BrowserContext ctx) { context.tracing().start(new Tracing.StartOptions()
	    		.setScreenshots(true).setSnapshots(true).setSources(true)); }
	    
	   @AfterMethod (alwaysRun = true)
	   public void tearDown(ITestResult result) {

		   if (result.getStatus() == ITestResult.FAILURE) {
			   context.tracing().stop(new Tracing.StopOptions()
		                .setPath(Paths.get("traces/" + result.getName() + ".zip")));
		   }else {
			   context.tracing().stop();
		   }
	       context.close();
	        browser.close();
	       playwright.close();
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

	   
