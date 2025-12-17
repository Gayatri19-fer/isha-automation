package org.ishafoundation.pages.msr;

import com.microsoft.playwright.Page;

public class MsrLandingPage {
	
	
	private Page page;
	
	
	private String donatebutton = ".button.white.donate-top-btn";
	
	   public MsrLandingPage(Page page) {
	        this.page = page;
	    }
	
    public void Donationbuttonclick() {
        page.click(donatebutton);
    }

}
