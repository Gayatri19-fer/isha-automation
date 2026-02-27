package org.isha.automation.test.Annadanamorganicmarriage;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpersonaldetailsPage;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Fetchotp;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.annotations.Test;


import com.microsoft.playwright.Page;


import junit.framework.Assert;

public class AnnadanamorganicmarriagecancelTest extends BaseTest{
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void organicmarriageflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/iyc-annadanam");
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
		Otppage MO = new Otppage(donatePage);
		MO.getotp();
		Fetchotp LO = new Fetchotp(donatePage);
		String email = "anuradha@yopmail.com";  // your Outlook email
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		MO.enterotp(otp);
		MO.verify();
	//	OrganicpaymentPage MP = new OrganicpaymentPage(donatePage);
	//	MP.Cancleclick();		// for cancel click and failed
	//	MP.paymentselect();		// for select payment option and cancel payment 
		PaymentPage payment = PaymentPageFactory.get(donatePage, false);
	//	payment.FailInd();
		payment.cancleplaywright();
		Cancelpage MC = new Cancelpage(donatePage);
	//	Assert.assertTrue(MC.iscanclePageOpen());  // for select payment option and verify cancel page
		 Assert.assertTrue(MC.isfailedPageOpen()); // for cancel click and failed
		//Assert.assertTrue("Cancel page did not load. Current URL: " + page.url(), IVC.isPageOpen());
		MC.canclemsg();
		MC.getPageUrl();
	}

}
