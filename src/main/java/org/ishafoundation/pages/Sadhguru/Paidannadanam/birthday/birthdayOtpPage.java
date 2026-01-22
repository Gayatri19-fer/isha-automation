package org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday;

import com.microsoft.playwright.Page;

public class birthdayOtpPage {
	
	private Page page;
	
	public birthdayOtpPage(Page page) {
		this.page =page;
	}
	
	 private String getotp = "#get-otp-btn";
	

    public void getotp() {
        page.locator(getotp).click(); // or another button if OTP submit is different
    }

}
