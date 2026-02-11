package org.ishafoundation.pages.common.Payment;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
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
		page.locator("//u[normalize-space()='Cancel']").click();
		page.locator("(//article[@role='none'][normalize-space()='Confirm'])").click();
	}
	
	public void cancelPassport() {
		  page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel")).click();
		//  page.frameLocator("#paymentFrame").locator("a.default-link.cancel-btn:text('Cancel')").click();
		  page.frameLocator("#paymentFrame").getByText("Wish to review my order again").click();

		   page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions()
				   .setName("Submit")).click();
		   
	}
	public void ccavenue() {
		   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel')]")
	        .first()
	        .click();   
	   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel Transaction')]")
    .first()
    .click();
	}

}
