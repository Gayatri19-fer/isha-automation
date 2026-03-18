package org.isha.automation.test.IVOnetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.iso.IV.Onetime.IVCanclePage;
import org.ishafoundation.pages.iso.IV.Onetime.IVDonationHelper;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimeDonatePage;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimePaymentPage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class IVOnetimecancleTest extends BaseTest{
	
	@Test(groups= {"sanity","auth"},retryAnalyzer = Retry.class)
	public void IVonetimeflow() {
		page.navigate(ConfigReader.get("consciousplanet.url")+ "/en/isha-vidhya/donate"); 
		IVOnetimeDonatePage IV = new IVOnetimeDonatePage(page);
		IV.Donatepage();
		IV.continueclick();
		IVDonationHelper IVD =new IVDonationHelper(page);
		IVD.completedonationflow();
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.FailInd();  //for prod
	//	payment.cancleplaywright(); // for uat
	//	IVOnetimePaymentPage IVP = new IVOnetimePaymentPage(page);
	 // IVP.Cancleclick();				// for cancel click and failed
     //	IVP.Cancletansaction2();		// for cancel click and failed
    // 	IVP.paymentselect();			// for select payment option and cancel payment 
		Cancelpage IVC =  new Cancelpage(page);
	//	Assert.assertTrue(IVC.iscanclePageOpen());  // for select payment option and verify cancel page
		 Assert.assertTrue(IVC.isfailedPageOpen()); // for cancel click and failed
		//Assert.assertTrue("Cancel page did not load. Current URL: " + page.url(), IVC.isPageOpen());
			IVC.canclemsg();
		IVC.getPageUrl();
	}

}
