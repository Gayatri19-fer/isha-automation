package org.ishafoundation.pages.shivanga;

import com.microsoft.playwright.Page;

public class DonationHelpershivanga {
	
	private Page page;
	
	public DonationHelpershivanga(Page page) {
		this.page = page;
	}
	public void dontionfow() throws InterruptedException {
		ShivangadonatePage sd = new ShivangadonatePage(page);
		sd.SelectAmount();
		sd.Continue();
		ShivangaPersonalDetails sp = new ShivangaPersonalDetails(page);
		sp.EnterFirstname();
		sp.EnterLasttname();
		sp.EnterEmail();
		sp.EnterPhonenumber();
		sp.Selectstate();
		sp.selectcity();
		sp.EnterAddress();
		sp.EnterPincode();
	//	sp.EnterPan();
		sp.checkbox();
		sp.paysecuarly();
	}
	

}
