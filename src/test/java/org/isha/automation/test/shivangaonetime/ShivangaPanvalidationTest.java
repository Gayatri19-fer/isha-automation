package org.isha.automation.test.shivangaonetime;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrLandingPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.ishafoundation.pages.shivanga.ShivangaPersonalDetails;
import org.ishafoundation.pages.shivanga.ShivangadonatePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShivangaPanvalidationTest extends BaseTest{
	@Test
	public void shivangaverifyPanMandatoryCondition() {
        page.navigate("https://www.shivanga.org/en/shivanga-contribution/general-donation/donate");
        ShivangadonatePage donation = new ShivangadonatePage(getPage());
        donation.SelectAmount();
        donation.Continue();

        ShivangaPersonalDetails personal = new ShivangaPersonalDetails(getPage());
        
          // Scenario 1: Amount below 5000 – PAN not mandatory
        page.waitForTimeout(1000);
          Assert.assertFalse(personal.isPanoptiondispayed(),"PAN field should NOT be displayed for amount below 5000"); 
     
          // Go back for next scenario
          getPage().goBack();
        //  landing.Donationbuttonclick();

          // Scenario 2: Amount above 5000 – PAN mandatory
          donation.Enteramount();
          donation.Continue();
          page.waitForTimeout(1000);
          Assert.assertTrue(personal.isPanoptiondispayed(), 
                  "PAN field should be displayed for amount above 5000");
  }

}
