package org.ishafoundation.pages.cp.Onetime;

import com.microsoft.playwright.Page;

public class CACADoationHelper {
	private Page page;
	
	public CACADoationHelper(Page page) {
		this.page = page;

	}
	
	public void completedonationflow() {
	CACAOnetimePeronalPage CCP= new CACAOnetimePeronalPage(page);
	CCP.EnterFirstname();
	CCP.EnterLasttname();
	CCP.EnterEmail();
	CCP.EnterPhonenumber();
	CCP.Selectcitizenship();
	CCP.Select80GTax();
	CCP.Selectcountry();
	CCP.Selectstate();
	CCP.Entertcity();
	CCP.EnterAddress();
	CCP.EnterPincode();
	CCP.EnterPan();
	CCP.Submit();
	}
}
