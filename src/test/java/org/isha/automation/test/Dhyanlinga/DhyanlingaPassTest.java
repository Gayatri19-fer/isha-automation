package org.isha.automation.test.Dhyanlinga;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingaCanclePage;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingaDonateapage;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingapaymentPage;
import org.ishafoundation.pages.Sadhguru.Dhyanlinga.DhyanlingapersonaldetailsPage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class DhyanlingaPassTest extends BaseTest{
	
	@Test(groups= {"sanity","auth"},retryAnalyzer = Retry.class)
	public void dhyanlingaOntimepassflow()  throws InterruptedException {
		Page page = getPage(); // always get page from BaseTest
		page.navigate(ConfigReader.get("sadhguru.url")+ "/en/contribute/dhyanalinga/donate");
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
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.ccavenue();
		DhyanlingaCanclePage DC = new DhyanlingaCanclePage(page);
		Assert.assertTrue(DC.iscanclePageOpen());	//  to validate fail page open or not
		DC.canclemsg();
		DC.getPageUrl();
	}

}
