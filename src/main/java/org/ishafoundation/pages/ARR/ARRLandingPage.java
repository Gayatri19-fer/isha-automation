package org.ishafoundation.pages.ARR;

import com.microsoft.playwright.Page;

public class ARRLandingPage {
private Page page;
	
	public ARRLandingPage(Page page) {
		this.page = page;
	}

	   public void Donate() {
		   page.locator("button[class='chakra-button css-2q5tsx']").click();
	   }

}
