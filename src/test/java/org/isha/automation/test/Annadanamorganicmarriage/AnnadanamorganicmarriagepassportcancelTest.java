package org.isha.automation.test.Annadanamorganicmarriage;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Organic.general.FetchOtppage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicDonatePage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicLandingPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganiccancelPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.Organicotppage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpaymentPage;
import org.ishafoundation.pages.Sadhguru.Organic.general.OrganicpersonaldetailsPage;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import junit.framework.Assert;

public class AnnadanamorganicmarriagepassportcancelTest extends BaseTest{
	@Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	public void annadanamorganicmarriageflow() {
		page.navigate("https://isha.sadhguru.org/en/contribute/iyc-annadanam");
		OrganicLandingPage ML = new OrganicLandingPage(page);
		Page donatePage = page.waitForPopup(() -> {
		    ML.weddingflow();  // This click opens the new tab
		});
		donatePage.waitForSelector("#amt-block", 
			    new Page.WaitForSelectorOptions().setTimeout(20000)
			);

			// Then wait for the 11,000 label
		//	donatePage.locator("label:has-text('11,000')").waitFor(new Locator.WaitForOptions()
		//	    .setState(WaitForSelectorState.VISIBLE)
		///	    .setTimeout(15000)
		//	);
		
		OrganicDonatePage MD = new OrganicDonatePage(donatePage);
	//	MD.Enteramount();
		MD.Enteramount();
		MD.Continue();
		OrganicpersonaldetailsPage MH = new OrganicpersonaldetailsPage(donatePage);
		MH.EnterFirstname();
		MH.EnterLasttname();
		MH.EnterEmail();
		MH.EnterPhonenumber();
		MH.Selectcitizenship();
		MH.Select80GTax();
		MH.Selectothercountry();
		MH.Entertcity();
		MH.EnterAddress();
		MH.EnterPincode();
		MH.Enterpersonhonoured();
		MH.Enterdateodoccasion();
		MH.EnterPan();
		MH.Submit();
		Organicotppage MO = new Organicotppage(donatePage);
		MO.getotp();
		FetchOtppage LO = new FetchOtppage(donatePage);
		String email = "kirti@yopmail.com";  // your Outlook email
		String otp = LO.fetchAndEnterOtpFromYopmail(email);
		MO.enterotp(otp);
		MO.verify();
		OrganicpaymentPage MP = new OrganicpaymentPage(donatePage);
		MP.cancleplaywright();
	//	MP.Cancleclick();		// for cancel click and failed
	//	MP.paymentselect();		// for select payment option and cancel payment 
		OrganiccancelPage MC = new OrganiccancelPage(donatePage);
		Assert.assertTrue(MC.iscanclePageOpen());  // for select payment option and verify cancel page
		// Assert.assertTrue(IVC.isfailedPageOpen()); // for cancel click and failed
		//Assert.assertTrue("Cancel page did not load. Current URL: " + page.url(), IVC.isPageOpen());
		MC.canclemsg();
		MC.getPageUrl();
	}

}
