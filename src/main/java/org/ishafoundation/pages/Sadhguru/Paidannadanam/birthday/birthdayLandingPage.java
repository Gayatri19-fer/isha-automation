package org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday;

import com.microsoft.playwright.Page;

public class birthdayLandingPage {
	private Page page;
	
	public birthdayLandingPage(Page page){
		this.page =page;
	}

	private String donate = "button[class='donate-btn']";
	
	public void clickondonate() {
		page.click(donate);
	}

}
