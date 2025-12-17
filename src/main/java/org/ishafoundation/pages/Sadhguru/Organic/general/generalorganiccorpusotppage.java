package org.ishafoundation.pages.Sadhguru.Organic.general;

import com.microsoft.playwright.Page;

public class generalorganiccorpusotppage {
	private Page page;
	
	public generalorganiccorpusotppage(Page page) {
		this.page =page;
	}
	
	private String getotp = "#get-otp-btn";
	

    public void getotp() {
        page.locator(getotp).click(); // or another button if OTP submit is different
    }

}


