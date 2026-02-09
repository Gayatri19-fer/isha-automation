package org.ishafoundation.pages.Sadhguru.Organic.general;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class OrganicDonatePage {
	private Page page;
	
	public OrganicDonatePage(Page page) {
		this.page =page;
	}
	
	private String Amountext = "input[name='custom_amount']";
	private String selecttext = "label:has-text('700')";
	
	   public void Enteramount() {
		   page.locator("#amt-block").check();
			page.locator("//div[@class='radio radio-amt']").click();
			Locator inputbox = page.locator("input[name='custom_amount']");
			inputbox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			inputbox.fill("501");
			page.evaluate("document.getElementById('hidden_donation_amount').value = '1200'");
			
	   }
	    
	    public void SelectAmount() {
	    	page.click(selecttext);
	    }
	   public void Continue() {
		   
			    page.locator("#continue").click();  // this triggers the new tab
		 
				   
	   }
}
