package org.isha.automation.test.Annadanampaidgeneral;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalDonatePage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalHelper;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalpaymentPage;
import org.ishafoundation.pages.common.Cancelpgae;
import org.ishafoundation.pages.common.Fetchotp;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnadanampaidgeneralcancelTest extends BaseTest {
	@Test(groups= {"sanity","auth"},retryAnalyzer = Retry.class)
	public void paidgeneralflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/iyc-annadanam-pc"); 
		generalDonatePage GP = new generalDonatePage(page);
		GP.Enteramount();
		GP.clickondonate();
		generalHelper GH = new generalHelper(page);
		GH.completedonationfow();
		Otppage BO = new Otppage(page);
		BO.getotp();
		Fetchotp LO = new Fetchotp(page);
		String email = "anuradha@yopmail.com"; 
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		BO.enterotp(otp);
		BO.verify();
	//	generalpaymentPage GPM = new generalpaymentPage(page);
	//	GPM.Cancletansaction();    // for cancel click and failed
	//	GPM.paymentselect();		// for select payment option and cancel payment
		PaymentPage payment = PaymentPageFactory.get(page);
		payment.FailInd();
		Cancelpgae GC = new Cancelpgae(page);
		Assert.assertTrue(GC.isfailedPageOpen()); 	// for cancel click and failed
	//	Assert.assertTrue(GC.iscanclePageOpen());	// for select payment option and verify cancel page
		GC.canclemsg();
		System.out.println(GC.getPageUrl());
	}

}
