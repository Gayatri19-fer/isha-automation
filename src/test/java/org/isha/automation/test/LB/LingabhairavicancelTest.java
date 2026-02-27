package org.isha.automation.test.LB;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.LB.DonationHelper;
import org.ishafoundation.pages.LB.LBDonationPage;
import org.ishafoundation.pages.LB.LBPaymentPage;
import org.ishafoundation.pages.LB.LBPersonalePage;
import org.ishafoundation.pages.LB.LBcancelPage;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.common.Payment.UatPaymentPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LingabhairavicancelTest extends BaseTest{
	@Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	public void lingabhairavioneTimeflow() {
		page.navigate(ConfigReader.get("lingabhairavi.url")+"/en/devicrowdfunding/donate");
		LBDonationPage LBD = new LBDonationPage(page);
		LBD.selectamount();
		LBD.continueclick();
		DonationHelper LBP = new DonationHelper(page);
		LBP.completedonationflow();
		//LBPaymentPage LPP = new LBPaymentPage(page);
	//	LPP.Canclepaymentclick();	//for cancel click and cancel
	//	LPP.CancleTransaction();	//for cancel click and cancel
		PaymentPage payment = PaymentPageFactory.get(page , true);
		payment.ccavenue();
		 

		Cancelpage LBC = new Cancelpage(page);
		Assert.assertTrue(LBC.iscanclePageOpen());	//for cancel click and cancel
		LBC.canclemsg();
		LBC.getPageUrl();
		
	}

}
