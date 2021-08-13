package parallelScripts;

import org.testng.annotations.Test;

public class MethodTest {

	@Test
	public void searchJavaTest()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Search Java Test: " + id);		
	}
	
	@Test
	public void searchSeleniumTest()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Search Selenium Test: " + id);		
	}
	
	// <test thread-count="5" name="ModuleOneTest">
	
	@Test
	public void searchCypressTest()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Search Cypress Test: " + id);		
	}
	
	// invocation is times for reexecuting, thread count = 3 and miliseconds
	@Test(threadPoolSize = 3, invocationCount = 6, timeOut=1000)
	public void searchAppiumTest()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Search Appium Test : " + id);		
	}
	
	public void searchAppium1Test()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Search Appium1 Test: " + id);		
	}
	
}
