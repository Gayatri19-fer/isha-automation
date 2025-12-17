package org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage;

import com.microsoft.playwright.Page;

public class marriageOrganicOtpPage {
	private Page page;
	
	public marriageOrganicOtpPage(Page page) {
		this.page =page;
	}
	
	private String getotp = "#get-otp-btn";
	

    public void getotp() {
        page.locator(getotp).click(); // or another button if OTP submit is different
    }


}
