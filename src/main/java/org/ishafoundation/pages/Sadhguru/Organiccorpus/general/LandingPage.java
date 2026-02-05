package org.ishafoundation.pages.Sadhguru.Organiccorpus.general;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LandingPage {
	private Page page;

	
	public LandingPage(Page page) {
		this.page =page;
	}
	
	public void generalflow() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Donate")).click();
		//page.locator("(//div[@class='image-content'])[1]//a[normalize-space(text())='Learn more']").click();
	}
	public void weddingflow() {
		page.locator("//a[@href='https://isha.sadhguru.org/en/contribute/annadanam/donate/wedding']").click();
	}
	public void birthdayflow() {
		page.locator("//a[@href='https://isha.sadhguru.org/en/contribute/annadanam/donate/birthday']").click();
	}
	public void Remembraceflow() {
		page.locator("//a[@href='https://isha.sadhguru.org/en/contribute/annadanam/donate/in-memorial-of']").click();
	}
	

}
