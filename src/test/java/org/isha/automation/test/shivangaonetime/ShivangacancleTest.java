package org.isha.automation.test.shivangaonetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.common.Cancelpgae;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.shivanga.DonationHelpershivanga;
import org.ishafoundation.pages.shivanga.ShivangaCancle;
import org.ishafoundation.pages.shivanga.ShivangaPersonalDetails;
import org.ishafoundation.pages.shivanga.ShivangadonatePage;
import org.ishafoundation.pages.shivanga.ShivangapaymentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class ShivangacancleTest extends BaseTest{
	@Test(groups= {"sanity","auth"},retryAnalyzer = Retry.class)
	public void shivangaOntimeflow() throws InterruptedException {
		Page page = getPage(); // always get page from BaseTest
		page.navigate(ConfigReader.get("shivanga.url")+"/en/shivanga-contribution/general-donation/donate");
		DonationHelpershivanga dd = new DonationHelpershivanga(page);
		dd.dontionfow();
	//	ShivangapaymentPage sp = new ShivangapaymentPage(page);
		//sp.cancelplaywright();
		PaymentPage payment = PaymentPageFactory.get(page);
		payment.ccavenue();
		Cancelpgae sc = new Cancelpgae(page);
		Assert.assertTrue(sc.iscanclePageOpen());	//  to validate cancel page open or not
		sc.canclemsg();
		sc.getPageUrl();
	}

}
