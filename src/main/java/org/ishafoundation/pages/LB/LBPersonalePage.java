package org.ishafoundation.pages.LB;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LBPersonalePage {
	private Page page;
	
	public LBPersonalePage(Page page) {
		this.page = page;
	}
	
	private String name ="#first_name";
	private String lastname ="#last_name";
	private String Email = "#email";
	private String Phonenumber = "#contact_no";
	private String state = "#selected_state";
	private String PINCode = "#pincode";
	private String Address = "#addessline1";
	private String Pancard = "#pancard";
	private String Checkbox = "div[class='message-checkbox income-checkbox'] div[class='checkbox']";
	private String paysecurly = "button[name='Submit']";
	
	public void Entername() {
		page.fill(name, "Isha");
	}
	public void Enterlastname() {
		page.fill(lastname, "Isha");
	}
	public void Enteremail() {
		page.fill(Email, "Isha@gmail.com");
	}
	public void Enterenumbar() {
		page.fill(Phonenumber, "8976787667");
	}
	 public void Selectstate() {
		   //page.locator(state).selectOption("Maharashtra");
		   page.selectOption(state, "Maharashtra");
	 }
	  public void Entertcity() {
		   page.locator("#city").fill("Mumbai");
	  }
	  public void Entertaddress() {
		   page.fill(Address, "MSEB Road navi mumbai");
	  }
	  public void Entertpin() {
		   page.fill(PINCode, "415105");
	  }
		public void checkbox() {
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
