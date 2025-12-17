package org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class birthdaypaymentPage {
	private Page page;
	
	public birthdaypaymentPage(Page page) {
		this.page=page;
	}
	
	private String netbacking = "//article[normalize-space()='Wallets']";
//	private String selectbank = "//div[@id='80000278']//div[@class='linearLayout focused']";
	private String pay = "(//article[@role='none'][normalize-space()='proceed to pay'])[2]";
	public void Cancleclick() {
		//page.click(netbacking);
		//page.click(selectbank);
		//page.click(bankoption);
	//	Locator block =page.locator("//div[@id='80000287']//div[@class='linearLayout']");
	//	block.locator("//div[id='80000253']//div[@class='linearLayout focused']").click();
		//page.click(pay);
		
		page.locator("//u[normalize-space()='Cancel']").click();
		page.locator("(//article[@role='none'][normalize-space()='Confirm'])").click();
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
	       // System.out.println("✅ option selected successfully.");
	    } catch (PlaywrightException e) {
	        throw new RuntimeException("❌ Failed to click on option ", e);
	    }
	    
	    Locator pay = page.locator("div[testid='btn_pay'] article[role='none']:has-text('proceed to pay')");
	    pay.click(new Locator.ClickOptions()
                .setForce(true)
                .setTimeout(8000));
	    
	}
	   public void passprotflowcancleplaywright() {

		  page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel")).click();
		//  page.frameLocator("#paymentFrame").locator("a.default-link.cancel-btn:text('Cancel')").click();
		  page.frameLocator("#paymentFrame").getByText("Wish to review my order again").click();

		   page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions()
				   .setName("Submit")).click();
		   
		    }

}
