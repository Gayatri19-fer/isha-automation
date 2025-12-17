package org.isha.automation.test.Annadanamorganiccorpusgeneral;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.LoginRecurringpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.generalcorpusdonatepage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.generalcorpushelperpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.generalcorpusotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.generalcorpuspaymentpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.generalcorpuspersonalpage;
import org.ishafoundation.pages.iso.IV.Recurring.YopmailutilityPage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class AnnadanamorganiccorpusgeneralonetimepassportTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganicgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/annadanam/donate");
		generalcorpusdonatepage gc =  new generalcorpusdonatepage(page);
		gc.selectonetime();
		gc.selectamount();
		gc.clickcontinue();
		generalcorpuspersonalpage gp = new generalcorpuspersonalpage(page);
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
		generalcorpusotppage go = new generalcorpusotppage(page);
		go.getotp();
		LoginRecurringpage lo = new LoginRecurringpage(page);
		String email = "anuradha@yopmail.com";  // your Outlook email

		lo.fetchAndEnterOtpFromYopmail(email);

		
		generalcorpuspaymentpage OPP = new generalcorpuspaymentpage(page);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPP.paymentselect();			// for select payment option and cancel payment 
		OPP.passprotflowcancleplaywright();
		generalOrganiccancelPage OC = new generalOrganiccancelPage(page);
		Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
	}	
}
