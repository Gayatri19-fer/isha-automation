package org.isha.automation.test.Annadanamorganicgeneral;

import java.util.List;
import org.isha.automation.basetest.Retry;
import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicpersonaldetailsPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalorganiccorpusotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.LoginRecurringpage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import junit.framework.Assert;

public class AnnadanamorganicgeneralpssportcancelTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam/donate");
	/*	generalOrganicLandingPage OL = new generalOrganicLandingPage(page);
		Page donatePage = page.waitForPopup(() -> {
		    OL.donateclick();  // This click opens the new tab
		});
		donatePage.waitForSelector("#amt-block", 
			    new Page.WaitForSelectorOptions().setTimeout(20000)
			);

			// Then wait for the 500 label
			donatePage.locator("label:has-text('700')").waitFor(new Locator.WaitForOptions()
			    .setState(WaitForSelectorState.VISIBLE)
			    .setTimeout(15000)
			);
	*/
		generalOrganicDonatePage OD = new generalOrganicDonatePage(page);
		OD.SelectAmount();
		OD.Continue();
		generalOrganicpersonaldetailsPage OP = new generalOrganicpersonaldetailsPage(page);
		OP.EnterFirstname();
		OP.EnterLasttname();
		OP.EnterEmail();
		OP.EnterPhonenumber();
		OP.Selectcitizenship();
		OP.Select80GTax();
		OP.Selectothercountry();
		OP.Entertcity();
		OP.EnterAddress();
		OP.EnterPincode();
		OP.Enteroccasion();
		OP.Enterdateodoccasion();
		OP.Enterpersonhonoured();
		OP.EnterPan();
		OP.Submit();
		generalorganiccorpusotppage go = new generalorganiccorpusotppage(page);
		go.getotp();
		LoginRecurringpage lo = new LoginRecurringpage(page);
		String email = "anuradha@yopmail.com";  // your Outlook email

		lo.fetchAndEnterOtpFromYopmail(email);
		generalOrganicpaymentPage OPP = new generalOrganicpaymentPage(page);
		OPP.cancleplaywright();
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
		//OPP.paymentselect();			// for select payment option and cancel payment 
		generalOrganiccancelPage OC = new generalOrganiccancelPage(page);
		Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		System.out.println(OC.getPageUrl());
		
		
	}

}
