package org.isha.automation.test.Annadanamorganiccorpusgeneral;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;

import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organichelper;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.LandingPage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Fetchotp;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusdonatepage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpushelperpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpusotppage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspaymentpage;
import org.ishafoundation.pages.Sadhguru.Organiccorpus.general.Corpuspersonalpage;
import org.ishafoundation.pages.iso.IV.Recurring.YopmailutilityPage;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import junit.framework.Assert;

public class AnnadanamorganiccorpusgeneralonetimepassportTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void organiccorpusgeneralpassflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/annadanam");
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
		Corpusotppage go = new Corpusotppage(donatePage);
		go.getotp();
		Fetchotp lo = new Fetchotp(donatePage);
		String email = "anuradha@yopmail.com";  // your Outlook email

		String otp =lo.fetchAndEnterOtpFromYopmail(email);
		go.enterotp(otp);
		go.verify();

		
		Corpuspaymentpage OPP = new Corpuspaymentpage(donatePage);
	//	OPP.clickoncancel();		// for cancel click and failed
	//	OPP.Cancletansaction2();		// for cancel click and failed
	//	OPP.paymentselect();			// for select payment option and cancel payment 
		OPP.passprotflowcancleplaywright();
		OrganiccancelPage OC = new OrganiccancelPage(donatePage);
		Assert.assertTrue(OC.iscanclePageOpen()); // for select payment option and verify cancel page
		//Assert.assertTrue(OC.isfailedPageOpen()); // for cancel click and failed
		OC.canclemsg();
		OC.getPageUrl();
		
	}	
}
