package org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage;

import com.microsoft.playwright.Page;

public class marriageOrganicLandingPage {
	private Page page;
	
	public marriageOrganicLandingPage(Page page) {
		this.page = page;
	}
	
	private String lernmoreclick = "(//div[@class='image-content'])[1]//a[normalize-space(text())='Learn more']";
	
	public void clicklernmore() {
		page.click(lernmoreclick);
	}


}
