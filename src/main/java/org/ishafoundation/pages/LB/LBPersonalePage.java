package org.ishafoundation.pages.LB;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

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
			 Locator pan = page.locator("#pancard");

			    try {
			        pan.waitFor(new Locator.WaitForOptions()
			                .setState(WaitForSelectorState.VISIBLE)
			                .setTimeout(10000));
			        return true;
			    } catch (Exception e) {
			        return false;
			    }
		 }

	  
	  
}
