package org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BirthdaycorpusOtppage {
	
	private Page page;
	
	public BirthdaycorpusOtppage(Page page) {
		this.page =page;
	}
	
    public void getotp() {
    	page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get OTP")).click();
    }


}
