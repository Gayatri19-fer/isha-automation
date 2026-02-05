package org.ishafoundation.pages.Sadhguru.Organic.general;

import com.microsoft.playwright.Locator;
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
	public void enterotp(String otp) {
		Locator otpBox = page.getByPlaceholder("Enter OTP Here");
		otpBox.waitFor();
		otpBox.fill(otp);
	}
	public void verify() {
		page.locator("[name='verify-otp-btn']").click();
		page.locator("//button[@id='payment']").click();
	}

}


