package org.isha.automation.test.Annadanamorganicgeneral;

import java.util.List;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalorganiccorpusotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.LoginRecurringpage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import junit.framework.Assert;

public class AnnadanamorganicgeneralcancelTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam/donate");

		generalOrganicDonatePage OD = new generalOrganicDonatePage(page);
		OD.SelectAmount();
		OD.Continue();
		generalOrganichelper OP = new generalOrganichelper(page);
		OP.completeflow();
		generalorganiccorpusotppage OTP = new generalorganiccorpusotppage(page);
		OTP.getotp();
		LoginRecurringpage lo = new LoginRecurringpage(page);
		String email = "anuradha@yopmail.com";  // your Outlook email

		lo.fetchAndEnterOtpFromYopmail(email);
		generalOrganicpaymentPage OPP = new generalOrganicpaymentPage(page);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
		OPP.paymentselect();			// for select payment option and cancel payment 
		generalOrganiccancelPage OC = new generalOrganiccancelPage(page);
		Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
		
	}

}
