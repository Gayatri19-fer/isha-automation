package org.isha.automation.test.Annadanampaidbirthday;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.LoginRecurringpage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdayDonatePage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdayHelper;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdayLandingPage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdayOtpPage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdaycancelPage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdaypaymentPage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdaypersonalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnadanampaidbirthdaypassportcancleTest extends BaseTest{
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanampaidbirthadyflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam-pc"); 
		birthdayLandingPage BD = new birthdayLandingPage(page);
		BD.clickondonate();
		birthdaypersonalPage BPP = new birthdaypersonalPage(page);
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
		birthdayOtpPage BO = new birthdayOtpPage(page);
		BO.getotp();
		LoginRecurringpage LO = new LoginRecurringpage(page);
		String email = "anuradha@yopmail.com"; 
		LO.fetchAndEnterOtpFromYopmail(email);
		birthdaypaymentPage BP = new birthdaypaymentPage(page);
		//BP.passprotflowcancleplaywright();
		//BP.Cancleclick();		// for cancel click and failed
		//BP.paymentselect();		// for select payment option and cancel payment 
		BP.passprotflowcancleplaywright();
		birthdaycancelPage BC = new birthdaycancelPage(page);
		Assert.assertTrue(BC.iscanclePageOpen());	// for select payment option and verify cancel page
		//Assert.assertTrue(BC.isfailedPageOpen());	// for cancel click and failed
		BC.canclemsg();
		System.out.println(BC.getPageUrl());
		
	}

}
