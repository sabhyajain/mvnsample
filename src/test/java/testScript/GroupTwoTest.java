package testScript;

import org.testng.annotations.Test;

public class GroupTwoTest {
	
	@Test(groups = {"featureOne"})
	public void searchRobotFWTest()
	{
		System.out.println("Search For Robot Test ");
		
	}
	
	@Test(dependsOnGroups = {"featureOne"} , groups = {"featureTwo"})
	public void searchRobotTest()
	{
		System.out.println("Search For Robot  ");
		
	}


}
