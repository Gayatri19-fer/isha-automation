package org.ishafoundation.pages.iso.IV.SM;

import com.microsoft.playwright.Page;

public class SMDonatepage {
	private Page page;
	
	public SMDonatepage(Page page) {
		this.page = page;
	}
	private String amountblock ="#amt-block";
	private String amount = "//input[@id='custom_amount']";
	private String click = "#continue";
	private String hiddenamount = "#hidden_donation_amount";
	
	public void Enteramount() {
		page.click(amountblock);
		page.fill(amount, "200");
		// amount not updating in js so added this line
		page.evaluate("document.getElementById('hidden_donation_amount').value = '1200'");
		page.click(click);
	}
	public void clickcontinue() {
		page.click(click);
		page.waitForTimeout(3000);
		String Curenturl = page.url();
		System.out.println("currernt url" + Curenturl);
	}

}
