package org.ishafoundation.pages.common.Payment;

import com.microsoft.playwright.Page;

public class PaymentPageFactory {
	
	 public static PaymentPage get(Page page) {

	        String env = System.getProperty("env", "prod");

	        if (env.equalsIgnoreCase("uat")) {
	            return new UatPaymentPage(page);
	        } else {
	            return new ProdPaymentPage(page);
	        }
	    }
}
