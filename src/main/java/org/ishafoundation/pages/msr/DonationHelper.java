package org.ishafoundation.pages.msr;

import com.microsoft.playwright.Page;

public class DonationHelper {
	
	private Page page;
	
	   public DonationHelper(Page page) {
	        this.page = page;
	    }
	   public void completeDonationFlow() {
	   MsrLandingPage msrl = new MsrLandingPage(page);
       msrl.Donationbuttonclick();
       MsrDonationPage msrd = new MsrDonationPage(page);
       msrd.EnterAmount();
       msrd.Donationbuttonclick2();
       MsrPersonalDetailsPage msrpersonal = new MsrPersonalDetailsPage(page);
       msrpersonal.EnterFirstname();
       msrpersonal.EnterLasttname();
       msrpersonal.EnterEmail();
       msrpersonal.EnterPhonenumber();
       msrpersonal.EnterPINnumber();
       msrpersonal.EnterAddress();
       msrpersonal.Selectcheckbox();
       msrpersonal.paysecuarly();
	   }
}
