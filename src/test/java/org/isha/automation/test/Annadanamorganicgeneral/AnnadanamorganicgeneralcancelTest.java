package org.isha.automation.test.Annadanamorganicgeneral;

import java.util.List;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organicotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import junit.framework.Assert;

public class AnnadanamorganicgeneralcancelTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam");
		OrganicLandingPage OP = new OrganicLandingPage(page);
		Page donatePage = page.context().waitForPage(
		()->
		{
			OP.generalflow();
		}
		);
		donatePage.waitForLoadState(LoadState.NETWORKIDLE);
		OrganicDonatePage OD = new OrganicDonatePage(donatePage);
		OD.SelectAmount();
		OD.Continue();
		Organichelper OPP = new Organichelper(donatePage);
		OPP.completeflow();
		Organicotppage OTP = new Organicotppage(donatePage);
		OTP.getotp();
		Fetchotp lo = new Fetchotp(donatePage);
		String email = "kirti@yopmail.com";  // your Outlook email
		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		OTP.enterotp(otp);
		OTP.verify();
		OrganicpaymentPage OPM = new OrganicpaymentPage(donatePage);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPM.paymentselect();			// for select payment option and cancel payment 
	//	OPM.FailInd();
		OPM.payucancle();
		OrganiccancelPage OC = new OrganiccancelPage(donatePage);
	//	Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
		
	}

}
