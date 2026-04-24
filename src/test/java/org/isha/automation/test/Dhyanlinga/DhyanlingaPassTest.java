package org.isha.automation.test.Dhyanlinga;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingaCanclePage;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingaDonateapage;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingapaymentPage;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingapersonaldetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class DhyanlingaPassTest extends BaseTest{
	
	@Test(groups= {"sanity"},retryAnalyzer = Retry.class)
	public void dhyanlingaOntimepassflow() throws InterruptedException {
		Page page = getPage(); // always get page from BaseTest
		page.navigate("https://isha.sadhguru.org/en/contribute/dhyanalinga/donate");
		DhyanlingaDonateapage DD = new DhyanlingaDonateapage(page);
		DD.SelectAmount();
		DD.Continue();
		DhyanlingapersonaldetailsPage DP = new DhyanlingapersonaldetailsPage(page);
		DP.EnterFirstname();
		DP.EnterLasttname();
		DP.EnterEmail();
		DP.EnterPhonenumber();
		DP.Selectcitizenship();
		DP.Select80GTax();
		DP.Selectothercountry();
		DP.Entertcity();
		DP.EnterAddress();
		DP.EnterPincode();
		DP.EnterPan();
		DP.Submit();
		DhyanlingapaymentPage DPP = new DhyanlingapaymentPage(page);
		DPP.cancleplaywright();
		DhyanlingaCanclePage DC = new DhyanlingaCanclePage(page);
		Assert.assertTrue(DC.iscanclePageOpen());	//  to validate fail page open or not
		DC.canclemsg();
		DC.getPageUrl();
	}

}
