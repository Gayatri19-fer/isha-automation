package org.ishafoundation.pages.Sadhguru.Dhyanlinga;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DhyanlingapaymentPage {
	private Page page;
	
	public DhyanlingapaymentPage(Page page) {
		this.page =page;
	}
	
	public void payucancle() {

		
		page.click("//i[@id='sidebar-backBtn']");

		Locator button = page.locator("//button[normalize-space()='YES, CANCEL']");
		button.waitFor();
		button.click();
		Locator selectradio = page.locator("(//label[contains(@class,'cstm-radio')])[1]");
		selectradio.waitFor();
		selectradio.click();
		Locator submit = page.locator("//button[normalize-space()='Submit']");
		submit.click();
		
	}

}
