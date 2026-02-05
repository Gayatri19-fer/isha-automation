package org.isha.automation.test.Annadanamorganiccorpusgeneral;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.generalOrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusdonatepage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpushelperpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspaymentpage;
import org.ishafoundation.pages.iso.IV.Recurring.YopmailutilityPage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import junit.framework.Assert;

public class AnnadanamorganiccorpusgeneralonetimeTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void annadanamorganiccorpusgeneralflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/annadanam/donate");
		Corpusdonatepage gc =  new Corpusdonatepage(page);
		gc.selectonetime();
		gc.selectamount();
		gc.clickcontinue();
		Corpushelperpage gp = new Corpushelperpage(page);
		gp.completeflow();
		Corpusotppage go = new Corpusotppage(page);
		go.getotp();
		Fetchotp lo = new Fetchotp(page);
		String email = "anuradha@yopmail.com";  // your Outlook email
		String otp = lo.fetchAndEnterOtpFromYopmail(email);
		go.enterotp(otp);
		go.verify();
		Corpuspaymentpage OPP = new Corpuspaymentpage(page);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
		OPP.paymentselect();			// for select payment option and cancel payment 
		generalOrganiccancelPage OC = new generalOrganiccancelPage(page);
		Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
	}	
}
