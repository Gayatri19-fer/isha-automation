package org.isha.automation.test.Annadanamorganiccorpusbirthday;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.CorpusCancelpgae;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusdonatepage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspaymentpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspersonalpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.LandingPage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class AnnadanamorganiccorpusbirthdayontimepassportTest extends BaseTest{
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganiccorpusgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/annadanam");
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
		Corpusotppage BOT = new Corpusotppage(donatepage);
		BOT.getotp();
		Fetchotp lo = new Fetchotp(donatepage);
		String email = "anuradha@yopmail.com";  // your Outlook email
		String otp =lo.fetchAndEnterOtpFromYopmail(email);
		BOT.enterotp(otp);
		BOT.verify();
		Corpuspaymentpage BPP = new Corpuspaymentpage(donatepage);
		BPP.passprotflowcancleplaywright();
		CorpusCancelpgae BC = new CorpusCancelpgae(donatepage);
		Assert.assertTrue(BC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		BC.canclemsg();
		BC.getPageUrl();
		
	}

}
