package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int retryCount = 0;
	int maxRetry = 1;
	public boolean retry(ITestResult result)
	{
		if(retryCount < maxRetry)
		{
			retryCount++;
			return true;
		}
		return false;
	}
}
