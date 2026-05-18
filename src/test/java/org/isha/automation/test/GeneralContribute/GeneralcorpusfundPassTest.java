package org.isha.automation.test.GeneralContribute;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organicotppage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpersonaldetailsPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspersonalpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GeneralcorpusfundPassTest extends BaseTest{
	
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void generalcorpusfundpassflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/isha-foundation-general-corpus-fund/donate");
		OrganicDonatePage OD = new OrganicDonatePage(page);
		OD.Enteramount2();
		OD.Continue();
		OrganicpersonaldetailsPage og = new OrganicpersonaldetailsPage(page);
		og.EnterFirstname();
		og.EnterLasttname();
		og.EnterEmail();
		og.EnterPhonenumber();
		og.Selectcitizenship();
		og.Select80GTax();
		og.Selectothercountry();
		og.Entertcity();
		og.EnterAddress();
		og.EnterPincode();
		og.EnterPan();
		og.Submit();
		Otppage MO = new Otppage(page);
		MO.getotp();
		Fetchotp LO = new Fetchotp(page);
		String email = "kirti@yopmail.com";  // your Outlook email
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		MO.enterotp(otp);
		MO.verify();
		PaymentPage payment = PaymentPageFactory.get(page, false);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPM.paymentselect();			// for select payment option and cancel payment 
	//	OPM.FailInd();
		payment.cancleplaywright();  // for prod
		payment.ccavenue();  // for uat need to to check for uat
		Cancelpage OC =  new Cancelpage(page);
		Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
	//	Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
	}

}
