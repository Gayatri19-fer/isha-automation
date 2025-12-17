package org.ishafoundation.pages.iso.IV.Recurring;

import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

public class Outlookutility {
	 private Page page;

	    public Outlookutility(Page page) {
	        this.page = page;
	    }
	 // Navigate to Outlook web (assumes session/cookies or you'll need to login first)
	    public void openInbox() {
	        String url = "https://outlook.office.com/mail";
	        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
	        System.out.println("Navigating to Outlook inbox: " + url);
	        page.locator("input[type='email']").fill("gayatrib@fermion.in");
	        page.locator("#idSIButton9").click();
	        page.waitForTimeout(2000);
	        page.locator("input[type='password']").fill("GayBFer@2025");
	        page.locator("input[type='submit']").click();
	        
	    }

	    // Optional: perform a search using the Search box to find OTP email
	    private void searchInbox(String query) {
	        // Wait for search input (selector may change; this is a robust attempt)
	        Locator search = page.locator("//input[@id='topSearchInput']");
	        search.waitFor(new Locator.WaitForOptions().setTimeout(15_000));
	        search.fill(query);
	        search.press("Enter");
	        page.waitForTimeout(2000); // small wait for results
	    }

	    // Poll for OTP in newest messages — filterQuery can be sender/email subject keywords (e.g., "Your OTP")
	    public String waitForOtpFromInbox( int maxWaitSeconds, int pollIntervalSeconds) {
	        Instant end = Instant.now().plusSeconds(maxWaitSeconds);
	        Pattern otpPattern = Pattern.compile("(\\d{6})"); // adjust digits as needed

	        while (Instant.now().isBefore(end)) {
	            try {
	                page.reload(new Page.ReloadOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
	                page.waitForTimeout(1000);

	                /*If you have a filterQuery, use search
	                if (filterQuery != null && !filterQuery.isEmpty()) {
	                    searchInbox(filterQuery);
	                }
				*/
	                // Locate the list of messages (selectors vary; try common ones)
	                Locator messageRows = page.locator("//div[@id='AQAAAWRIA1kBAAADR4AVcQAAAAA=']");
	                if (messageRows.count() > 0) {
	                    // Click the first (most recent) email
	                    messageRows.nth(0).click();
	                    // Wait for message body to appear
	                    Locator bodyLocator = page.locator("//div[@role='document']");
	                    bodyLocator.waitFor(new Locator.WaitForOptions().setTimeout(10_000));
	                    String bodyText = bodyLocator.innerText();

	                    // Extract OTP
	                    Matcher m = otpPattern.matcher(bodyText);
	                    if (m.find()) {
	                        String otp = m.group(1);
	                        System.out.println("OTP found: " + otp);
	                        return otp;
	                    }
	                } else {
	                    // no messages found in list
	                }
	            } catch (Exception e) {
	                // log it and continue polling
	                System.out.println("Attempt error: " + e.getMessage());
	            }

	            try {
	                Thread.sleep(pollIntervalSeconds * 1000L);
	            } catch (InterruptedException ignored) {}
	        }

	        throw new RuntimeException("OTP not found in Outlook within " + maxWaitSeconds + " seconds");
	    }
	}


