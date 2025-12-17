package org.ishafoundation.pages.Sadhguru.Organiccorpus.occasions.Birthday;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BirthdaycorpusLandingpage {
	private Page page;

	
	public BirthdaycorpusLandingpage(Page page) {
		this.page =page;
	}
	
	public void selectoccasion() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Learn more")).nth(1).click();
	}

}
