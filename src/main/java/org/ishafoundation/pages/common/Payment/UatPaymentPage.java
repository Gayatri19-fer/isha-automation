package org.ishafoundation.pages.common.Payment;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class UatPaymentPage implements PaymentPage{
    private Page page;
    private boolean isDiffLocator;

    public UatPaymentPage(Page page, boolean isDiffLocator) {
        this.page = page;
        this.isDiffLocator = isDiffLocator;
    }
	public void CancelInd() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForTimeout(2000); 
		Locator netBanking = page.locator("article:has-text('NetBanking')");
		netBanking.waitFor(new Locator.WaitForOptions().setTimeout(15000));
		netBanking.click();
		
		page.getByLabel("Avenue Test").click();
		Page page1 = page.waitForPopup(() ->{page.getByLabel("Proceed to Pay", new Page.GetByLabelOptions().setExact(true)).click();
		});
		page1.locator("#status").selectOption("N");	
		page1.locator("//button[@id='btn']").click();
		
		Locator ifotheroption = page.locator("//u[normalize-space()='Other Payment Options']");
		try {
			ifotheroption.waitFor(new Locator.WaitForOptions().setTimeout(5000));
			ifotheroption.click();
			page.waitForLoadState();
			page.locator("//u[normalize-space()='Cancel']").click();
			
			page.locator("(//article[@role='none'][normalize-space()='Confirm'])").click();
		}catch (PlaywrightException e){
			 System.out.println("Directly redirected to Cancel page.");
		}
	    
	}

	public void FailInd() {
		 Locator cancelBtn = page.locator("div[configpath='Exit.SecondaryButton']");
		 cancelBtn.waitFor(new Locator.WaitForOptions()
			        .setState(WaitForSelectorState.VISIBLE));
		    cancelBtn.click(new Locator.ClickOptions().setTimeout(10000));

		    Locator confirmBtn = page.locator("//div[@role='button'][normalize-space()='Confirm']");
		    confirmBtn.waitFor(new Locator.WaitForOptions()
		            .setState(WaitForSelectorState.ATTACHED));

		    confirmBtn.click(new Locator.ClickOptions().setTimeout(10000));
		
	}
	public void cancelPassport() {
		 Locator cancelBtn = page.locator("(//u[normalize-space()='Cancel'])[1]");
		 cancelBtn.waitFor(new Locator.WaitForOptions()
			        .setState(WaitForSelectorState.VISIBLE));
		    cancelBtn.click(new Locator.ClickOptions().setTimeout(10000));

		    Locator confirmBtn = page.locator("//article[@role='none'][normalize-space()='Confirm']");
		    confirmBtn.waitFor(new Locator.WaitForOptions()
		            .setState(WaitForSelectorState.ATTACHED));

		    confirmBtn.click(new Locator.ClickOptions().setTimeout(10000));
	}
	
	public void cancleplaywright() {
		page.waitForLoadState(LoadState.NETWORKIDLE);

		System.out.println("Total Frames: " + page.frames().size());

		for (Frame f : page.frames()) {
		    System.out.println("Frame name: " + f.name());
		    System.out.println("Frame URL: " + f.url());
		    System.out.println("----------------------");
		}
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.locator("div[configpath='Exit.SecondaryButton']")
	    .click();
		
		Locator cancel = page.locator("//div[@configpath='ExitPopup.Popup']"); //page.locator("//article[normalize-space()='Confirm']");
		cancel.waitFor(new Locator.WaitForOptions()
		        .setState(WaitForSelectorState.VISIBLE));
		page.locator("[testid='btn_yes']").click();
	        
		    }
	
	public void ccavenue() {
		
	
		if(isDiffLocator) {
			
			page.locator("(//div[@id='buttons'])[1]").click();
			page.locator("(//a[@class='secondary-link cancel'][normalize-space()='Cancel'])[1]").click();
			page.locator("//div[@id='cancel-transaction-feedback']").click();
			page.locator("(//a[@class='primary-button primary-button-bg radius4 confirmCancel'])[1]").click();
		      
		}else {
		 Locator cancellink=  page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel')]")
	        .first();
		 cancellink.waitFor();
		 cancellink.click();   
	   page.frameLocator("#paymentFrame").locator("//a[contains(normalize-space(), 'Cancel Transaction')]")
       .first()
       .click();
		}
		
	}
	
	public void LGuatcancel() {
		page.locator("//div[@class='tabcontent OPTCRDC resp-tab-content resp-tab-content-active']//a[@class='secondary-link cancel'][normalize-space()='Cancel']").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cancel Transaction")).click();
	}
	public void paymentselectind() {
		Locator wallate = page.locator("(//article[@role='none'][normalize-space()='NetBanking'])");
		wallate.click();
		Locator option = page.locator("//div[@testid='clk_select_li_test']");
		page.waitForTimeout(300); 
	    try {
	    	option.waitFor(new Locator.WaitForOptions()
	                .setState(WaitForSelectorState.VISIBLE)
	                .setTimeout(8000));
	        page.waitForTimeout(200); // allow animation to settle
	        option.scrollIntoViewIfNeeded();
	        option.click(new Locator.ClickOptions()
	                .setForce(true)
	                .setTimeout(8000));
	     //   System.out.println("option selected successfully.");
	    } catch (PlaywrightException e) {
	        throw new RuntimeException("❌ Failed to click on option ", e);
	    }
	    
	    Locator pay = page.locator("div[testid='btn_pay'] article[role='none']:has-text('proceed to pay')");
	    pay.click(new Locator.ClickOptions()
                .setForce(true)
                .setTimeout(8000));
	    
	}
}
