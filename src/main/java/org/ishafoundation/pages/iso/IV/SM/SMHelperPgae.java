package org.ishafoundation.pages.iso.IV.SM;

import com.microsoft.playwright.Page;

public class SMHelperPgae {
	
	private Page page;
	
	public SMHelperPgae(Page page) {
		this.page = page;
	}
	
	public void completedonationflow() {
		SMPersonaldetailspage SMP = new SMPersonaldetailspage(page);
		SMP.entername();
		SMP.EnterLasttname();
		SMP.EnterEmail();
		SMP.EnterPhonenumber();
		SMP.Selectcitizenship();
		SMP.Select80GTax();
		SMP.Selectcountry();
		SMP.Selectstate();
		SMP.Entertcity();
		SMP.EnterAddress();
		SMP.EnterPincode();
		SMP.EnterPan();
		SMP.Submit();
		
	}
	
	

}
