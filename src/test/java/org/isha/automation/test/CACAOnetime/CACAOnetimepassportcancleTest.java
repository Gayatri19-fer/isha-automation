package org.isha.automation.test.CACAOnetime;

import org.isha.automation.basetest.BaseTest;
import org.isha.automation.basetest.Retry;
import org.isha.automation.utils.ConfigReader;
import org.ishafoundation.pages.common.Cancelpage;
import org.ishafoundation.pages.common.Payment.PaymentPage;
import org.ishafoundation.pages.common.Payment.PaymentPageFactory;
import org.ishafoundation.pages.cp.Onetime.CACAOnetimeDonationPage;
import org.ishafoundation.pages.cp.Onetime.CACAOnetimePeronalPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CACAOnetimepassportcancleTest extends BaseTest {
	@Test(groups= {"sanity", "auth"},retryAnalyzer = Retry.class)
	public void CACAOnetimepassflow() {
		page.navigate(ConfigReader.get("consciousplanet.url")+ "/en/cauvery-calling/plant-trees"); 
		CACAOnetimeDonationPage COD = new CACAOnetimeDonationPage(page);
		COD.DonatePage();
		CACAOnetimePeronalPage CCP = new CACAOnetimePeronalPage(page);
		CCP.EnterFirstname();
		CCP.EnterLasttname();
		CCP.EnterEmail();
		CCP.EnterPhonenumber();
		CCP.Selectcitizenship();
		CCP.Select80GTax();
		CCP.Selectothercountry();
		CCP.Entertcity();
		CCP.EnterAddress();
		CCP.EnterPincode();
		CCP.EnterPan();
		CCP.Submit();
		PaymentPage payment = PaymentPageFactory.get(page, false);
		payment.ccavenue();
		//CAP.Canclepaymentclick();	//for cancel click and cancel
		//CAP.CancleTransaction();	//for cancel click and cancel
		Cancelpage CAC = new Cancelpage(page);
		Assert.assertTrue(CAC.iscanclePageOpen()); //for cancel click and cancel
		CAC.canclemsg();
		CAC.getPageUrl();
	}

}
