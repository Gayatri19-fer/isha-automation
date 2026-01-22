package org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Birthdaycorpuspersonalpage {
	private Page page;

	
	public Birthdaycorpuspersonalpage(Page page) {
		this.page =page;
	}

	public void entername() {
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter First Name")).fill("nidhi");
	}
	public void enterlastname() {
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Last Name")).fill("jadhav");
	}
	public void enteremail() {
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email")).fill("anuradha@yopmail.com");
	}
	public void entermobile() {
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number")).fill("8767787766");
	}
	public void Selectcitizenship() {
		page.locator(".radio").first().click();
	}
    public void Select80GTax() {
    	page.locator("//div[@class='recomend error']").click();
    }
    public void Selectcountry() {
        page.locator("#selected_country").selectOption("IN");
    }
	public void Selectstate() {
	    page.locator("#selected_state").selectOption("Maharashtra");
	 }
	public void entercity() {
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter city")).fill("mumbai");
	}
    public void EnterAddress() {
    	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street, Locality")).fill("navi mumbai");
    }
    public void EnterPincode() {
    	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Pin / Zip Code")).fill("415109");
    }
    public void Enterhonouredhonord() {
    	page.locator("#honouredPersons").fill("honouredPersons");
    }

    public void Selectanothercountry() {
        page.locator("#selected_country").selectOption("US");
        page.locator("#selected_state").selectOption("Alaska");
    	page.locator("#passport_image")
        .setInputFiles(Paths.get("C:\\Users\\Gayatri\\Downloads\\pass (1).jpg"));
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

/*	public boolean isPanoptiondispayed() {
	    
	     try {
	    	 return page.isVisible(Pancard);
	     } catch (Exception e) {
	         return false; // element truly not found
	     }
	 }*/
	public void EnterPan() {
		 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("PAN number")).fill("FGRTY5656t");
	}

    public void Submit() {
    	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay Securely")).click();
    }
    public void Selectothercountry() {
    	page.locator("#selected_country").selectOption("USA");
    	page.locator("#selected_state").selectOption("Alaska");
    	page.locator("#passport_image")
        .setInputFiles(Paths.get("C:\\Users\\Gayatri\\Downloads\\pass (1).jpg"));
    	
    	}


}
