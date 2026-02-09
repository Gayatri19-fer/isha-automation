package org.isha.automation.test.msronetime;

import static org.testng.Assert.assertTrue;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.msr.MsrDonationPage;
import org.ishafoundation.pages.msr.MsrLandingPage;
import org.ishafoundation.pages.msr.MsrPersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MSRaddressvalidationbelow20kTest extends BaseTest{	
	@Test 
	public void addressvalidationbelow5k() {
		Object[][] addresses = {
				{"Flat 12 MG Road ",false},{"House 45-A Street",false},{"No 7434 3rd Cross",false},
				{"Block B 221 Baker St",false},{"Apt 101 Main Road",false},{"Temple Road 5",false},
				{"Room 3 First Floor",false},{"Sector 21 Plot 9",false},{"Green Park Phase-2",false},
				{"Flat12MGroad",false},{"1234 5678 90",false},{"test teset",false},
				{"Test Address 12",false},{"data entry road",false},{"qwerty street 1 , asdf hstreet 1",false},
				{"1111 Road Name",false},{"Main ---- Road",false},{"Block_A 101 Street",false},
				{"Plot & Phase 2",false},{"Room (First Floor)",false},{"Street, Name 45",false},
				{"Apt. 202 Main",false},{"Green Park-2",false},{"Address_One 12",false},
				{"Tower A (Block-B)",false},{"Road/Name 12",false},
				{"Plot #12 Gandhi Nagar",false},{"#1234 5678",false},{"Flat 1",true},
				{"A B C",true},{"Flat @12 Road",true},{"Street#45",true},{"Addr+Lane 9",true},{"City:Center",true},
				{"Short 1",true},{"************",true},{"Name'Place 45",true},
				{"Road$Name",true},{"Name%Area",true},{"Name'Place",true},{"City*Road",true}
			};
		
	      page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution"); 
		   MsrLandingPage msrl = new MsrLandingPage(page);
	       msrl.Donationbuttonclick();
	       MsrDonationPage msrd = new MsrDonationPage(page);
	       msrd.selectAmount();
	       msrd.Donationbuttonclick2();
	       MsrPersonalDetailsPage msrpersonal = new MsrPersonalDetailsPage(page);
	       for (Object[] data : addresses) {

	           String address = (String) data[0];
	           boolean expected = (boolean)data[1];
	       boolean actualError = msrpersonal.Addressvalidationbelow20k(address);

	       Assert.assertEquals(actualError, expected,
	               "Failed for address: " + address);
	       }
	       
	}

}
