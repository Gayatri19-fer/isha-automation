package org.isha.automation.test.msronetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.msr.DonationHelper;
import org.ishafoundation.pages.msr.HeaderLinks;
import org.ishafoundation.pages.msr.MsrCanclePage;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrLandingPage;
import org.ishafoundation.pages.msr.MsrPaymentPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class MSRContributTest extends BaseTest{
	
	  @Test(groups= {"sanity", "auth"},retryAnalyzer = Retry.class)
	    public void MahashivratriOntimeflow() {
	        page.navigate(ConfigReader.get("mahashivarathri.url")+ "/en/mahashivratri-contribution"); 
	 	    MsrLandingPage msrl = new MsrLandingPage(page);
	        msrl.Donationbuttonclick();
	        DonationHelper msrl1 = new DonationHelper(page);
	        msrl1.completeDonationFlow();
	        MsrPaymentPage msrpayment = new MsrPaymentPage(page);
	      //  msrpayment.cancleplaywright();
	     //   msrpayment.Canclepaymentclick();  // for cancel click and cancel
	     //  msrpayment.CancleTransaction();  //for cancel click and cancel
	        PaymentPage payment = PaymentPageFactory.get(page, false);
	        payment.MSRccavenue();
	  //      MsrCanclePage canclepage = new MsrCanclePage(page);
	    //    Assert.assertTrue(canclepage.iscanclePageOpen());  // for cancel click and cancel
			Cancelpage IVC =  new Cancelpage(page);
				Assert.assertTrue(IVC.iscanclePageOpen());
	      //Assert.assertTrue(canclepage.isPageOpened());
				IVC.canclemsg();
				IVC.getPageUrl();
	       
	    }

}
