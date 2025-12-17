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
	 		    cancelTran2.first().click(new Locator.ClickOptions().setTimeout(15000));
	 		    

	 		 // cancelTran2.first().click();

	 			/*Locator cancelButton = page.frameLocator("#paymentFrame")
	 	 		.locator("a[title='Cancel Transaction']");
	 	 		cancelButton.click();
	 			 */
	 			}
	 	
	 	public void paymentselect() { // for select payment option and cancel payment
	 		 FrameLocator frame = page.frameLocator("#paymentFrame");
	 		 frame.locator("//div[@class='paymentinformation']//div[@id='verticalTab']//ul//li[2]")
	 		 .click(new Locator.ClickOptions().setTimeout(15000));
	 	}
	
	
}
