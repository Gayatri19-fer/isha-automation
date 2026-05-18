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
	@Test(groups= {"sanity", "auth"}, retryAnalyzer = Retry.class)
	public void CACAOnetimeflow() {
		page.navigate(ConfigReader.get("consciousplanet.url")+ "/en/cauvery-calling/plant-trees"); 
		CACAOnetimeDonationPage dn = new CACAOnetimeDonationPage(page);
		dn.DonatePage();
		CACADoationHelper CAH = new CACADoationHelper(page);
		CAH.completedonationflow();
	    PaymentPage payment = PaymentPageFactory.get(page, false);
	    payment.payucancle();
		Cancelpage IVC =  new Cancelpage(page);
		Assert.assertTrue(IVC.isfailedPageOpen());
		//Assert.assertTrue(canclepage.isPageOpened());
		IVC.canclemsg();
		IVC.getPageUrl();
	}

} 
