package org.ishafoundation.pages.Sadhguru.Organiccorpus.general;

import com.microsoft.playwright.Page;

public class generalcorpusotppage {
	
	private Page page;
	
	public generalcorpusotppage(Page page) {
		this.page =page;
	}
	
	private String getotp = "#get-otp-btn";
	

    public void getotp() {
        page.locator(getotp).click(); // or another button if OTP submit is different
    }

}
