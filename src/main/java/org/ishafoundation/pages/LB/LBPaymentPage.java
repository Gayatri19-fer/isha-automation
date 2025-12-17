package org.ishafoundation.pages.LB;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LBPaymentPage {
	
	private  Page  page;

	public LBPaymentPage(Page page) {
		this.page= page;
	}
	private String title = "#donation_title";
 	private String canclebutton = "text=Cancel";
 	private String selectrediobut = "reasonRadio1";
 	//private String canceltransaction = "a[title='Cancel Transaction']";
 	//private String canceltransaction = "div#buttons >> a[title='Cancel Transaction']";
 	private String canceltransaction = ".online-contribution";
 	//a.primary-button.primary-button-bg.radius4.confirmCancel";


 	public void Canclepaymentclick() {
 		//	String iframselector = "#paymentFrame";
 		//Locator cancelElement = page.frameLocator(iframselector).locator(canclebutton);
 		//  cancelElement.click();
 		FrameLocator frame = page.frameLocator("#paymentFrame");
 		Locator cancelButton = frame.locator("div#buttons >> a.secondary-link.cancel");
 		cancelButton.nth(0).click();
 	}

 	public void CancleTransaction() {

	  FrameLocator frame = page.frameLocator("#paymentFrame");
	  Locator canceltran1 = frame.locator("div[style*='display: block'] div#buttons a.confirmCancel");
	  Locator cancelTran2 = frame.locator("a.confirmCancel:has-text('Cancel Transaction')");
	  
	
	  cancelTran2.first().waitFor(new Locator.WaitForOptions()
         .setState(WaitForSelectorState.VISIBLE)
         .setTimeout(15000));
	    // Click and wait for navigation
	    cancelTran2.first().click(new Locator.ClickOptions().setTimeout(15000));
	    page.waitForURL("https://lingabhairavi.org/en/devicrowdfunding/donate/cancel", 
	    	    new Page.WaitForURLOptions().setTimeout(15000));
	    
	    // Wait until the cancel page title is visible
	  //  page.locator("h2[class='title']").waitFor(new Locator.WaitForOptions()
	   //     .setState(WaitForSelectorState.VISIBLE)
	   //     .setTimeout(15000));
	 // cancelTran2.first().click();

		/*Locator cancelButton = page.frameLocator("#paymentFrame")
 		.locator("a[title='Cancel Transaction']");
 		cancelButton.click();
		 */
		}
 	
    public String getPageUrl() {
    	String Currecnturl = page.url();
    	System.out.println("Open URL " + Currecnturl);
    	return Currecnturl;
    }

	

}
