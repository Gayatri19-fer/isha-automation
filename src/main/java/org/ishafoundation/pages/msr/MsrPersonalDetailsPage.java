package org.ishafoundation.pages.msr;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MsrPersonalDetailsPage {
	
	private Page page;
		
	private String Firstname = "#first_name";
	private String Lastname = "#last_name";
	private String Email = "#email";
	private String Phonenumber = "#contact_no";
	private String PINCode = "#pincode";
	private String Address = "#addessline1";
	private String Pancard = "#pancard";
	private String Checkbox = "div[class='message-checkbox income-checkbox'] div[class='checkbox']";
	private String paysecurly = "button[name='Submit']";
	   public MsrPersonalDetailsPage(Page page) {
	        this.page = page;
	    }

	    public void EnterFirstname() {
	    	page.fill(Firstname, "Gayatri");
	    }
	    public void EnterLasttname() {
	    	page.fill(Lastname, "Bodake");
	    }
	    public void EnterEmail() {
	    	page.fill(Email, "gayatrib@fermion.in");
	    }
	    public void EnterPhonenumber() {
	    	page.fill(Phonenumber, "8796821998");
	    }
	    public void EnterPINnumber() {
	    	page.fill(PINCode, "415105");
	    }
	    public void Selectcheckbox() {
	    	page.fill(Address, "fc road pune");
	    }
	    public void EnterAddress() {
	    	page.check(Checkbox);
	    }
	    public void paysecuarly() {
	        page.click(paysecurly);
	    }
	    
		public boolean isPanoptiondispayed() {
		    
		    try {
		        // Wait max 2 seconds for the PAN field to appear (or disappear)
		        page.locator(Pancard).waitFor(new Locator.WaitForOptions().setTimeout(2000));
		        return page.locator(Pancard).isVisible();
		    } catch (Exception e) {
		        return false; // If element never appears, return false
		    }
		 }


	    
	    


}
