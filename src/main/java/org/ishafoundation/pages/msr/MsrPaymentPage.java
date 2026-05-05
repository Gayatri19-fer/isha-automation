package org.ishafoundation.pages.msr;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class MsrPaymentPage {

	private Page page;
	
	
	private String canclebutton = "div#buttons >> a.secondary-link.cancel";
	private String selectrediobut = "reasonRadio1";
	private String canceltransaction = "a[title='Cancel Transaction']";
	
	   public MsrPaymentPage(Page page) {
	        this.page = page;
	    }
	
	   
	   public void cancleplaywright() {
		      page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel")).click();
		      page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel Transaction")).click();
	   }
	   
	   
	    public void Canclepaymentclick() {
	    	
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
	 		 //   cancelTran2.first().click(new Locator.ClickOptions().setTimeout(15000));
	 		    
	 		    // new change added 5/5/26 Retry click if needed
	 		    for (int i = 0; i < 3; i++) {
	 		        try {
	 		            cancelTran2.click(new Locator.ClickOptions()
	 		                    .setTimeout(5000)
	 		                    .setNoWaitAfter(true));
	 		           // Wait short time to see if redirect happens
	 		            page.waitForTimeout(2000);

	 		            if (page.url().contains("cancel")) {
	 		                System.out.println("Cancel redirect success");
	 		                break;
	 		            }
	 		        } catch (Exception e) {
	 		            System.out.println("Retry click attempt: " + (i + 1));
	 		            page.waitForTimeout(1000); // small wait before retry
	 		        }
	 		    }

	 			}
	 	
	 	public void paymentselect() { // for select payment option and cancel payment
	 		 FrameLocator frame = page.frameLocator("#paymentFrame");
	 		 frame.locator("//div[@class='paymentinformation']//div[@id='verticalTab']//ul//li[2]")
	 		 .click(new Locator.ClickOptions().setTimeout(15000));
	 	}
	
	
}
