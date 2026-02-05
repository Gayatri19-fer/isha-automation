package org.isha.automation.test.msronetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.msr.MsrCanclePage;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrPaymentPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MsrpaidTest extends BaseTest{
	  @Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	    public void MahashivratriOntimeflow() {
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
	        MsrPaymentPage msrpayment = new MsrPaymentPage(page);
	      //  msrpayment.cancleplaywright();
	        msrpayment.Canclepaymentclick();  // for cancel click and cancel
	       msrpayment.CancleTransaction();  //for cancel click and cancel
	        MsrCanclePage canclepage = new MsrCanclePage(page);
	        Assert.assertTrue(canclepage.iscanclePageOpen());  // for cancel click and cancel
	      //Assert.assertTrue(canclepage.isPageOpened());
	      canclepage.canclemsg();
	      canclepage.getPageUrl();
	       
	    }

}
