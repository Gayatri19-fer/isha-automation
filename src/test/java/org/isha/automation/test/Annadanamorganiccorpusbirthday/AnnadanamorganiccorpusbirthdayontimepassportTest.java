package org.isha.automation.test.Annadanamorganiccorpusbirthday;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.CorpusCancelpgae;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusdonatepage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusotppage;
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

public class AnnadanamorganiccorpusbirthdayontimepassportTest extends BaseTest{
	@Test(groups= {"sanity","auth"}, retryAnalyzer = Retry.class)
	public void organiccorpusbirthdaypassflow() {
		page.navigate(ConfigReader.get("sadhguru.url")+"/en/contribute/annadanam");
		LandingPage BL = new LandingPage(page);
		Page donatepage = page.waitForPopup(() ->
		{
			BL.birthdayflow();}
		);
		Corpusdonatepage BD = new Corpusdonatepage(donatepage);
		BD.Enteramount();
		BD.clickcontinue();
		Corpuspersonalpage BP = new Corpuspersonalpage(donatepage);
		BP.EnterFirstname();
		BP.EnterLasttname();
		BP.EnterPhonenumber();
		BP.EnterEmail();
		BP.Selectcitizenship();
		BP.Select80GTax();
		BP.Selectothercountry();
		BP.Entertcity();
		BP.EnterAddress();
		BP.EnterPincode();
		BP.Enterpersonhonoured();
		BP.Enterdateodoccasion();
		BP.EnterPan();
		BP.Submit();
		Otppage BOT = new Otppage(donatepage);
		BOT.getotp();
		Fetchotp lo = new Fetchotp(donatepage);
		String email = "kirti@yopmail.com";  // your Outlook email
		String otp =lo.fetchAndEnterOtpFromYopmail(email);
		BOT.enterotp(otp);
		BOT.verify();
	//	Corpuspaymentpage BPP = new Corpuspaymentpage(donatepage);
	//	BPP.passprotflowcancleplaywright();
		PaymentPage payment = PaymentPageFactory.get(donatepage, false);
		payment.cancelPassport();
		Cancelpage GC = new Cancelpage(donatepage);
		String expected = ConfigReader.get("payment.expected");

		if (expected.equalsIgnoreCase("cancel")) {
		    Assert.assertTrue(GC.iscanclePageOpen());
		} else {
		    Assert.assertTrue(GC.isfailedPageOpen());
		}
		Assert.assertTrue(GC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		GC.canclemsg();
		GC.getPageUrl();
		
	}

}
