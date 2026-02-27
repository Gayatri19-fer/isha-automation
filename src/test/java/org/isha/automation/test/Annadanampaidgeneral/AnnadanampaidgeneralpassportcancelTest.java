package org.isha.automation.test.Annadanampaidgeneral;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalDonatePage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.PersonaldetailsPage;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Fetchotp;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnadanampaidgeneralpassportcancelTest extends BaseTest {
	@Test(groups= {"sanity","auth"},retryAnalyzer = Retry.class)
	public void paidgeneralpassflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/iyc-annadanam-pc"); 
		generalDonatePage GP = new generalDonatePage(page);
		GP.Enteramount();
		GP.clickondonate();
		PersonaldetailsPage gp = new PersonaldetailsPage(page);
		gp.EnterFirstname();
		gp.EnterLasttname();
		gp.EnterEmail();
		gp.EnterPhonenumber();
		gp.Selectcitizenship();
		gp.Select80GTax();
		gp.Selectothercountry();
		gp.Entertcity();
		gp.EnterAddress();
		gp.EnterPincode();
		gp.Enteroccasion();
		gp.Enterdateodoccasion();
		gp.Enterpersonhonoured();
		gp.EnterPan();
		gp.Submit();
		Otppage BO = new Otppage(page);
		BO.getotp();
		Fetchotp LO = new Fetchotp(page);
		String email = "anuradha@yopmail.com"; 
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		BO.enterotp(otp);
		BO.verify();
		//GPM.passprotflowcancleplaywright();
		//	GPM.Cancletansaction();    // for cancel click and failed
		//GPM.paymentselect();		// for select payment option and cancel payment 
	//	GPM.passprotflowcancleplaywright();
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.cancelPassport();
		Cancelpage GC = new Cancelpage(page);
		String expected = ConfigReader.get("payment.expected");

		if (expected.equalsIgnoreCase("cancel")) {
		    Assert.assertTrue(GC.iscanclePageOpen());
		} else {
		    Assert.assertTrue(GC.isfailedPageOpen());
		}
	//	Assert.assertTrue(GC.isfailedPageOpen()); 	// for cancel click and failed
	//	Assert.assertTrue(GC.iscanclePageOpen());	// for select payment option and verify cancel page
		GC.canclemsg();
		System.out.println(GC.getPageUrl());
	}

}
