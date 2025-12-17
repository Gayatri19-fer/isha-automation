package org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday;

import com.microsoft.playwright.Page;

public class birthdayHelper {
	private Page page;
	
	
	public birthdayHelper(Page page) {
		this.page = page;
	}
	
	public void completeflow() {
		birthdaypersonalPage BP = new birthdaypersonalPage(page); 
		BP.EnterFirstname();
		BP.EnterLasttname();
		BP.EnterEmail();
		BP.EnterPhonenumber();
		BP.Selectcitizenship();
		BP.Select80GTax();
		BP.Selectcountry();
		BP.Selectstate();
		BP.Entertcity();
		BP.EnterAddress();
		BP.EnterPincode();
		BP.Enterpersonhonoured();
		BP.Enterdateodoccasion();
		BP.EnterPan();
		BP.Submit();
		
	}
	

}
