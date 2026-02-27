package org.isha.automation.test.LB;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.LB.LBDonationPage;
import org.ishafoundation.pages.LB.LBPersonalePage;
import org.ishafoundation.pages.shivanga.ShivangaPersonalDetails;
import org.ishafoundation.pages.shivanga.ShivangadonatePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LSGPanvalidationTest extends BaseTest{
	@Test
	public void LSGverifyPanMandatoryCondition() {
        page.navigate("https://lingabhairavi.org/en/devicrowdfunding/donate");
        LBDonationPage donation = new LBDonationPage(getPage());
        donation.selectamount();
        donation.continueclick();

        LBPersonalePage personal = new LBPersonalePage(getPage());
        
          // Scenario 1: Amount below 5000 – PAN not mandatory
        page.waitForTimeout(15000);
          Assert.assertFalse(personal.isPanoptiondispayed(),"PAN field should NOT be displayed for amount below 5000"); 
     
          // Go back for next scenario
          getPage().goBack();
        //  landing.Donationbuttonclick();

          // Scenario 2: Amount above 5000 – PAN mandatory
          donation.entercustomamount();
          donation.continueclick();
          page.locator("#pancard")
          .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(50000));
          Assert.assertTrue(personal.isPanoptiondispayed(), 
                  "PAN field should be displayed for amount above 5000");
  }

}
