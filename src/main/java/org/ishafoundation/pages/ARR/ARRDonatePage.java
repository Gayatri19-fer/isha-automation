package org.ishafoundation.pages.ARR;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class ARRDonatePage {
private Page page;
	
	public ARRDonatePage(Page page) {
		this.page = page;
	}
	private String Amounttext = "(//label[@id='amt-block'])[2]";
	private String customeamount = "(//label[@id='amt-block'])[5]";
	
	   public void GramotsavamDonate() throws InterruptedException {
		   page.selectOption("#donation_for", 
				    new SelectOption().setLabel("Gramotsavam Donation"));
		   page.waitForTimeout(2000);
	   }
	   public void FPODonate() {
		   page.selectOption("#donation_for", 
				    new SelectOption().setLabel("FPO - Empowering Farmers"));
		   page.waitForTimeout(2000);
	   }
	   public void ActionruralDonate() {
		   page.selectOption("#donation_for", 
				    new SelectOption().setLabel("Action For Rural Rejuvenation"));
		   page.waitForTimeout(2000);
	   }
	   
	   public void Enteramount() {
		 
		   page.locator(customeamount).click();
		   Locator amount = page.locator("(//input[@id='custom_amount_3446_0'])[1]");
		    amount.type("200");
		    amount.press("Tab");
	   }
	    public void SelectAmount() {
	    	page.locator(Amounttext).click();
	    }
	    
	    public void continueclick() {
	    	page.locator("#continue").click();
	    }

}
