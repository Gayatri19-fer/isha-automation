package org.isha.automation.test.GeneralContribute;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organicotppage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpersonaldetailsPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspersonalpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.testng.annotations.Test;


import junit.framework.Assert;

public class Generalcorpusfund extends BaseTest{
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void generalcorpuseflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/isha-foundation-general-corpus-fund/donate");
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
		og.Selectcountry();
		og.Selectstate();
		og.Entertcity();
		og.EnterAddress();
		og.EnterPincode();
		og.EnterPan();
		og.Submit();
		Organicotppage OTP = new Organicotppage(page);
		OTP.getotp();
		Fetchotp lo = new Fetchotp(page);
		String email = "kirti@yopmail.com";  // your Outlook email
		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		OTP.enterotp(otp);
		OTP.verify();
		OrganicpaymentPage OPM = new OrganicpaymentPage(page);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPM.paymentselect();			// for select payment option and cancel payment 
	//	OPM.FailInd();
		OPM.payucancle();
		OrganiccancelPage OC = new OrganiccancelPage(page);
	//	Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
		
	}

}
