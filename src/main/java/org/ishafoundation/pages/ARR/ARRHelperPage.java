package org.ishafoundation.pages.ARR;

import com.microsoft.playwright.Page;

public class ARRHelperPage {
	
	private Page page;
	
	public ARRHelperPage(Page page) {
		this.page =page;
	}

	 public void completeDonationFlow() {
	ARRPersonalDetailsPage AP = new ARRPersonalDetailsPage(page);
	AP.EnterFirstname();
	AP.EnterLasttname();
	AP.EnterEmail();
	AP.EnterPhonenumber();
	AP.Selectcitizenship();
	AP.Select80GTax();
	AP.Selectcountry();
	AP.Selectstate();
	AP.Entertcity();
	AP.EnterAddress();
	AP.EnterPincode();
	AP.EnterPan();
	AP.Submit();
	 }
}
