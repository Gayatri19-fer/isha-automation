package org.ishafoundation.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Cancelpage {
	private Page page;
	
	public Cancelpage(Page page) {
		this.page =page;
	}
	
	private String cancletitle = "h2[class='title']";
	
	public boolean isfailedPageOpen() {
		//  boolean output =  page.isVisible(cancletitle);
		//  System.out.println(output);
		//  return output;
		try {
			page.waitForURL(url -> url.contains("failed"), new Page.WaitForURLOptions().setTimeout(50000));
		 //   page.waitForURL("**/failed*", new Page.WaitForURLOptions().setTimeout(30000));

		    // Defensive wait for DOM
		 //   page.waitForLoadState(LoadState.DOMCONTENTLOADED, new Page.WaitForLoadStateOptions().setTimeout(15000));
		//    page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(15000));

		    // Check URL + failed page element
	        page.locator(cancletitle)
            .waitFor(new Locator.WaitForOptions()
            .setState(WaitForSelectorState.VISIBLE)
            .setTimeout(30000));
        return true;

		} catch (Exception e) {
		    System.out.println("Failed page not visible. Current URL: " + page.url());
		    e.printStackTrace();
		    return false;
		}

	}
	public boolean iscanclePageOpen() {
		try {
		    // Wait until redirect to failed
		    page.waitForURL(url -> url.contains("cancel"), new Page.WaitForURLOptions().setTimeout(50000));

		    // Defensive wait for DOM
		    // Wait ONLY for cancel page title (most important)
	        page.locator(cancletitle)
	            .waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE)
	            .setTimeout(30000));
	        return true;
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
