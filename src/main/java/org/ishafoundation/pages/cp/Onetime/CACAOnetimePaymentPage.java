package org.ishafoundation.pages.cp.Onetime;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CACAOnetimePaymentPage {
	private Page page;
	
	public CACAOnetimePaymentPage(Page page) {
		this.page = page;
	}
	
 	private String canclebutton = "text=Cancel";
 	private String selectrediobut = "reasonRadio1";
 	//private String canceltransaction = "a[title='Cancel Transaction']";
 	//private String canceltransaction = "div#buttons >> a[title='Cancel Transaction']";
 	private String canceltransaction = ".online-contribution";
 	//a.primary-button.primary-button-bg.radius4.confirmCancel";

	   public void cancleplaywright() {
		    //  page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel")).click();
		  // page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel Transaction")).click();
		//   Frame frame = page.frame("paymentFrame");
		   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel')]")
		        .first()
		        .click();   
		   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel Transaction')]")
	        .first()
	        .click();
		    }
	   

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
	    
	    // Wait until the cancel page title is visible
	    page.locator("h2.title").waitFor(new Locator.WaitForOptions()
	        .setState(WaitForSelectorState.VISIBLE)
	        .setTimeout(15000));
	 // cancelTran2.first().click();

		/*Locator cancelButton = page.frameLocator("#paymentFrame")
 		.locator("a[title='Cancel Transaction']");
 		cancelButton.click();
		 */
		}

	
    }




