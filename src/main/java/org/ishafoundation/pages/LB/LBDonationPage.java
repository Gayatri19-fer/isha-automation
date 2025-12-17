package org.ishafoundation.pages.LB;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LBDonationPage {
	private Page page ;
	
	   public LBDonationPage(Page page) {
	        this.page = page;
	    }
	private String selectamount = "(//span[@class='radio'])[2]";
	private String customeamount ="(//span[@class='radio'])[1]";
	private String customeamount1 ="//input[@id='custom_amount_3725_0']";
	private String ClickonDonate = "#continue";
	
    public void selectamount() {
    //	page.locator("#amt-block").click();
    //	page.fill(customeamount, "618");
    	page.click(selectamount);
    }
	
    public void continueclick() {
        page.click(ClickonDonate);
    }
    
    public void entercustomamount() {
        	page.locator(customeamount).click();
        	page.fill(customeamount1, "5000");
        	page.evaluate("document.getElementById('hidden_donation_amount').value = '1200'");
    		
        	
        }
    	
	

}
