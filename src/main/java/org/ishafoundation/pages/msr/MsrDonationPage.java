package org.ishafoundation.pages.msr;

import com.microsoft.playwright.Page;

public class MsrDonationPage {
	
	private Page page;
	
	private String Amounttext = "label:has-text('500')";
	private String Amounttext2 = "label:has-text('10000')";
	private String customeamount = "input[name='custom_amount']";
	private String ClickonDonate = "#continue";
	
	
	   public MsrDonationPage(Page page) {
	        this.page = page;
	    }
    
    public void EnterAmount() {
    	page.click(Amounttext);
    }
    
    public void Donationbuttonclick2() {
        page.click(ClickonDonate);
    }
    
    public void EnterAmount2() {
    	page.click(Amounttext2);
    }
    public void Entercustomeamount() {
    	page.click("#amt-block");
    	page.fill(customeamount, "20000");
    	page.evaluate("document.getElementById('hidden_donation_amount').value = '20000'");
    }
	
    

}
