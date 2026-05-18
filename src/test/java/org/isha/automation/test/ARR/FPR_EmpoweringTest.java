package org.isha.automation.test.ARR;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.ARR.ARRDonatePage;
import org.ishafoundation.pages.ARR.ARRHelperPage;
import org.ishafoundation.pages.ARR.ARRLandingPage;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class FPR_EmpoweringTest extends BaseTest{
	@Test(groups= {"sanity", "auth"}, retryAnalyzer = Retry.class)
	public void FPR_Empoweringdonationflow() throws InterruptedException {
		page.navigate(ConfigReader.get("consciousplanet.url")+ "/en/action-rural-rejuvenation"); 
		ARRLandingPage LP = new ARRLandingPage(page);
		Page donatePage = page.context().waitForPage(
		()->
		{
			LP.Donate();
		}
		);
		ARRDonatePage AP = new ARRDonatePage(donatePage);
		AP.FPODonate();
		donatePage.waitForTimeout(5000);
		AP.Enteramount();
		AP.continueclick();
		ARRHelperPage AH = new ARRHelperPage(donatePage);
		AH.completeDonationFlow();
	    PaymentPage payment = PaymentPageFactory.get(donatePage, false);
	    payment.payucancle();
		Cancelpage IVC =  new Cancelpage(donatePage);
		Assert.assertTrue(IVC.isfailedPageOpen());
		IVC.canclemsg();
		IVC.getPageUrl();
	}

}
