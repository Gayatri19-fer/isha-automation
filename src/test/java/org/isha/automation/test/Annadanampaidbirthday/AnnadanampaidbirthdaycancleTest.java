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

import com.microsoft.playwright.options.LoadState;

public class AnnadanampaidbirthdaycancleTest extends BaseTest{
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void paidbirthadyflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/iyc-annadanam-pc"); 
		System.out.println(page.url());
		birthdayLandingPage BD = new birthdayLandingPage(page);
		page.waitForFunction(
			    "() => document.readyState === 'complete'"
			);
		BD.clickondonate();
		PersonaldetailsPage BP = new PersonaldetailsPage(page);
		BP.EnterFirstname();
		BP.EnterLasttname();
		BP.EnterEmail();
		BP.EnterPhonenumber();
		BP.Selectcitizenship();
		BP.Select80GTax();
		BP.Selectcountry();
		BP.Selectstate();
		BP.Entertcity();
		BP.EnterAddress();
		BP.EnterPincode();
		BP.Enterpersonhonoured();
		BP.Enterdateodoccasion();
		BP.EnterPan();
		BP.Submit();
		Otppage BO = new Otppage(page);
		BO.getotp();
		Fetchotp LO = new Fetchotp(page);
		String email = "anuradha@yopmail.com"; 
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		BO.enterotp(otp);
		BO.verify();
		//birthdaypaymentPage BP = new birthdaypaymentPage(page);
		//BP.Cancleclick();		// for cancel click and failed
		//BP.paymentselect();		// for select payment option and cancel payment 
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.FailInd();
		Cancelpage BC = new Cancelpage(page);
		//Assert.assertTrue(BC.iscanclePageOpen());	// for select payment option and verify cancel page
		Assert.assertTrue(BC.isfailedPageOpen());	// for cancel click and failed
		BC.canclemsg();
		System.out.println(BC.getPageUrl());
		
	}

}
