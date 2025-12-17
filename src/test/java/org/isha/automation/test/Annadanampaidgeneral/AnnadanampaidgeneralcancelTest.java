package org.isha.automation.test.Annadanampaidgeneral;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.LoginRecurringpage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday.birthdayOtpPage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalDonatePage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalHelper;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalcancelPage;
import org.ishafoundation.pages.Sadhguru.Paidannadanam.general.generalpaymentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnadanampaidgeneralcancelTest extends BaseTest {
	@Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	public void annadanampaidgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam-pc"); 
		generalDonatePage GP = new generalDonatePage(page);
		GP.Enteramount();
		GP.clickondonate();
		generalHelper GH = new generalHelper(page);
		GH.completedonationfow();
		birthdayOtpPage BO = new birthdayOtpPage(page);
		BO.getotp();
		LoginRecurringpage LO = new LoginRecurringpage(page);
		String email = "anuradha@yopmail.com"; 
		LO.fetchAndEnterOtpFromYopmail(email);
		generalpaymentPage GPM = new generalpaymentPage(page);
	//	GPM.Cancletansaction();    // for cancel click and failed
		GPM.paymentselect();		// for select payment option and cancel payment 
		generalcancelPage GC = new generalcancelPage(page);
	//	Assert.assertTrue(GC.isfailedPageOpen()); 	// for cancel click and failed
		Assert.assertTrue(GC.iscanclePageOpen());	// for select payment option and verify cancel page
		GC.canclemsg();
		System.out.println(GC.getPageUrl());
	}

}
