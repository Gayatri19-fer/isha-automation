package org.isha.automation.test.msronetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
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

public class MahashivaratricancleTest extends BaseTest{
	
	  @Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	    public void MahashivratriOntimeflow() {
	        page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution"); 
	        DonationHelper msrl1 = new DonationHelper(page);
	        msrl1.completeDonationFlow();
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
