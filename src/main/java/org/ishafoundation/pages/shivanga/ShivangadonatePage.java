package org.ishafoundation.pages.shivanga;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ShivangadonatePage {
	
	private Page page;
	
	private String Amountext = "input[name='custom_amount']";
	private String selecttext = "label:has-text('500')";
	
	   public ShivangadonatePage(Page page) {
	        this.page = page;
	    }
   
	   public void Enteramount() {
		   page.locator("#amt-block").click();
		  // page.fill(Amountext, "5250");
		   page.locator(Amountext).type("5423");
		   page.keyboard().press("Tab");  // makes framework fire validation
	   }
	    public void SelectAmount() {
	    	page.click(selecttext);
	    }
	   public void Continue() {
		   page.locator("#continue").click();
	   }
	

}
