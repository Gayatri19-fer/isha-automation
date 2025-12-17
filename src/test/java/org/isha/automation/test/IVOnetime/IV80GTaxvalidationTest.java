package org.isha.automation.test.IVOnetime;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.iso.IV.Onetime.IVDonationHelper;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimeDonatePage;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimePersonalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IV80GTaxvalidationTest extends BaseTest{
	@Test
	public void IVonetime80GTaxCondition() {
		page.navigate("https://consciousplanet.org/en/isha-vidhya/donate"); 
		IVOnetimeDonatePage IV = new IVOnetimeDonatePage(page);
		IV.Donatepage();
		IV.continueclick();
		IVOnetimePersonalPage IVP =new IVOnetimePersonalPage(page);
		page.waitForTimeout(1000);
		Assert.assertTrue(IVP.is80GtaxoptionDisplayed(), "80GTax field mandatory for amount below 5000");
		getPage().goBack();
		IV.Enteramount();
		IV.continueclick();
		page.waitForTimeout(15000);
		Assert.assertFalse(IVP.is80GtaxoptionDisplayed(), "80GTax field not mandatory for amount below 5000");
	
	}

}
