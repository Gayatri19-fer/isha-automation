package org.ishafoundation.pages.Sadhguru.Organiccorpus.general;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class generalcorpusdonatepage {
	private Page page;

	
	public generalcorpusdonatepage(Page page) {
		this.page =page;
	}

	private String onetime = "#tab-onetime";
	private String selectamount = "(//div[@class='radio'])[1]";
	private String continueclick = "#continue";
	
    public void selectonetime() {
        page.locator(onetime).click(); 
    }
    
    public void selectamount() {
        page.locator(selectamount).click(); 
    }
   
    public void clickcontinue() {
        page.locator(continueclick).click(); 
    }
    
    
	
	
}
