package org.isha.automation.test.msronetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.msr.MsrCanclePage;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrPaymentPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MsrpaidTest extends BaseTest{
	  @Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	    public void MsrpaidTestflow() {
	        page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution/donate-pc");
	        MsrDonationPage msrd = new MsrDonationPage(page);
	        msrd.Entercustomeamount();
	        msrd.Donationbuttonclick2();
	        MsrPersonalDetailsPage msrpersonal = new MsrPersonalDetailsPage(page);
	        msrpersonal.EnterFirstname();
	        msrpersonal.EnterLasttname();
	        msrpersonal.EnterEmail();
	        msrpersonal.EnterPhonenumber();
	        msrpersonal.EnterPINnumber();
	        msrpersonal.EnterAddress();
	        msrpersonal.enterpan();
	        msrpersonal.Selectcheckbox();
	        msrpersonal.paysecuarly();
	        PaymentPage payment = PaymentPageFactory.get(page, false);
	        payment.MSRccavenue();
	    	Cancelpage IVC =  new Cancelpage(page);
	    	Assert.assertTrue(IVC.iscanclePageOpen());
	    	IVC.canclemsg();
	    	IVC.getPageUrl();
	       
	    }

}
