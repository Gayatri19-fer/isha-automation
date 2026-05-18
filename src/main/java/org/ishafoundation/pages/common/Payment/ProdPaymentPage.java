package org.ishafoundation.pages.common.Payment;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ProdPaymentPage implements PaymentPage{
    private Page page;

    public ProdPaymentPage(Page page) {
        this.page = page;
    }
    
	public void CancelInd() {
		Locator wallate = page.locator("(//article[@role='none'][normalize-space()='Wallets'])");
		wallate.click();
		Locator option = page.locator("//div[@testid='pi_wallet_jiomoney']");
		page.waitForTimeout(300); 
	    try {
	    	option.waitFor(new Locator.WaitForOptions()
	                .setState(WaitForSelectorState.VISIBLE)
	                .setTimeout(8000));
	        page.waitForTimeout(200); // allow animation to settle
	        option.scrollIntoViewIfNeeded();
	        option.click(new Locator.ClickOptions()
	                .setForce(true)
	                .setTimeout(8000));
	     //   System.out.println("option selected successfully.");
	    } catch (PlaywrightException e) {
	        throw new RuntimeException("❌ Failed to click on option ", e);
	    }
	    
	    Locator pay = page.locator("div[testid='btn_pay'] article[role='none']:has-text('proceed to pay')");
	    pay.click(new Locator.ClickOptions()
                .setForce(true)
                .setTimeout(8000));
	    
	    
	}
	public void FailInd() {
		System.out.println("URL: " + page.url());

		System.out.println("Count: " +
		    page.locator("div[configpath='Exit.SecondaryButton']").count());

		System.out.println("Visible: " +
		    page.locator("div[configpath='Exit.SecondaryButton']").isVisible());
		 Locator cancelBtn = page.locator("div[configpath='Exit.SecondaryButton']");
		 cancelBtn.waitFor(new Locator.WaitForOptions()
			        .setState(WaitForSelectorState.VISIBLE));
		    cancelBtn.click(new Locator.ClickOptions().setTimeout(10000));

		    Locator confirmBtn = page.locator("//div[@role='button'][normalize-space()='Confirm']");
		    confirmBtn.waitFor(new Locator.WaitForOptions()
		            .setState(WaitForSelectorState.ATTACHED));

		    confirmBtn.click(new Locator.ClickOptions().setTimeout(10000));
	}
	
	public void cancelPassport() {
		  page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel")).click();
		//  page.frameLocator("#paymentFrame").locator("a.default-link.cancel-btn:text('Cancel')").click();
		  page.frameLocator("#paymentFrame").getByText("Wish to review my order again").click();

		   page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions()
				   .setName("Submit")).click();
		   

	    }
	   public void cancleplaywright() {
		    //  page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel")).click();
		  // page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel Transaction")).click();
		   FrameLocator frame = page.frameLocator("#paymentFrame");
		   frame.locator("a.secondary-link.cancel")
	         .first()
	         .click(new Locator.ClickOptions().setTimeout(10000));
		   
		   frame.locator("//a[contains(normalize-space(), 'Cancel Transaction')]").click();
		/*   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel')]")
		        .first()
		        .click();   
		   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel Transaction')]")
	        .first()
	        .click()*/
		    }
  
	
	public void ccavenue() {
		 Locator cancellink=  page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel')]")
			        .first();
				 cancellink.waitFor();
				 cancellink.click();
	   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel Transaction')]")
    .first()
    .click();
	}

	public void paymentselectind() {
		Locator wallate = page.locator("(//article[@role='none'][normalize-space()='Wallets'])");
		wallate.click();
		Locator option = page.locator("//div[@testid='pi_wallet_jiomoney']");
		page.waitForTimeout(300); 
	    try {
	    	option.waitFor(new Locator.WaitForOptions()
	                .setState(WaitForSelectorState.VISIBLE)
	                .setTimeout(8000));
	        page.waitForTimeout(200); // allow animation to settle
	        option.scrollIntoViewIfNeeded();
	        option.click(new Locator.ClickOptions()
	                .setForce(true)
	                .setTimeout(8000));
	     //   System.out.println("option selected successfully.");
	    } catch (PlaywrightException e) {
	        throw new RuntimeException("❌ Failed to click on option ", e);
	    }
	    
	    Locator pay = page.locator("div[testid='btn_pay'] article[role='none']:has-text('proceed to pay')");
	    pay.click(new Locator.ClickOptions()
                .setForce(true)
                .setTimeout(8000));
	    
	}

	public void payucancle() {
	
		page.click("//i[@id='sidebar-backBtn']");

		Locator button = page.locator("//button[normalize-space()='YES, CANCEL']");
		button.waitFor();
		button.click();
		Locator selectradio = page.locator("(//label[contains(@class,'cstm-radio')])[1]");
		selectradio.waitFor();
		selectradio.click();
		Locator submit = page.locator("//button[normalize-space()='Submit']");
		submit.click();
		
	}
	
	public void MSRccavenue() 
	{
		
	    	FrameLocator frame = page.frameLocator("#paymentFrame");
	 		Locator cancelButton = frame.locator("div#buttons >> a.secondary-link.cancel");
	 		cancelButton.nth(0).click();
	
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

}
