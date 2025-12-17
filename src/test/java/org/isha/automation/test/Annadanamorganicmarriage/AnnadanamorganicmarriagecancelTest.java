package org.isha.automation.test.Annadanamorganicmarriage;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;

import org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage.LoginRecurringpage;
import org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage.marriageOrganicCancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage.marriageOrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage.marriageOrganicHelper;
import org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage.marriageOrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage.marriageOrganicOtpPage;
import org.ishafoundation.pages.Sadhguru.Organic.occasions.Marriage.marriageOrganicPaymentPage;
import org.testng.annotations.Test;


import com.microsoft.playwright.Page;


import junit.framework.Assert;

public class AnnadanamorganicmarriagecancelTest extends BaseTest{
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicmarriageflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam");
		marriageOrganicLandingPage ML = new marriageOrganicLandingPage(page);
		Page donatePage = page.waitForPopup(() -> {
		    ML.clicklernmore();  // This click opens the new tab
		});
		donatePage.waitForSelector("#amt-block", 
			    new Page.WaitForSelectorOptions().setTimeout(20000)
			);

			// Then wait for the 11,000 label
		//	donatePage.locator("label:has-text('11,000')").waitFor(new Locator.WaitForOptions()
		//	    .setState(WaitForSelectorState.VISIBLE)
		///	    .setTimeout(15000)
		//	);
		
		marriageOrganicDonatePage MD = new marriageOrganicDonatePage(donatePage);
	//	MD.Enteramount();
		MD.selectamount();
		MD.countinuebtnclick();
		marriageOrganicHelper MH = new marriageOrganicHelper(donatePage);
		MH.completedonationflow();
		marriageOrganicOtpPage MO = new marriageOrganicOtpPage(donatePage);
		MO.getotp();
		LoginRecurringpage LO = new LoginRecurringpage(donatePage);
		String email = "anuradha@yopmail.com";  // your Outlook email
		LO.fetchAndEnterOtpFromYopmail(email);
		marriageOrganicPaymentPage MP = new marriageOrganicPaymentPage(donatePage);
	//	MP.Cancleclick();		// for cancel click and failed
		MP.paymentselect();		// for select payment option and cancel payment 
		marriageOrganicCancelPage MC = new marriageOrganicCancelPage(donatePage);
		Assert.assertTrue(MC.iscanclePageOpen());  // for select payment option and verify cancel page
		// Assert.assertTrue(IVC.isfailedPageOpen()); // for cancel click and failed
		//Assert.assertTrue("Cancel page did not load. Current URL: " + page.url(), IVC.isPageOpen());
		MC.canclemsg();
		MC.getPageUrl();
	}

}
