package org.isha.automation.test.msronetime;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrLandingPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Locator;

import Resources.BaseExtentReport;

public class MSRPanvalidationTest extends BaseTest{
	   @Test
	    public void MSRverifyPanMandatoryCondition() {
	          page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution");
	           MsrLandingPage landing = new MsrLandingPage(getPage());
	           landing.Donationbuttonclick();

	           MsrDonationPage donation = new MsrDonationPage(getPage());
	           MsrPersonalDetailsPage personal = new MsrPersonalDetailsPage(getPage());

	            // Scenario 1: Amount below 10000 – PAN not mandatory
	            donation.EnterAmount();
	            donation.Donationbuttonclick2();
	            
	            MsrPersonalDetailsPage msrPersonal = new MsrPersonalDetailsPage(page);
	            page.waitForTimeout(15000);
	            Assert.assertFalse(msrPersonal.isPanoptiondispayed(),"PAN field should NOT be displayed for amount below 10000"); 
	       
	            // Go back for next scenario
	            getPage().goBack();
	          //  landing.Donationbuttonclick();

	            // Scenario 2: Amount above 10000 – PAN mandatory
	            donation.Entercustomeamount();
	            donation.Donationbuttonclick2();
	            page.waitForTimeout(1000);
	            Assert.assertTrue(msrPersonal.isPanoptiondispayed(), 
	                    "PAN field should be displayed for amount above 10000");
	    }

}
