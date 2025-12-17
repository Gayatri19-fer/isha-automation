package org.isha.automation.test.shivangaonetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.shivanga.DonationHelpershivanga;
import org.ishafoundation.pages.shivanga.ShivangaCancle;
import org.ishafoundation.pages.shivanga.ShivangaPersonalDetails;
import org.ishafoundation.pages.shivanga.ShivangadonatePage;
import org.ishafoundation.pages.shivanga.ShivangapaymentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class ShivangacancleTest extends BaseTest{
	@Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	public void shivangaOntimeflow() throws InterruptedException {
		Page page = getPage(); // always get page from BaseTest
		page.navigate("https://www.shivanga.org/en/shivanga-contribution/general-donation/donate");
		DonationHelpershivanga dd = new DonationHelpershivanga(page);
		dd.dontionfow();
		ShivangapaymentPage sp = new ShivangapaymentPage(page);
		sp.Canclepaymentclick();	// for cancel click and failed
		sp.CancleTransaction();		// for cancel click and failed
		ShivangaCancle sc = new ShivangaCancle(page);
		Assert.assertTrue(sc.iscanclePageOpen());	//  to validate cancel page open or not
		sc.canclemsg();
		sc.getPageUrl();
	}

}
