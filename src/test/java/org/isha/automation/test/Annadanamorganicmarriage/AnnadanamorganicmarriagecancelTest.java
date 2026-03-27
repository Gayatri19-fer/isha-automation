package org.isha.automation.test.Annadanamorganicmarriage;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organic.general.FetchOtppage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organicotppage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpersonaldetailsPage;

import org.testng.annotations.Test;


import com.microsoft.playwright.Page;


import junit.framework.Assert;

public class AnnadanamorganicmarriagecancelTest extends BaseTest{
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicmarriageflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam");
		OrganicLandingPage OP = new OrganicLandingPage(page);
		Page donatePage = page.context().waitForPage(
		()->
		{
			OP.weddingflow();
		}
		);
		OrganicDonatePage MD = new OrganicDonatePage(donatePage);
		MD.Enteramount();
		MD.Continue();
		OrganicpersonaldetailsPage MH = new OrganicpersonaldetailsPage(donatePage);
		MH.EnterFirstname();
		MH.EnterLasttname();
		MH.EnterPhonenumber();
		MH.EnterEmail();
		MH.Selectcitizenship();
		MH.Select80GTax();
		MH.Selectcountry();
		MH.Selectstate();
		MH.Entertcity();
		MH.EnterAddress();
		MH.EnterPincode();
		MH.Enterpersonhonoured();
		MH.Enterdateodoccasion();
		MH.EnterPan();
		MH.Submit();
		Organicotppage MO = new Organicotppage(donatePage);
		MO.getotp();
		FetchOtppage LO = new FetchOtppage(donatePage);
		String email = "anuradha@yopmail.com";  // your Outlook email
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		MO.enterotp(otp);
		MO.verify();
		OrganicpaymentPage MP = new OrganicpaymentPage(donatePage);
	//	MP.Cancleclick();		// for cancel click and failed
	//	MP.paymentselect();		// for select payment option and cancel payment 
	//	MP.FailInd();
		MP.payucancle();
		OrganiccancelPage MC = new OrganiccancelPage(donatePage);
	//	Assert.assertTrue(MC.iscanclePageOpen());  // for select payment option and verify cancel page
		 Assert.assertTrue(MC.isfailedPageOpen()); // for cancel click and failed
		//Assert.assertTrue("Cancel page did not load. Current URL: " + page.url(), IVC.isPageOpen());
		MC.canclemsg();
		MC.getPageUrl();
	}

}
