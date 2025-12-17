package org.ishafoundation.pages.msr;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.MouseButton;

public class HeaderLinks {
	
	private final Page page ;
	private Locator Headerscope;
	
	public HeaderLinks(Page page) {
		this.page =page;
		this.Headerscope = page.locator("//div[@class='header']");
	}
	
    // 1. Get all footer links count
    public int getFooterLinksCount() {
 
    Locator headerLinks = Headerscope.locator("a");
    int count = headerLinks.count();
    System.out.println("Total number of header links" +headerLinks.count());
    for (int i = 0; i < count; i++) {
        System.out.println(headerLinks.nth(i).innerText());
        
    		}
	return count;
    }
    
   public void openfooterlinks() {
    	Locator headerLinks = Headerscope.locator("a");
        int links = headerLinks.count();
        
       for (int i = 0; i < links; i++) {
    	 
            headerLinks.nth(i).click(new Locator.ClickOptions()
                        .setButton(MouseButton.MIDDLE)); // or CTRL+Click
            
        }
     /*  List<Page> Allpages = page.context().pages();
       for(Page p : Allpages) {
    	   if(p!= Allpages) {
    	   p.waitForLoadState(LoadState.DOMCONTENTLOADED);  // to wait until DOM ready
    	   System.out.println("Titel of the links" + p.title());
    	   }
       }*/
    }
}
