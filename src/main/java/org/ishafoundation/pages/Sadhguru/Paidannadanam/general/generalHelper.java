package org.ishafoundation.pages.Sadhguru.Paidannadanam.general;

import com.microsoft.playwright.Page;

public class generalHelper {
	private Page page;
	
	
	public generalHelper(Page page) {
		this.page = page;
	}
	public void completedonationfow() {
		generalpersonaldetailsPage gp = new generalpersonaldetailsPage(page);
		gp.EnterFirstname();
		gp.EnterLasttname();
		gp.EnterEmail();
		gp.EnterPhonenumber();
		gp.Selectcitizenship();
		gp.Select80GTax();
		gp.Selectcountry();
		gp.Selectstate();
		gp.Entertcity();
		gp.EnterAddress();
		gp.EnterPincode();
		gp.Enteroccasion();
		gp.Enterdateodoccasion();
		gp.Enterpersonhonoured();
		gp.EnterPan();
		gp.Submit();
	}
	
}
