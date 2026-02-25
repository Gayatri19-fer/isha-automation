package org.isha.automation.test.CACAOnetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.cp.Onetime.CACADoationHelper;
import org.ishafoundation.pages.cp.Onetime.CACAOnetimeDonationPage;

import org.testng.Assert;
import org.testng.annotations.Test;



public class CACAOnetimecancleTest extends BaseTest {
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void CACAOnetimeflow() {
		page.navigate(ConfigReader.get("consciousplanet.url")+ "/en/cauvery-calling/plant-trees"); 
		CACAOnetimeDonationPage COD = new CACAOnetimeDonationPage(page);
		COD.DonatePage();
		CACADoationHelper CAH = new CACADoationHelper(page);
		CAH.completedonationflow();
	//	CACAOnetimePaymentPage CAP = new CACAOnetimePaymentPage(page);
	//	CAP.Canclepaymentclick();	//for cancel click and cancel
	//	CAP.CancleTransaction();	//for cancel click and cancel
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.ccavenue();
		Cancelpage CAC = new Cancelpage(page);
		Assert.assertTrue(CAC.iscanclePageOpen()); //for cancel click and cancel
		CAC.canclemsg();
		CAC.getPageUrl();
	}

}
