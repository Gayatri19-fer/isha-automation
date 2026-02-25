package org.ishafoundation.pages.common.Payment;

import com.microsoft.playwright.Page;

public class PaymentPageFactory {
	
	 public static PaymentPage get(Page page, boolean isDiffLocator) {

	        String env = System.getProperty("env", "uat");
	        System.out.println("Running ENV = " + env);

	        if (env.equalsIgnoreCase("uat")) {
	            return new UatPaymentPage(page, isDiffLocator);
	        } else {
	            return new ProdPaymentPage(page);
	        }
	    }
}
