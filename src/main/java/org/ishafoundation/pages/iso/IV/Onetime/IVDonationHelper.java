package org.ishafoundation.pages.iso.IV.Onetime;

import com.microsoft.playwright.Page;

public class IVDonationHelper {
	
	private Page page;
	
	public IVDonationHelper(Page page) {
		this.page = page;
	}
	
	public void completedonationflow() {
		IVOnetimePersonalPage IVOnetime = new IVOnetimePersonalPage(page);
		IVOnetime.EnterFirstname();
		IVOnetime.EnterLasttname();
		IVOnetime.EnterEmail();
		IVOnetime.EnterPhonenumber();
		IVOnetime.Selectcitizenship();
		IVOnetime.Select80GTax();
		IVOnetime.Selectcountry();
		IVOnetime.Selectstate();
		IVOnetime.Entertcity();
		IVOnetime.EnterAddress();
		IVOnetime.EnterPincode();
		IVOnetime.EnterPan();
		IVOnetime.Submit();
	}

}
