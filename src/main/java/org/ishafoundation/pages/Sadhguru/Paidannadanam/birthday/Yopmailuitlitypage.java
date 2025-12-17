package org.ishafoundation.pages.Sadhguru.Paidannadanam.birthday;

import java.time.Duration;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

public class Yopmailuitlitypage {

	 private Page page;

	    public Yopmailuitlitypage(Page page) {
	        this.page = page;
	    }
	    // Open inbox for given local-part (before @yopmail.com)
	    public void openInbox(String localPart) {
	        String url = "https://yopmail.com/en/?" + localPart;
	       // String url = "https://yopmail.com/en/wm";
	        System.out.println("Navigating to Yopmail inbox URL: " + url);
	        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
	    }

	    // Poll inbox until OTP is found
	    public String waitForOtp(int maxWaitSeconds, int pollIntervalSeconds) {
	        Instant end = Instant.now().plus(Duration.ofSeconds(maxWaitSeconds));

	        while (Instant.now().isBefore(end)) {
	            page.reload(new Page.ReloadOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

	            try {
	                // Click first email if present
	                FrameLocator inboxFrame = page.frameLocator("#ifinbox");
	                Locator mails = inboxFrame.locator("div.m div.lmfd");
	                if (mails.count() > 0) {
	                    mails.nth(0).click();
	                    page.waitForTimeout(1000);
	                }

	                // Switch to mail iframe
	                FrameLocator mailFrame = page.frameLocator("iframe#ifmail, iframe[name='ifmail']");
	                String bodyText = mailFrame.locator("body").innerText();

	                // Extract OTP using regex (6 digits)
	                Pattern p = Pattern.compile("(\\d{6})");
	                Matcher m = p.matcher(bodyText);
	                if (m.find()) {
	                    System.out.println("OTP found: " + m.group(1));
	                    return m.group(1); // return first 6-digit OTP
	                }

	            } catch (Exception ignored) {}

	            try {
	                Thread.sleep(pollIntervalSeconds * 1000L);
	            } catch (InterruptedException ignored) {}
	        }

	        throw new RuntimeException("OTP not found in YOPmail within " + maxWaitSeconds + " seconds");
	    }

}
