package org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday;

import com.microsoft.playwright.Page;

public class Birthdaycorpusdonationpage {
	private Page page;

	
	public Birthdaycorpusdonationpage(Page page) {
		this.page =page;
	}
	
	public void selectamount() {
		page.locator(".radio").first().click();
		page.locator("#continue").click();
	}

	public void enteramount() {
		page.locator("custom_amount_233_0").fill("250");
	}
	

}
