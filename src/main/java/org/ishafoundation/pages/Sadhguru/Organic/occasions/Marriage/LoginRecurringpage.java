package org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage;

import org.ishafoundation.pages.iso.IV.Recurring.YopmailutilityPage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginRecurringpage {
	
	private Page page;
	
	
	public LoginRecurringpage(Page page) {
		this.page =page;
		// added below line 15 and pass this Browser browser
		
	}
	
	private String enterfetchotp = "#verify-otp";
	private String verify = "input[value='Verify']";
	private String pay = "#payment";
			
    public String getOtpFromYopmail(String email, int maxWaitSec, int pollInterval) {
        // Instantiate Yopmail utility with the same page
        YopmailutilityPage yop = new YopmailutilityPage(page);

        // Open inbox for the email's local-part
        String localPart = email.split("@")[0];
        yop.openInbox(localPart);

        // Wait and return OTP
        return yop.waitForOtp(maxWaitSec, pollInterval);
    }
	
    public void enterOTP(String otp) {
        page.fill(enterfetchotp, otp);
    }

    public void submitOTP() {
        page.locator(verify).click(); // or another button if OTP submit is different
    }
    public void paysecurly() {
        page.locator(pay).click();
    }
    
    public void fetchAndEnterOtpFromYopmail(String email) {
    	try (Playwright playwright2 = Playwright.create()) {
            Browser tempBrowser = playwright2.chromium().launch(new BrowserType.LaunchOptions()
            		.setHeadless(false));
            Page yopPage = tempBrowser.newPage();
        YopmailutilityPage yop = new YopmailutilityPage(yopPage);

        // Extract local part before @
        String localPart = email.split("@")[0];
        yop.openInbox(localPart);

        // Wait and fetch OTP
        int maxWait = 120; // 2 minutes
        int pollInterval = 5; // seconds
        String otp = yop.waitForOtp(maxWait, pollInterval);
        System.out.println("Fetched OTP: " + otp);

        // Close Yopmail tab
        yopPage.close();
        tempBrowser.close();

        // Switch focus back to login page
        page.bringToFront();

        // Enter and submit OTP
        page.fill(enterfetchotp, otp);
        page.locator(verify).click();
        page.locator(pay).click();
    	}
    }
	
	
	

}
