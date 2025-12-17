package org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage;

import com.microsoft.playwright.Page;

public class marriageOrganicHelper {
	
	private Page page;
	
	public marriageOrganicHelper(Page page) {
		this.page =page;
	}
	
	public void completedonationflow() {
		marriageOrganicPersonalDetailsPage mp= new marriageOrganicPersonalDetailsPage(page);
			mp.EnterFirstname();
			mp.EnterLasttname();
			mp.EnterEmail();
			mp.EnterPhonenumber();
			mp.Selectcitizenship();
		//	mp.Select80GTax();
			mp.Selectcountry();
			mp.Selectstate();
			mp.Entertcity();
			mp.EnterAddress();
			mp.EnterPincode();
			mp.Enterpersonhonoured();
			mp.Enterdateodoccasion();
			mp.EnterPan();
			mp.Submit();
		
	}

}
