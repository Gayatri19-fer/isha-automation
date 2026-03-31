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
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspersonalpage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import junit.framework.Assert;

public class AnnadanamorganiccorpusgeneralonetimepassportTest extends BaseTest {
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void organiccorpusgeneralpassflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+"/en/contribute/annadanam");
		LandingPage LP = new LandingPage(page);
		Page donatePage = page.context().waitForPage(
		()->
		{
			LP.generalflow();
		}
		);
		donatePage.waitForLoadState(LoadState.NETWORKIDLE);
		Corpusdonatepage gc =  new Corpusdonatepage(donatePage);
		gc.selectonetime();
		gc.selectonetime();
		gc.Enteramount();
		gc.clickcontinue();
		Corpuspersonalpage gp = new Corpuspersonalpage(donatePage);
		gp.EnterFirstname();
		gp.EnterLasttname();
		gp.EnterEmail();
		gp.EnterPhonenumber();
		gp.Selectcitizenship();
		gp.Select80GTax();
		gp.Selectothercountry();
		gp.Entertcity();
		gp.EnterAddress();
		gp.EnterPincode();
		gp.Enteroccasion();
		gp.Enterdateodoccasion();
		gp.Enterpersonhonoured();
		gp.EnterPan();
		gp.Submit();
		Otppage go = new Otppage(donatePage);
		go.getotp();
		Fetchotp lo = new Fetchotp(donatePage);
		String email = "ridhi@yopmail.com";  // your Outlook email

		String otp =lo.fetchAndEnterOtpFromYopmail(email);
		go.enterotp(otp);
		go.verify();

		
	//	Corpuspaymentpage OPP = new Corpuspaymentpage(donatePage);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPP.paymentselect();			// for select payment option and cancel payment 
	//	OPP.passprotflowcancleplaywright();
		PaymentPage payment = PaymentPageFactory.get(donatePage, false);
		payment.cancelPassport();
		Cancelpage GC = new Cancelpage(donatePage);
		String expected = ConfigReader.get("payment.expected");

		if (expected.equalsIgnoreCase("cancel")) {
		    Assert.assertTrue(GC.iscanclePageOpen());
		} else {
		    Assert.assertTrue(GC.isfailedPageOpen());
		}
	//	Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		GC.canclemsg();
		GC.getPageUrl();
		
	}	
}
