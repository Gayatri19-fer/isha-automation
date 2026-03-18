package org.isha.automation.test.Annadanamorganiccorpusgeneral;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.LandingPage;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Fetchotp;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusdonatepage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpushelperpage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class AnnadanamorganiccorpusgeneralonetimeTest extends BaseTest {
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void organiccorpusgeneralflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/annadanam");
		LandingPage LP = new LandingPage(page);
		Page donatePage = page.waitForPopup(
		()->
		{
			LP.generalflow();
		}
		);
		Corpusdonatepage gc =  new Corpusdonatepage(donatePage);
		gc.selectonetime();
		gc.selectamount();
		gc.clickcontinue();
		Corpushelperpage gp = new Corpushelperpage(donatePage);
		gp.completeflow();
		Otppage go = new Otppage(donatePage);
		go.getotp();
		Fetchotp lo = new Fetchotp(donatePage);
		String email = "kirti@yopmail.com";  // your Outlook email
		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		go.enterotp(otp);
		go.verify();
	//	Corpuspaymentpage OPP = new Corpuspaymentpage(donatePage);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPP.paymentselect();			// for select payment option and cancel payment 
		PaymentPage payment = PaymentPageFactory.get(donatePage, false);
	//	payment.FailInd();  //for prod
		payment.payucancle();
	//	payment.cancleplaywright(); // for uat
		Cancelpage OC = new Cancelpage(donatePage);
		String expected = ConfigReader.get("payment.expected");

		if (expected.equalsIgnoreCase("cancel")) {
		    Assert.assertTrue(OC.iscanclePageOpen());
		} else {
		    Assert.assertTrue(OC.isfailedPageOpen());
		}
	//	Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
	}	
}
