package org.ishafoundation.pages.Sadhguru.Organic.occasions.Birthday;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class birthdayOrganicDonatePage {
private Page page;
	
	public birthdayOrganicDonatePage(Page page) {
		this.page =page;
	}
	
	private String donatebutn = "//input[@id='continue']";
	
	public void Enteramount() {
		page.locator("//div[@class='radio radio-amt']").click();
		Locator inputbox = page.locator("input[name='custom_amount']");
		inputbox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		inputbox.fill("501");
		page.evaluate("document.getElementById('hidden_donation_amount').value = '1200'");
		
	
	}
	
	public void countinuebtnclick() {
		page.click(donatebutn);
	}
	
	public void selectamount() {
		page.locator("(//div[@class='radio'])[2]").click();
	}


}
