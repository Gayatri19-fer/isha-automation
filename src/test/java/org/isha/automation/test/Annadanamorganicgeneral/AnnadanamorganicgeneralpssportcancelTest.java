package org.isha.automation.test.Annadanamorganicgeneral;

import java.util.List;
import org.isha.automation.basetest.Retry;
import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpersonaldetailsPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organicotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import junit.framework.Assert;

public class AnnadanamorganicgeneralpssportcancelTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicgeneralpassflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam");
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
		Organicotppage go = new Organicotppage(donatePage);
		go.getotp();
		Fetchotp lo = new Fetchotp(page);
		String email = "anuradha@yopmail.com";  // your Outlook email

		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		go.enterotp(otp);
		go.verify();
		OrganicpaymentPage OPP = new OrganicpaymentPage(donatePage);
		OPP.cancleplaywright();
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
		//OPP.paymentselect();			// for select payment option and cancel payment 
		OrganiccancelPage OC = new OrganiccancelPage(donatePage);
		Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		System.out.println(OC.getPageUrl());
		
		
	}

}
