package org.isha.automation.test.Annadanamorganicgeneral;

import java.util.List;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organichelper;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Fetchotp;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import junit.framework.Assert;

public class AnnadanamorganicgeneralcancelTest extends BaseTest {
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void annadanamorganicgeneralflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/iyc-annadanam");
		OrganicLandingPage OP = new OrganicLandingPage(page);
		Page donatePage = page.context().waitForPage(
		()->
		{
			OP.generalflow();
		}
		);
		donatePage.waitForLoadState(LoadState.NETWORKIDLE);
		OrganicDonatePage OD = new OrganicDonatePage(donatePage);
		OD.SelectAmount();
		OD.Continue();
		Organichelper OPP = new Organichelper(donatePage);
		OPP.completeflow();
		Otppage OTP = new Otppage(donatePage);
		OTP.getotp();
		Fetchotp lo = new Fetchotp(donatePage);
		String email = "kirti@yopmail.com";  // your Outlook email
		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		OTP.enterotp(otp);
		OTP.verify();
	//	OrganicpaymentPage OPM = new OrganicpaymentPage(donatePage);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPM.paymentselect();			// for select payment option and cancel payment 
		PaymentPage payment = PaymentPageFactory.get(donatePage, false);
		//	payment.FailInd();
		payment.payucancle();
		Cancelpage OC = new Cancelpage(donatePage);
	
	//	Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
		
	}

}
