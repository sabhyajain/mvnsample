package testScript;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOneTest
{

	@BeforeGroups (groups = {"featureOne"})
	public void GroupSetup()
	{
		System.out.println("Group Setup is Done");				
	}
	
	@Test(groups="featureOne")
	public void searchJavaTest()
	{
		//System.out.println("Search Java Test");		
	}
	
	@Test(groups="featureTwo")
	public void searchSeleniumTest()
	{
		//System.out.println("Search Selenium Test");		
	}
	
	// <test thread-count="5" name="ModuleOneTest">
	
	@Test(groups="featureOne")
	public void searchCypressTest()
	{
		//System.out.println("Search Cypress Test");		
	}
	
	@Test(groups="featureThird")
	public void searchAppiumTest()
	{
		System.out.println("Search Appium Test");	
		
		String name = "Sabhya jain";
		
		for (int i =0; i<=name.length()-1 ; i++)
		{
			System.out.println(name.charAt(i));
			
			//if()
		}
		
		System.out.println("Group Setup is Not Done");
	}
	
	public void searchAppium1Test()
	{
		//System.out.println("Search Appium1 Test");		
	}
	
	@AfterGroups (groups = {"featureOne"})
	public void GroupTest()
	{
		System.out.println("Group End");
	}
	
	
	
}
