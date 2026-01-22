package org.ishafoundation.pages.Sadhguru.Organic.occasions.Birthday;

import com.microsoft.playwright.Page;

public class birthdayOrganicOtpPage {
private Page page;
	
	public birthdayOrganicOtpPage(Page page) {
		this.page =page;
	}
	
	private String getotp = "#get-otp-btn";
	

    public void getotp() {
        page.locator(getotp).click(); // or another button if OTP submit is different
    }

}
