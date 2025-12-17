package org.ishafoundation.utils;

import org.testng.Assert;

import com.microsoft.playwright.Page;

public class PersonalDetailsValidator {
	private Page page;
	
	public PersonalDetailsValidator(Page page) {
		this.page = page;
	}
	private String yescitizenship = "(//div[@class='radio'])[1]";
	private String nocitizenship = "(//div[@class='radio'])[2]";
	private String yestax ="(//div[@class='radio error'])[1]";
	private String notax ="(//div[@class='radio error'])[2]";
	
	public void PersonalDetailsValidator(boolean isIndianCitizen, boolean is80GTaxClaim) {
		
		if (isIndianCitizen) {
			page.locator("//div[@class='recomend']").click();
			page.check(yescitizenship);
		}else {
			page.locator("//div[@class='recomend']").click();
			page.check(nocitizenship);
		}
		
		if(is80GTaxClaim) {
			page.locator("//div[@class='recomend error']").click();
	    	page.check(yestax);
		}else {
			page.locator("//div[@class='recomend error']").click();
	    	page.check(notax);
		}
		
		if (isIndianCitizen && is80GTaxClaim) {
            Assert.assertTrue(page.isVisible("#pancard"), "PAN should be visible");
            Assert.assertFalse(page.isVisible("#select_country"), "Nationality should NOT be visible");
            Assert.assertFalse(page.isVisible("#passport_number"), "Passport should NOT be visible");
        } 
        else if (!isIndianCitizen && is80GTaxClaim) {
            Assert.assertTrue(page.isVisible("#pancard"), "PAN should be visible");
            Assert.assertTrue(page.isVisible("#select_country"), "Nationality should be visible");
            Assert.assertTrue(page.isVisible("#passport_number"), "Passport should be visible");
        } 
        else if (!isIndianCitizen && !is80GTaxClaim) {
            Assert.assertFalse(page.isVisible("#pancard"), "PAN should NOT be visible");
            Assert.assertTrue(page.isVisible("#select_country"), "Nationality should be visible");
            Assert.assertTrue(page.isVisible("#passport_number"), "Passport should be visible");
        } 
        else { // Indian & no 80G
            Assert.assertFalse(page.isVisible("#pancard"), "PAN should NOT be visible");
            Assert.assertFalse(page.isVisible("#select_country"), "Nationality should NOT be visible");
            Assert.assertFalse(page.isVisible("#passport_number"), "Passport should NOT be visible");
        }
		
	}
	

}
