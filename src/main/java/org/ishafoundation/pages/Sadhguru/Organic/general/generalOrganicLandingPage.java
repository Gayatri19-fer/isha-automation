package org.ishafoundation.pages.Sadhguru.Organic.general;

import com.microsoft.playwright.Page;

public class generalOrganicLandingPage {
	
	private Page page;
	
	public generalOrganicLandingPage(Page page) {
		this.page =page;
	}
	
	private String donate = "a[class='donate-btn ']";
	
	public void donateclick() {
		page.click(donate);
	}

}
