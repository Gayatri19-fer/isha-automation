package org.isha.automation.test.SMOnetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.iso.IV.SM.SMCanclePage;
import org.ishafoundation.pages.iso.IV.SM.SMDonatepage;
import org.ishafoundation.pages.iso.IV.SM.SMHelperPgae;
import org.ishafoundation.pages.iso.IV.SM.SMPaymentpage;
import org.ishafoundation.pages.iso.IV.SM.SMPersonaldetailspage;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SMpassportcancelTest extends BaseTest{
	@Test(groups= {"sanity"},retryAnalyzer = Retry.class)
		public void skipaealoetimeflow() {
		page.navigate("https://consciousplanet.org/en/isha-vidhya/skip-a-meal");
		SMDonatepage SMD = new SMDonatepage(page);
		SMD.Enteramount();
	//	SMD.clickcontinue();
		
		SMPersonaldetailspage SMP = new SMPersonaldetailspage(page);
		SMP.entername();
		SMP.EnterLasttname();
		SMP.EnterEmail();
		SMP.EnterPhonenumber();
		SMP.Selectcitizenship();
		SMP.Select80GTax();
		SMP.Selectothercountry();
		SMP.Entertcity();
		SMP.EnterAddress();
		SMP.EnterPincode();
		SMP.EnterPan();
		SMP.Submit();
		
		SMPaymentpage SMPP = new SMPaymentpage(page);
		SMPP.passprotflowcancleplaywright();
		//SMPP.clickoncancel();		// for cancel click and failed
	//	SMPP.paymentselect();		// for select payment option and cancel payment 
		SMCanclePage SMC = new SMCanclePage(page);
		Assert.assertTrue(SMC.iscanclePageOpen()); // for select payment option and verify cancel page
	//	Assert.assertTrue(SMC.isfailedPageOpen()); // for cancel click and failed
		SMC.canclemsg();
		SMC.getPageUrl();
	}

}
