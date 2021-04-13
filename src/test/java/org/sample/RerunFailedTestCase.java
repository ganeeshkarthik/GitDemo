package org.sample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTestCase implements IRetryAnalyzer {
	
	int min = 0, max = 500;
	public boolean retry(ITestResult result) {
		if (min<max) {
			min++;
			return true;
		}
		return false;
	}

}
