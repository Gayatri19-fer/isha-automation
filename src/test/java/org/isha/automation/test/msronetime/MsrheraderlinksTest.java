package org.isha.automation.test.msronetime;

import org.isha.automation.basetest.BaseTest;
import org.ishafoundation.pages.msr.HeaderLinks;
import org.testng.annotations.Test;

public class MsrheraderlinksTest extends BaseTest {

    @Test
  public void testHeaderlinks()
  {
	  page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution");
	  HeaderLinks hd = new HeaderLinks(page);
	  hd.getFooterLinksCount();
	  
	 }
    /* @Test
  public void testopenhedlinks() {
	  page.navigate("https://mahashivarathri.org/en/mahashivratri-contribution");
	  HeaderLinks hd = new HeaderLinks(page);
	  hd.openfooterlinks();
  }*/

}
