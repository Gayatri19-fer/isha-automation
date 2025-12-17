package org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday;

import com.microsoft.playwright.Page;

public class birthdayDonatePage {
	private Page page;
	
	public birthdayDonatePage(Page page) {
		this.page =page;
	}

	private String seeoption = ".other-options";
	
	public void Clikdonate() {
		page.click(seeoption);
	}

}
