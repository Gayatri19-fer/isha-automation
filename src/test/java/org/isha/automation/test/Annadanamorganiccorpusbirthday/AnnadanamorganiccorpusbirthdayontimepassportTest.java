package org.isha.automation.test.Annadanamorganiccorpusbirthday;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.BirthdaycorpusHelperpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.BirthdaycorpusLandingpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.BirthdaycorpusOtppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.BirthdaycorpuscancelPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.Birthdaycorpusdonationpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.Birthdaycorpuspaymentpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.Birthdaycorpuspersonalpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday.Loginpage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class AnnadanamorganiccorpusbirthdayontimepassportTest extends BaseTest{
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/annadanam");
		BirthdaycorpusLandingpage BL = new BirthdaycorpusLandingpage(page);
		Page donatepage = page.waitForPopup(() ->
		{BL.selectoccasion();}
		);
		Birthdaycorpusdonationpage BD = new Birthdaycorpusdonationpage(donatepage);
		BD.selectamount();
		Birthdaycorpuspersonalpage BP = new Birthdaycorpuspersonalpage(donatepage);
		BP.entername();
		BP.enterlastname();
		BP.enteremail();
		BP.entermobile();
		BP.Selectcitizenship();
	//	BP.Select80GTax();
		BP.Selectanothercountry();
		BP.entercity();
		BP.EnterAddress();
		BP.EnterAddress();
		BP.EnterPincode();
		BP.Enterhonouredhonord();
		BP.Enterdateodoccasion();
		BP.EnterPan();
		BP.Submit();
		BirthdaycorpusOtppage BOT = new BirthdaycorpusOtppage(donatepage);
		BOT.getotp();
		Loginpage lo = new Loginpage(donatepage);
		String email = "anuradha@yopmail.com";  // your Outlook email
		lo.fetchAndEnterOtpFromYopmail(email);
		Birthdaycorpuspaymentpage BPP = new Birthdaycorpuspaymentpage(donatepage);
		BPP.passprotflowcancleplaywright();
		BirthdaycorpuscancelPage BC = new BirthdaycorpuscancelPage(donatepage);
		Assert.assertTrue(BC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		BC.canclemsg();
		BC.getPageUrl();
		
	}

}
