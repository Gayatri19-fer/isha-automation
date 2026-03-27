package org.ishafoundation.pages.Sadhguru.Dhyanlinga;

import com.microsoft.playwright.Page;

public class DhyanlingaDonateapage {
	
	private Page page;
	
	public DhyanlingaDonateapage(Page page) {
		this.page =page;
	}
	
	private String Amountext = "input[name='custom_amount']";
	private String selecttext = "label:has-text('2,000')";
	
	   public void Enteramount() {
		   page.locator("#amt-block").click();
		  // page.fill(Amountext, "5250");
		   page.locator(Amountext).type("20000");
		   page.keyboard().press("Tab");  // makes framework fire validation
	   }
	    public void SelectAmount() {
	    	page.click(selecttext);
	    }
	   public void Continue() {
		   page.locator("#continue").click();
	   }

}
