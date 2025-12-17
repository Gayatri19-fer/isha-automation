package org.ishafoundation.pages.Sadhguru.Organic.general;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.microsoft.playwright.Page;

public class generalOrganicpersonaldetailsPage {
	
	private Page page;
	
	public generalOrganicpersonaldetailsPage(Page page) {
		this.page =page;
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
	private String citizenship = "(//div[@class='radio'])[1]";
	private String tax ="(//div[@class='radio error'])[1]";
	private String occasion ="#occasion";
	private String personhonoured ="#honouredPersons";
	
	   public void EnterFirstname() {
	    	page.fill(Firstname, "Gayatri");
	    }
	    public void EnterLasttname() {
	    	page.fill(Lastname, "Bodake");
	    }
	    public void EnterEmail() {
	    	page.fill(Email, "anuradha@yopmail.com");
	    }
	    public void EnterPhonenumber() {
	    	page.fill(Phonenumber, "8796821997");
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
	    
	    public void Enteroccasion() {
	    	page.fill(occasion, "General occasion");
	    }
	    
	    public void Enterdateodoccasion() {
	    	// To select future date 
	    	LocalDate targetDate = LocalDate.now().plusDays(5); // choose any future day
	    	String day = targetDate.format(DateTimeFormatter.ofPattern("d"));

	    	// Open calendar
	    	page.locator("#dateOfOccasion").click();

	    	// Select enabled date (ignore disabled dates)
	    //	Locator calender = page.locator("#ui-datepicker-div");
	    //	calender.locator("//tabel//tbody//tr//td[not(contains(@class,' ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled '))]/a[text()='" + day + "']").click();
	    	// to select today date
	    	page.locator("td.ui-datepicker-today a").click();
	    }
	    
	    public void Enterpersonhonoured() {
	    	page.fill(personhonoured, "new honoured");
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
