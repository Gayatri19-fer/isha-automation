package org.ishafoundation.pages.cp.Onetime;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CACAOnetimePeronalPage {
	private Page page;
	
	public CACAOnetimePeronalPage(Page page) {
		this.page = page;
	}
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
	private String citizenship = "//div[@class='span'][normalize-space()='Indian']";
	private String tax ="//div[contains(text(),'Yes')]";
	
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
	    	page.locator("//div[@id='nation_input']//div[@class='citizens-option']").click();
	    	//page.selectOption(citizenship, "Yes");
	    	page.check(citizenship);
	    }
	    public void Select80GTax() {
	    	page.locator("//div[@id='tax_80g_input']//div[@class='citizens-option']").click();
	    	page.check(tax);
	    }
	    public void Selectcountry() {
	    	page.locator("#selected_country").selectOption("India");
	    	
	    }
	   public void Selectstate() {
		  page.locator(state).selectOption("Andhra Pradesh");
		  
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
