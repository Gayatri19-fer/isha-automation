package org.ishafoundation.pages.Common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DonatePage {
	
	private Page page;
	
	public DonatePage(Page page) {
		this.page = page;
	}
	
	private String Onetime = "//div[contains(text(),'Give One-Time')]";
	private String selectamount = "//div[contains(text(),'10 Trees')]";
	private String Clickonnext = "//div[@id='continue']";
	
	   public void Enteramount() {
		   page.locator("#amt-block").check();
			page.locator("//div[@class='radio_amount']").click();
			Locator inputbox = page.locator("input[name='custom_amount']");
			inputbox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			inputbox.fill("501");
			page.evaluate("document.getElementById('hidden_donation_amount').value = '1200'");
			page.locator("#continue");
	   }

}
