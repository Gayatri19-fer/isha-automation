package org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday;

import com.microsoft.playwright.Page;

public class BirthdaycorpusHelperpage {
	
	private Page page;

	
	public BirthdaycorpusHelperpage(Page page) {
		this.page =page;
	}
	
	public void completeflow() {
	Birthdaycorpuspersonalpage BL = new Birthdaycorpuspersonalpage(page);	
	BL.entername();
	BL.enterlastname();
	BL.enteremail();
	BL.entermobile();
	BL.Selectcitizenship();
	BL.Selectcountry();
	BL.Selectstate();
	BL.entercity();
	BL.EnterAddress();
	BL.EnterPincode();
	BL.Enteroccasion();
	BL.Enterdateodoccasion();
	BL.EnterPan();
	BL.Submit();
	
	}

}
