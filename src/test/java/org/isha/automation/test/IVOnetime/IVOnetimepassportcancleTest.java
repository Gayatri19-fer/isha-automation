package org.isha.automation.test.IVOnetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.iso.IV.Onetime.IVCanclePage;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimeDonatePage;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimePersonalPage;
import org.testng.annotations.Test;


import junit.framework.Assert;

public class IVOnetimepassportcancleTest extends BaseTest{
	
	@Test(groups= {"sanity","auth"},retryAnalyzer = Retry.class)
	public void IVonetimeflow() {
		page.navigate(ConfigReader.get("consciousplanet.url")+ "/en/isha-vidhya/donate"); 
		IVOnetimeDonatePage IV = new IVOnetimeDonatePage(page);
		IV.Donatepage();
		IV.continueclick();
		IVOnetimePersonalPage IVD =new IVOnetimePersonalPage(page);
		IVD.EnterFirstname();
		IVD.EnterLasttname();
		IVD.EnterEmail();
		IVD.EnterPhonenumber();
		IVD.Selectcitizenship();
		IVD.Select80GTax();
		IVD.Selectothercountry();
		IVD.Entertcity();
		IVD.EnterAddress();
		IVD.EnterPincode();
		IVD.EnterPan();
		IVD.Submit();
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.ccavenue();
	//	IVOnetimePaymentPage IVP = new IVOnetimePaymentPage(page);
	//	IVP.cancleplaywright();
	 // IVP.Cancleclick();				// for cancel click and failed
     //	IVP.Cancletansaction2();		// for cancel click and failed
     //	IVP.paymentselect();			// for select payment option and cancel payment 
		Cancelpage IVC =  new Cancelpage(page);
		Assert.assertTrue(IVC.iscanclePageOpen());  // for select payment option and verify cancel page
		// Assert.assertTrue(IVC.isfailedPageOpen()); // for cancel click and failed
		//Assert.assertTrue("Cancel page did not load. Current URL: " + page.url(), IVC.isPageOpen());
		IVC.canclemsg();
		IVC.getPageUrl();
	}

}
