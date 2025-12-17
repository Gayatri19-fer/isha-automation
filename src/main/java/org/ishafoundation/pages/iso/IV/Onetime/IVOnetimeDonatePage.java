package org.ishafoundation.pages.iso.IV.Onetime;

import com.microsoft.playwright.Page;

public class IVOnetimeDonatePage {
	private Page page;
	
	public IVOnetimeDonatePage(Page page) {
		this.page = page;
	}
	
	private String Onetime = "//div[contains(text(),'Give One-Time')]";
	private String selectamount = "(//span[@id='select_amt_96_2'])[1]";
	private String Clickonnext = "#continue";
	private String customeamount = "(//span[@id='hido-id'])[1]";  // 3000
	private String selectamount2 = "//span[@id='select_amt_96_3']";  // 10000
	
	public void Donatepage() {
		page.click(Onetime);
		page.click(selectamount);
		
	}
	
    public void continueclick() {
    	page.click(Clickonnext);
    }
     public void Enteramount() {
    	 page.click(Onetime);
    	 page.click(selectamount2);
    	// page.click(customeamount);
    	// page.locator("#custom_amount_96").fill("6000");
    	// page.keyboard().press("Tab"); 
     }

}
