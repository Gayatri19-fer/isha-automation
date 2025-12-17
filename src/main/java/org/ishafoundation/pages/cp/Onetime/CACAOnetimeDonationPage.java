package org.ishafoundation.pages.cp.Onetime;

import com.microsoft.playwright.Page;

public class CACAOnetimeDonationPage {
	private Page page;
	
	public CACAOnetimeDonationPage(Page page) {
		this.page = page;
	}
	
	private String Onetime = "//div[contains(text(),'Give One-Time')]";
	private String selectamount = "//div[contains(text(),'10 Trees')]";
	private String Clickonnext = "//div[@id='continue']";
	
	public void DonatePage () {
		page.click(Onetime);
		page.click(selectamount);
		page.click(Clickonnext);
	}

}
