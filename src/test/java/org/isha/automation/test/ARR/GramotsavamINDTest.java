package org.isha.automation.test.ARR;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.cp.Onetime.CACADoationHelper;
import org.ishafoundation.pages.cp.Onetime.CACAOnetimeDonationPage;
import org.ishafoundation.pages.cp.Onetime.CACAOnetimePaymentPage;
import org.ishafoundation.pages.cp.Onetime.CACAOntimeCancle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GramotsavamINDTest extends BaseTest {
	
	@Test(groups= {"sanity"}, retryAnalyzer = Retry.class)
	public void CACAOnetimeflow() {
		page.navigate("https://consciousplanet.org/en/action-rural-rejuvenation/gramotsavam/donate"); 
		CACAOnetimeDonationPage COD = new CACAOnetimeDonationPage(page);
		COD.DonatePage();
		CACADoationHelper CAH = new CACADoationHelper(page);
		CAH.completedonationflow();
		CACAOnetimePaymentPage CAP = new CACAOnetimePaymentPage(page);
		CAP.Canclepaymentclick();	//for cancel click and cancel
		CAP.CancleTransaction();	//for cancel click and cancel
		CACAOntimeCancle CAC = new CACAOntimeCancle(page);
		Assert.assertTrue(CAC.iscanclePageOpen()); //for cancel click and cancel
		CAC.canclemsg();
		CAC.getPageUrl();
	}

}
