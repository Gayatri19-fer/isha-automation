package org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class BirthdaycorpuscancelPage {
	private Page page;
	
	public BirthdaycorpuscancelPage(Page page) {
		this.page =page;
	}
	
	private String cancletitle = "h2[class='title']";
	
	public boolean isfailedPageOpen() {
		//  boolean output =  page.isVisible(cancletitle);
		//  System.out.println(output);
		//  return output;
		try {
		    // Wait until redirect to failed
		    page.waitForURL("**/failed*", new Page.WaitForURLOptions().setTimeout(30000));

		    // Defensive wait for DOM
		    page.waitForLoadState(LoadState.DOMCONTENTLOADED, new Page.WaitForLoadStateOptions().setTimeout(15000));
		    page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(15000));

		    // Check URL + failed page element
		    if (page.url().contains("failed")) {
		        page.waitForSelector(cancletitle, new Page.WaitForSelectorOptions().setTimeout(10000));
		        return page.isVisible(cancletitle);
		    } else {
		        System.out.println("Redirected but URL does not contain 'failed': " + page.url());
		        return false;
		    }

		} catch (Exception e) {
		    System.out.println("Failed page not visible. Current URL: " + page.url());
		    e.printStackTrace();
		    return false;
		}

	}
	
	public boolean iscanclePageOpen() {
		//  boolean output =  page.isVisible(cancletitle);
		//  System.out.println(output);
		//  return output;
		try {
		    // Wait until redirect to failed
		    page.waitForURL("**/cancel*", new Page.WaitForURLOptions().setTimeout(30000));

		    // Defensive wait for DOM
		    page.waitForLoadState(LoadState.DOMCONTENTLOADED, new Page.WaitForLoadStateOptions().setTimeout(15000));
		    page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(15000));

		    // Check URL + failed page element
		    if (page.url().contains("cancel")) {
		        page.waitForSelector(cancletitle, new Page.WaitForSelectorOptions().setTimeout(10000));
		        return page.isVisible(cancletitle);
		    } else {
		        System.out.println("Redirected but URL does not contain 'cancel': " + page.url());
		        return false;
		    }

		} catch (Exception e) {
		    System.out.println("Failed page not visible. Current URL: " + page.url());
		    e.printStackTrace();
		    return false;
		}

	}
	
	public String canclemsg() {
		System.out.println(page.textContent(cancletitle));
		return cancletitle; 
	}
	   
    public String getPageUrl() {
    	String Currecnturl = page.url();
    	System.out.println("Open URL " + Currecnturl);
    	return Currecnturl;
    }
	


}
