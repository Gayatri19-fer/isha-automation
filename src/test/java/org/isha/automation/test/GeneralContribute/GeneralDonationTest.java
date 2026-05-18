package org.isha.automation.test.GeneralContribute;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organicotppage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspersonalpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.annotations.Test;


import junit.framework.Assert;

public class GeneralDonationTest extends BaseTest{
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void generaldonationflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/isha-foundation-general-donation/donate");
		OrganicDonatePage OD = new OrganicDonatePage(page);
		OD.Enteramount();
		OD.Continue();
		Corpuspersonalpage og = new Corpuspersonalpage(page);
		og.EnterFirstname();
		og.EnterLasttname();
		og.EnterEmail();
		og.EnterPhonenumber();
		og.Selectcitizenship();
		og.Select80GTax();
		og.Selectcountry();
		og.Selectstate();
		og.Entertcity();
		og.EnterAddress();
		og.EnterPincode();
		og.EnterPan();
		og.Submit();
		PaymentPage payment = PaymentPageFactory.get(page, false);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPM.paymentselect();			// for select payment option and cancel payment 
	//	OPM.FailInd();
		payment.payucancle();   // for prod 
	//	payment.cancleplaywright();  // for uat
		OrganiccancelPage OC = new OrganiccancelPage(page);
	//	Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
		
	}

}
