package org.ishafoundation.pages.iso.IV.Recurring;

import com.microsoft.playwright.Page;

public class IVDonationHelper {
	
	private Page page;
	
	   public IVDonationHelper(Page page) {
	        this.page = page;
	    }
	   public void completeDonationFlow() {
		   

		   IVRecurringPersonalPage pp = new IVRecurringPersonalPage(page);
		   pp.EnterFirstname();
		   pp.EnterLasttname();
		   pp.EnterEmail();
		   pp.EnterPhonenumber();
		   pp.Selectcitizenship();
		   pp.Selectstate();
		   pp.Entertcity();
		   pp.EnterAddress();
		   pp.EnterPincode();
		   pp.EnterPan();
		   pp.Submit();
	   }
	   

}
