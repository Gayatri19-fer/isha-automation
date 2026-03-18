package org.isha.automation.test.SMOnetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.iso.IV.SM.SMCanclePage;
import org.ishafoundation.pages.iso.IV.SM.SMDonatepage;
import org.ishafoundation.pages.iso.IV.SM.SMHelperPgae;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SMcancelTest extends BaseTest{
	@Test(groups= {"sanity","auth"},retryAnalyzer = Retry.class)
		public void skipaealoetimeflow() {
		page.navigate(ConfigReader.get("consciousplanet.url")+"/en/isha-vidhya/skip-a-meal");
		SMDonatepage SMD = new SMDonatepage(page);
		SMD.Enteramount();
		SMD.clickcontinue();
		SMHelperPgae SMP = new SMHelperPgae(page);
		SMP.completedonationflow();
	//	SMPaymentpage SMPP = new SMPaymentpage(page);
		//SMPP.clickoncancel();		// for cancel click and failed
	//	SMPP.paymentselect();		// for select payment option and cancel payment 
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.FailInd();  //for prod
	//	payment.cancleplaywright(); // for uat
		Cancelpage SMC = new Cancelpage(page);
		//Assert.assertTrue(SMC.iscanclePageOpen()); // for select payment option and verify cancel page
		Assert.assertTrue(SMC.isfailedPageOpen()); // for cancel click and failed
		SMC.canclemsg();
		SMC.getPageUrl();
	}

}
