package org.ishafoundation.pages.iso.IV.Recurring;

import com.microsoft.playwright.Page;

public class IVRecurringDoantePage {

	private Page page;
	 
	public IVRecurringDoantePage(Page page) {
		this.page = page;
	}
	
	private String customeamount = "//input[@id='custom_amount_1807_1']";
	private String customeyear = "input[placeholder='Enter # of months']";
	
    public void Entercustomeamount() {
    	page.locator("label[class='amount amt-block ']").click();
    	//page.fill(customeamount, "618");
    	page.locator(customeamount).type("5423");
    	page.keyboard().press("Tab"); 
    }
    public void Enteryear() {
    	page.locator(".monthly.amt-block").click();
    	page.locator(customeyear).type("6");
    
    }
    public void cotinue() {
    	page.locator("//input[@class='button contribut primary']").click();
    }
    
    
}
