package org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Birthdaycorpuspaymentpage {
	private Page page;
	
	public Birthdaycorpuspaymentpage(Page page) {
		this.page =page;
	}
	private String netbacking = "//article[normalize-space()='Wallets']";

	private String pay = "(//article[@role='none'][normalize-space()='proceed to pay'])[2]";
	public void clickoncancel() {

		page.locator("//u[normalize-space()='Cancel']").click();

	}
	
	public void Cancletansaction2() {

		// Step 1: Wait for the popup to appear
	    Locator popup = page.locator("//div[@testid='pop_cancel']");
	    page.waitForTimeout(300); // give UI time to render popup

	    try {
	        popup.waitFor(new Locator.WaitForOptions()
	                .setState(WaitForSelectorState.VISIBLE)
	                .setTimeout(10000));
	        System.out.println("✅ Popup is now visible.");
	    } catch (PlaywrightException e) {
	        throw new RuntimeException("❌ Popup did not appear after clicking Cancel.");
	    }

	    // Step 3: Wait for Confirm button inside popup and click it
	    Locator confirmButton = page.locator("(//article[@role='none'][normalize-space()='Confirm'])");

	    try {
	        confirmButton.waitFor(new Locator.WaitForOptions()
	                .setState(WaitForSelectorState.VISIBLE)
	                .setTimeout(8000));
	        page.waitForTimeout(200); // allow animation to settle
	        confirmButton.scrollIntoViewIfNeeded();
	        confirmButton.click(new Locator.ClickOptions()
	                .setForce(true)
	                .setTimeout(8000));
	        System.out.println("✅ Confirm clicked successfully.");
	    } catch (PlaywrightException e) {
	        throw new RuntimeException("❌ Failed to click Confirm button within popup.", e);
	    }

	    // Step 4: Ensure popup disappears after confirm
	    try {
	        popup.waitFor(new Locator.WaitForOptions()
	                .setState(WaitForSelectorState.DETACHED)
	                .setTimeout(10000));
	        System.out.println("✅ Popup closed successfully.");
	    } catch (PlaywrightException e) {
	        System.out.println("⚠️ Popup still visible after confirm click (may be auto-closed later).");
	    }
	}
	
	public void paymentselect() {
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
	     //   System.out.println("✅ option selected successfully.");
	    } catch (PlaywrightException e) {
	        throw new RuntimeException("❌ Failed to click on option ", e);
	    }
	    
	    Locator pay = page.locator("div[testid='btn_pay'] article[role='none']:has-text('proceed to pay')");
	    pay.click(new Locator.ClickOptions()
                .setForce(true)
                .setTimeout(8000));
	    
	}
	   public void passprotflowcancleplaywright() {

		   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel')]")
	        .first()
	        .click();   
	   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel Transaction')]")
       .first()
       .click();
	   }


}
