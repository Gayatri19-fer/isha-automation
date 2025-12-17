package org.ishafoundation.pages.Sadhguru.Organic.general;

import com.microsoft.playwright.Page;

public class generalOrganicDonatePage {
	private Page page;
	
	public generalOrganicDonatePage(Page page) {
		this.page =page;
	}
	
	private String Amountext = "input[name='custom_amount']";
	private String selecttext = "label:has-text('700')";
	
	   public void Enteramount() {
		   page.locator("#amt-block").check();
		  // page.fill(Amountext, "5250");
		   page.fill(Amountext,"542");
		   page.keyboard().press("Tab");  // makes framework fire validation
	   }
	    
	    public void SelectAmount() {
	    	page.click(selecttext);
	    }
	   public void Continue() {
		   
			    page.locator("#continue").click();  // this triggers the new tab
		 
				   
	   }
}
