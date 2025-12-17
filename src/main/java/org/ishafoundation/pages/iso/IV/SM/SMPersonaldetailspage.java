package org.ishafoundation.pages.iso.IV.SM;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class SMPersonaldetailspage {
	private Page page;
	
	public SMPersonaldetailspage(Page page) {
		this.page =page;
	}
	
	private String name = "#first_name";
	private String Lastname = "#last_name";
	private String Email = "#email";
	private String Phonenumber = "#contact_no";
	private String PINCode = "#pincode";
	private String Address = "#addessline1";
	private String Pancard = "#pancard";
	private String paysecurly = "button[name='Submit']";
	private String state = "#selected_state";
	private String citizenship = "(//div[@class='radio'])[1]";
	private String tax ="(//div[@class='radio error'])[1]";
	
	public void entername() {
		page.fill(name, "Harshali");
	}
    public void EnterLasttname() {
    	page.fill(Lastname, "Parawate");
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
    	page.check(citizenship);
    }
    public void Select80GTax() {
    	page.locator("//div[@class='recomend error']").click();
    	page.check(tax);
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
    public void Selectothercountry() {
    	page.locator("#selected_country").selectOption("USA");
    	page.locator("#selected_state").selectOption("Alaska");
    	page.locator("#passport_image")
        .setInputFiles(Paths.get("C:\\Users\\Gayatri\\Downloads\\pass (1).jpg"));
    	
    	}


}
