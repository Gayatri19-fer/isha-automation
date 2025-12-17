package org.ishafoundation.pages.iso.IV.Onetime;

import java.nio.file.Paths;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class IVOnetimePersonalPage {
	private Page page ;
	
	private String Firstname = "#first_name";
	private String Lastname = "#last_name";
	private String Email = "#email";
	private String Phonenumber = "#contact_no";
	private String PINCode = "#pincode";
	private String Address = "#addessline1";
	private String Pancard = "#pancard";
	private String paysecurly = "button[name='Submit']";
	private String state = "#selected_state";
	private String taxinput = "#tax_80g_input";
	private String yescitizenship = "(//div[@class='radio'])[1]";
	private String nocitizenship = "(//div[@class='radio'])[2]";
	private String yestax ="(//div[@class='radio error'])[1]";
	private String notax ="(//div[@class='radio error'])[2]";
	
	public IVOnetimePersonalPage(Page page) {
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
    	page.locator("//div[@class='recomend']").click();
    	//page.selectOption(citizenship, "Yes");
    	page.check(yescitizenship);
    }
    public void Select80GTax() {
    	page.locator("//div[@class='recomend error']").click();
    	page.check(yestax);
    }
    
    public void Selectcitizenshipno() {
    	page.locator("//div[@class='recomend']").click();
    	//page.selectOption(citizenship, "Yes");
    	page.check(nocitizenship);
    }
    public void Select80GTaxno() {
    	page.locator("//div[@class='recomend error']").click();
    	page.check(notax);
    }
    
    public void Selectcountry() {
    	page.locator("#selected_country").selectOption("India");
    	
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

    public void Submit() {
    	page.click(paysecurly);
    }
    
	public boolean is80GtaxoptionDisplayed() {
	    
	     try {
	    	 page.locator(taxinput).waitFor(new Locator.WaitForOptions().setTimeout(2000));
	    	 return page.locator(taxinput).isVisible();
	     } catch (Exception e) {
	         return false; // element truly not found
	     }
	 }
	 // Method to validate PAN field based on citizen & 80G selection
    public boolean validatePanField() {
        boolean isIndian = page.locator("#nationality").isChecked();
        boolean is80GTax = page.locator("#want_80G").isChecked();

        // PAN expected rules:
        // 1. Amount < 5k → PAN mandatory if 80G yes
        // 2. Amount > 5k → PAN mandatory regardless of selections
        // Since amount > 5k is handled in donate page, here we just check citizen & tax

        boolean panExpected;
        if (is80GTax) {
            panExpected = true;
        } else {
            panExpected = false;
        }

        // Check actual PAN visibility
        boolean panVisible = page.isVisible(Pancard);
        String assertMsg = "PAN field visibility mismatch! "
                + "Indian Citizen = " + isIndian 
                + ", 80G Tax = " + is80GTax 
                + ", Expected PAN Visible = " + panExpected
                + ", Actual PAN Visible = " + panVisible;

      Assert.assertEquals(panVisible, panExpected,
    		  assertMsg);
		return panVisible;
    }
    
    public void Selectothercountry() {
    	page.locator("#selected_country").selectOption("USA");
    	page.locator("#selected_state").selectOption("Alaska");
    	page.locator("#passport_image")
        .setInputFiles(Paths.get("C:\\Users\\Gayatri\\Downloads\\pass (1).jpg"));
    	
    	}


}
