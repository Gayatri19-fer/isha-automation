package org.isha.automation.test.msronetime;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrLandingPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MsrPanmandatoryTest extends BaseTest{
	
	@Test
	public void panmandatory() {
		page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution");
		   MsrLandingPage msrl = new MsrLandingPage(page);
	       msrl.Donationbuttonclick();
	       MsrDonationPage msrd = new MsrDonationPage(page);
	       msrd.EnterAmount2();
	       msrd.Donationbuttonclick2();
	       MsrPersonalDetailsPage msrpersonal = new MsrPersonalDetailsPage(page);
 
	     //  Assert.assertTrue(msrpersonal.isPanoptiondispayed());
	         Assert.assertTrue(msrpersonal.isPanoptiondispayed(), "Pan should be mandatory for amount greater that 10000");
	}

}
