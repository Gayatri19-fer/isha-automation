package org.isha.automation.test.IVrecurrig;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.iso.IV.Recurring.IVDonationHelper;
import org.ishafoundation.pages.iso.IV.Recurring.IVRecurringDoantePage;
import org.ishafoundation.pages.iso.IV.Recurring.IVRecurringPersonalPage;
import org.ishafoundation.pages.iso.IV.Recurring.LoginRecurringpage;
import org.ishafoundation.pages.iso.IV.Recurring.Outlookutility;
import org.ishafoundation.pages.iso.IV.Recurring.YopmailutilityPage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class IVRecurringcacleTest extends BaseTest{
	
	
	@Test(groups= {"sanity"})
	public void IVrecurringflow2() {
		page.navigate("https://consciousplanet.org/en/isha-vidhya/donate"); 
		   IVRecurringDoantePage dp = new IVRecurringDoantePage(page);
		   dp.Entercustomeamount();
		   dp.Enteryear();
		   dp.cotinue();
		   LoginRecurringpage lp = new LoginRecurringpage(page, browser);
		   String email = "anuradha@yopmail.com";  // your Outlook email
	    //    String appPassword = "GayBFer@2025"; // Outlook app password
		   lp.EnterEmail(email);
		   lp.sendOTP();
		 lp.fetchAndEnterOtpFromYopmail(email);
		   IVDonationHelper dh = new IVDonationHelper(page);
		   dh.completeDonationFlow();
	}


}
