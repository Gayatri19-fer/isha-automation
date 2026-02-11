package org.ishafoundation.pages.common.Payment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class UatPaymentPage implements PaymentPage{
    private Page page;

    public UatPaymentPage(Page page) {
        this.page = page;
    }
	public void CancelInd() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(2000); 
		Locator netBanking = page.locator("article:has-text('NetBanking')");
		netBanking.waitFor(new Locator.WaitForOptions().setTimeout(15000));
		netBanking.click();
		
		page.getByLabel("Avenue Test").click();
		Page page1 = page.waitForPopup(() ->{page.getByLabel("Proceed to Pay", new Page.GetByLabelOptions().setExact(true)).click();
		});
		page1.locator("#status").selectOption("N");	
		page1.locator("//button[@id='btn']").click();
	    
	}

	public void FailInd() {

		page.locator("//u[normalize-space()='Cancel']").click();
		page.locator("(//article[@role='none'][normalize-space()='Confirm'])").click();
		
	}
	public void cancelPassport() {
		page.locator("//u[normalize-space()='Cancel']").click();
		page.locator("(//article[@role='none'][normalize-space()='Confirm'])").click();
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
