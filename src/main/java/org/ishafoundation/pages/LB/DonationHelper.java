package org.ishafoundation.pages.LB;

import com.microsoft.playwright.Page;

public class DonationHelper {
	private Page page;
	
	public DonationHelper(Page page) {
		this.page =page;
	}
	
	public void completedonationflow() {
		LBPersonalePage DD = new LBPersonalePage(page);
		DD.Entername();
		DD.Enterlastname();
		DD.Enteremail();
		DD.Enterenumbar();
		DD.Selectstate();
		DD.Entertcity();
		DD.Entertaddress();
		DD.Entertpin();
		DD.checkbox();
		DD.paysecuarly();
	}

}
