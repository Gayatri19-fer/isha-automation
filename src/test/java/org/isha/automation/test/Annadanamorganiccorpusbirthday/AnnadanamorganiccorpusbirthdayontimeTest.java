package org.isha.automation.test.Annadanamorganiccorpusbirthday;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.CorpusCancelpgae;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusdonatepage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspaymentpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspersonalpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.LandingPage;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Fetchotp;
import org.ishafoundation.pages.common.Otppage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class AnnadanamorganiccorpusbirthdayontimeTest extends BaseTest{
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void organiccorpusbirthdayflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/annadanam");
		LandingPage BL = new LandingPage(page);
		Page donatepage = page.waitForPopup(() ->
		{
			BL.birthdayflow();}
		);
		Corpusdonatepage BD = new Corpusdonatepage(donatepage);
		BD.Enteramount();
		BD.clickcontinue();
		Corpuspersonalpage BH = new Corpuspersonalpage(donatepage);
		BH.EnterFirstname();
		BH.EnterLasttname();
		BH.EnterPhonenumber();
		BH.EnterEmail();
		BH.Selectcitizenship();
		BH.Select80GTax();
		BH.Selectcountry();
		BH.Selectstate();
		BH.Entertcity();
		BH.EnterAddress();
		BH.EnterPincode();
		BH.Enterpersonhonoured();
		BH.Enterdateodoccasion();
		BH.EnterPan();
		BH.Submit();
		Otppage BOT = new Otppage(donatepage);
		BOT.getotp();
		Fetchotp lo = new Fetchotp(donatepage);
		String email = "ridhi@yopmail.com";  // your Outlook email

		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		BOT.enterotp(otp);
		BOT.verify();
	//	Corpuspaymentpage BP = new Corpuspaymentpage(donatepage);
	//	BP.paymentselect();
		PaymentPage payment = PaymentPageFactory.get(donatepage, false);
	//	payment.FailInd();
		payment.payucancle();
	//	payment.cancleplaywright(); // for uat
		Cancelpage OC = new Cancelpage(donatepage);
		String expected = ConfigReader.get("payment.expected");

		if (expected.equalsIgnoreCase("cancel")) {
		    Assert.assertTrue(OC.iscanclePageOpen());
		} else {
		    Assert.assertTrue(OC.isfailedPageOpen());
		}
	//	Assert.assertTrue(BC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
	}

}
