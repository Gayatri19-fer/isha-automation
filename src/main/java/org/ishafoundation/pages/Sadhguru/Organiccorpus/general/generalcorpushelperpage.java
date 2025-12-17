package org.ishafoundation.pages.Sadhguru.Organiccorpus.general;

import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalpersonaldetailsPage;

import com.microsoft.playwright.Page;

public class generalcorpushelperpage {
	
	private Page page;
	
	public generalcorpushelperpage(Page page) {
		this.page =page;
	}
	public void completeflow() {
		generalcorpuspersonalpage og = new generalcorpuspersonalpage(page);
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
