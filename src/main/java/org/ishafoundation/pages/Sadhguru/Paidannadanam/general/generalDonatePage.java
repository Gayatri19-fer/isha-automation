package org.ishafoundation.pages.Sadhguru.Paidannadanam.general;

import com.microsoft.playwright.Page;

public class generalDonatePage {
	private Page page;
	
	public generalDonatePage(Page page) {
		this.page= page;	}
	
	private String selectamount = "(//div[@class='radio'])[1]";
	private String customeamount = "input[id='custom_amount__0']";
	private String donate = "input[value='Donate']";
			
	public void Enteramount() {
		//page.locator(".amount.full-width").click();
		//page.fill(customeamount, "111");
		page.click(selectamount);
	}
	
	public void clickondonate() {
		page.click(donate);
	}

}
