package org.isha.automation.test.Annadanampaidbirthday;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdayLandingPage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.PersonaldetailsPage;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Fetchotp;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnadanampaidbirthdaypassportcancleTest extends BaseTest{
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void paidbirthadypassflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/iyc-annadanam-pc"); 
		birthdayLandingPage BD = new birthdayLandingPage(page);
		BD.clickondonate();
		PersonaldetailsPage BPP = new PersonaldetailsPage(page);
		BPP.EnterFirstname();
		BPP.EnterLasttname();
		BPP.EnterEmail();
		BPP.EnterPhonenumber();
		BPP.Selectcitizenship();
		BPP.Select80GTax();
		BPP.Selectothercountry();
		BPP.Entertcity();
		BPP.EnterAddress();
		BPP.EnterPincode();
		BPP.Enterpersonhonoured();
		BPP.Enterdateodoccasion();
		BPP.EnterPan();
		BPP.Submit();
		Otppage BO = new Otppage(page);
		BO.getotp();
		Fetchotp LO = new Fetchotp(page);
		String email = "anuradha@yopmail.com"; 
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		BO.enterotp(otp);
		BO.verify();
	//	birthdaypaymentPage BP = new birthdaypaymentPage(page);
		//BP.passprotflowcancleplaywright();
		//BP.Cancleclick();		// for cancel click and failed
		//BP.paymentselect();		// for select payment option and cancel payment 
	//	BP.passprotflowcancleplaywright();
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.cancelPassport();
		Cancelpage BC = new Cancelpage(page);
		String expected = ConfigReader.get("payment.expected");

		if (expected.equalsIgnoreCase("cancel")) {
		    Assert.assertTrue(BC.iscanclePageOpen());
		} else {
		    Assert.assertTrue(BC.isfailedPageOpen());
		}
	
		//Assert.assertTrue(BC.iscanclePageOpen());	// for select payment option and verify cancel page
		//Assert.assertTrue(BC.isfailedPageOpen());	// for cancel click and failed
		BC.canclemsg();
		System.out.println(BC.getPageUrl());
		
	}

}
