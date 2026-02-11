package org.ishafoundation.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Otppage {
	
	private Page page;
	
	public Otppage(Page page) {
		this.page =page;
	}
	
	private String getotp = "#get-otp-btn";
	

    public void getotp() {
       // page.locator(getotp).click(); // or another button if OTP submit is different
        Locator getOtp = page.locator(getotp);

        getOtp.waitFor();  // visible
        page.waitForCondition(() -> getOtp.isEnabled()); // enabled

        getOtp.click();
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
