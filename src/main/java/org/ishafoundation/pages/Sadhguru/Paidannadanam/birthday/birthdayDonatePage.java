package org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class birthdayDonatePage {
	private Page page;
	
	public birthdayDonatePage(Page page) {
		this.page =page;
	}

	private String seeoption = ".other-options";
	
	public void selectamount() {
		page.locator("(//div[@class='radio'])[1]").click();
	}
	
	public void Enteramount() {
		
			page.locator("#amt-block:visible").check();
			Locator amount = page.locator("#amt-block");
			amount.click();
			amount.pressSequentially("500");
			page.keyboard().press("Tab");
		
	}
	
}

