package parallelScripts;

import org.testng.annotations.Test;

public class ClassTwoTest {
	
	@Test
	public void MethodTwo()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Method 2 : " + id);		
	}
	@Test
	public void MethodThree()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Method 3 : " + id);		
	}


}
