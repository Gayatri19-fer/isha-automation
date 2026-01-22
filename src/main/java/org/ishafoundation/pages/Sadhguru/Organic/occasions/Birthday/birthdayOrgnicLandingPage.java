package org.ishafoundation.pages.Sadhguru.Organic.occasions.Birthday;

import com.microsoft.playwright.Page;

public class birthdayOrgnicLandingPage {

	private Page page;
	
	public birthdayOrgnicLandingPage(Page page) {
		this.page = page;
	}
	
	private String lernmoreclick = "(//div[@class='image-content'])[2]//a[normalize-space(text())='Learn more']";
	
	public void clicklernmore() {
		page.click(lernmoreclick);
	}
}
