package org.ishafoundation.pages.Sadhguru.Organic.general;

import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.PersonaldetailsPage;

import com.microsoft.playwright.Page;

public class Organichelper {
	private Page page;
	
	public Organichelper(Page page) {
		this.page =page;
	}

	public void completeflow() {
		OrganicpersonaldetailsPage og = new OrganicpersonaldetailsPage(page);
		og.EnterFirstname();
		og.EnterLasttname();
		og.EnterEmail();
		og.EnterPhonenumber();
		og.Selectcitizenship();
		og.Select80GTax();
		og.Selectcountry();
		og.Selectstate();
		og.Entertcity();
		og.EnterAddress();
		og.EnterPincode();
		og.Enteroccasion();
		og.Enterdateodoccasion();
		og.Enterpersonhonoured();
		og.EnterPan();
		og.Submit();
	}
}
