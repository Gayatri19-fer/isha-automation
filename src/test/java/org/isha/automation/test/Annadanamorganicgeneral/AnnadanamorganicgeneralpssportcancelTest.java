package org.isha.automation.test.Annadanamorganicgeneral;

import java.util.List;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpersonaldetailsPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class AnnadanamorganicgeneralpssportcancelTest extends BaseTest {
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void organicgeneralpassflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+"/en/contribute/iyc-annadanam");
		OrganicLandingPage OL = new OrganicLandingPage(page);
		Page donatePage = page.context().waitForPage(
		()->
		{
			OL.generalflow();
		}
		);
		OrganicDonatePage OD = new OrganicDonatePage(donatePage);
		OD.SelectAmount();
		OD.Continue();
		OrganicpersonaldetailsPage OP = new OrganicpersonaldetailsPage(donatePage);
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
		Otppage go = new Otppage(donatePage);
		go.getotp();
		Fetchotp lo = new Fetchotp(donatePage);
		String email = "kirti@yopmail.com";  // your Outlook email

		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		go.enterotp(otp);
		go.verify();
	//	OrganicpaymentPage OPP = new OrganicpaymentPage(donatePage);
	//	OPP.cancleplaywright();
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
		//OPP.paymentselect();			// for select payment option and cancel payment 
		PaymentPage payment = PaymentPageFactory.get(donatePage, false);
		//payment.cancelPassport();	//for uat
		payment.ccavenue();      // for prod
		Cancelpage GC = new Cancelpage(donatePage);
		String expected = ConfigReader.get("payment.expected");

		if (expected.equalsIgnoreCase("cancel")) {
		    Assert.assertTrue(GC.iscanclePageOpen());
		} else {
		    Assert.assertTrue(GC.isfailedPageOpen());
		}
		//OrganiccancelPage OC = new OrganiccancelPage(donatePage);
	//	Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		GC.canclemsg();
		System.out.println(GC.getPageUrl());
		
		
	}

}
