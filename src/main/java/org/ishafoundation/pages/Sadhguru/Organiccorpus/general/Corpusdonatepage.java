package org.ishafoundation.pages.Sadhguru.Organiccorpus.general;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class Corpusdonatepage {
	private Page page;

	
	public Corpusdonatepage(Page page) {
		this.page =page;
	}

	private String onetime = "#tab-onetime";
	private String selectamount = "(//div[@class='radio'])[1]";
	private String continueclick = "#continue";
	
    public void selectonetime() {
    	page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.locator(onetime).click(); 
       
    }
    
    public void selectamount() {
        page.locator(selectamount).click(); 
    }
   
    public void clickcontinue() {
        page.locator(continueclick).click(); 
    }
	public void Enteramount() {
		page.locator("#amt-block:visible").check();
		Locator amount = page.locator("#custom_amount_233_0");
		amount.click();
		amount.pressSequentially("500");
		page.keyboard().press("Tab");
	}
    
	
	
}
