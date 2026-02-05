package org.isha.automation.test.msronetime;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrLandingPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MSRaddressvalidationabove20kTest extends BaseTest{
	Object[][] addresses = {
			{"Flat 12 MG Road ",false},{"House 45-A Street",false},{"No 7434 3rd Cross",false},
			{"Plot #12 Gandhi Nagar",false},{"Block B 221 Baker St",false},{"Temple Road 5",false},
			{"Room 3 First Floor",false},{"Sector 21 Plot 9",false},{"Green Park Phase-2",false},{"1234 5678 90",true},{"test teset",true},
			{"Test Address 12",false},{"data entry road",true},{"qwerty street 1", true}, {"asdf hstreet 1",true},
			{"1111 Road Name",true},{"Main ---- Road",true},{"Block_A 101 Street",false},
			{"Plot & Phase 2",false},{"Room (First Floor)",false},{"Street, Name 45",false},
			{"Apt. 202 Main",false},{"Green Park-2",false},{"Address_One 12",false},
			{"Tower A (Block-B)",false},{"Road/Name 12",false},
			{"Plot #12 Gandhi Nagar",false},{"#1234 5678",true},
			{"Flat 1",true},{"A B C",true},{"Flat @12 Road",true},{"Street#45",true},{"Addr+Lane 9",true},{"City:Center",true},
			{"Short 1",true},{"************",true},{"Name'Place 45",true},
			{"Road$Name",true},{"Name%Area",true},{"Name'Place",true},{"City*Road",true},{"Flat12MGroad",true},
			{"1234 5678 90", true},{"#1234 5678", true},{"test teset ", true},{"data entry road", true},
			{"Test Address 12", true},{"data entry road", true},{"qwerty street 1", true},{"1111 Road Name ", true},
			{"Aaaa Street 12", false},{"Flat @12 Road", true},{"           ", true},{"ggtgtbjuio ", false}
	};
	
	@Test
	public void addressvalidationbelow20k() {
	      page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution"); 
		   MsrLandingPage msrl = new MsrLandingPage(page);
	       msrl.Donationbuttonclick();
	       MsrDonationPage msrd = new MsrDonationPage(page);
	       msrd.Entercustomeamount();
	       msrd.Donationbuttonclick2();
	       MsrPersonalDetailsPage msrpersonal = new MsrPersonalDetailsPage(page);
	       SoftAssert softAssert = new SoftAssert();
	      for (Object[]data:addresses ){
	    	  String address = (String)data[0];
	    	  boolean expectederrormsg = (boolean)data[1];
	    	  boolean actualerrormsg = msrpersonal.Addressvalidationeqaulabove20k(address);
	    	  softAssert.assertEquals(actualerrormsg, expectederrormsg,
		               "Failed for address: " + address);
		       }
	      softAssert.assertAll();
	      }
	       
	}


