package org.isha.automation.test.IVOnetime;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimeDonatePage;
import org.ishafoundation.pages.iso.IV.Onetime.IVOnetimePersonalPage;
import org.ishafoundation.utils.PersonalDetailsValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IVPanvalidationTest extends BaseTest{
	@Test
	public void IVpanvalidationtest() {
		
		page.navigate("https://consciousplanet.org/en/isha-vidhya/donate"); 
		IVOnetimeDonatePage IV = new IVOnetimeDonatePage(page);
		IV.Donatepage();  // amount less that 5k
		IV.continueclick();
		IVOnetimePersonalPage IVP = new IVOnetimePersonalPage(page);
		IVP.Selectcitizenship();
		IVP.Select80GTax();
		page.waitForTimeout(1000);
		IVP.validatePanField();
	//	Assert.assertTrue(IVP.validatePanField(), "Pan field mandatory for amount below 5000");   //indcitizen =yes , 80gtax = yes
		getPage().goBack();
		IV.Donatepage();  
		IV.continueclick(); 
		page.waitForTimeout(1000);
		IVP.Selectcitizenshipno();
		IVP.Select80GTaxno();
		page.waitForTimeout(15000);
		IVP.validatePanField();
	//	Assert.assertFalse(IVP.isPanoptiondispayed(), "Pan field not mandatory for amount below 5000");
	
	}

}
