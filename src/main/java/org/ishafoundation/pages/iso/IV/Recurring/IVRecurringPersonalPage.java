package org.ishafoundation.pages.iso.IV.Recurring;

import com.microsoft.playwright.Page;

public class IVRecurringPersonalPage {

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
	private String state = "#selected_state";
	private String citizenship = "//div[@class='recomend']";
	public IVRecurringPersonalPage(Page page) {
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
    public void Selectcitizenship() {
    	page.locator("//div[@class='recomend']").check();
    	page.selectOption(citizenship, "Yes");
    }
   public void Selectstate() {
	   page.locator(state).selectOption("Maharashtra");
   }
   public void Entertcity() {
	   page.locator("#city").fill("Mumbai");
   }
    public void EnterAddress() {
    	page.fill(Address, "fc road pune");
    }
    public void EnterPincode() {
    	page.fill(PINCode, "415105");
    }
	public boolean isPanoptiondispayed() {
	    
	     try {
	    	 return page.isVisible(Pancard);
	     } catch (Exception e) {
	         return false; // element truly not found
	     }
	 }
	public void EnterPan() {
		page.fill(Pancard, "CKYPG5676R");
	}

	public void checkbox() {
		page.check(Checkbox);
	 }
    public void paysecuarly() {
        page.click(paysecurly);
    }
    public void Submit() {
    	page.locator("button[name='Submit']").click();
    }
   

	
}
