package org.isha.automation.basetest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
    
	private int retryCount = 0;
    private static final int maxRetryCount = 1; // retry twice

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;   // retry test
        }
        return false;
    }

}
