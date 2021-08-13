package testScript;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerTest implements IRetryAnalyzer
{

	int retryAttempCounter = 0;
	int maxRetry = 3;
	
	public boolean retry(ITestResult result) 
	{
	
		if(result.isSuccess())
		{
			if(retryAttempCounter < maxRetry)
			{
				retryAttempCounter++;
				return true;
			}
		}
		
		// TODO Auto-generated method stub	
		
		// return true if you want to retry this method
		return false;
	}

}
