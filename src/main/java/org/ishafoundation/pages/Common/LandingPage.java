package org.ishafoundation.pages.Common;

import com.microsoft.playwright.Page;

public class LandingPage {	
	
	private Page page;
	
	public LandingPage(Page page) {
		this.page = page;
	}
	
	
	public void GramotsavamDonation () {
		page.locator("#donation_for").selectOption("Gramotsavam Donation");
	}

	public void FPODonation () {
		page.locator("#donation_for").selectOption("FPO - Empowering Farmers");
	}
	
	public void ARRDonation () {
		page.locator("#donation_for").selectOption("Action For Rural Rejuvenation");
	}
}
