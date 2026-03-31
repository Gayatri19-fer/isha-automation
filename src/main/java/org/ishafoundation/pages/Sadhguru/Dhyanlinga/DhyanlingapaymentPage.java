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
	
	   public void cancleplaywright() {
		    //  page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel")).click();
		  // page.locator("#paymentFrame").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Cancel Transaction")).click();
		//   Frame frame = page.frame("paymentFrame");
		   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel')]")
		        .first()
		        .click();   
		   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel Transaction')]")
	        .first()
	        .click();
		    }

}
