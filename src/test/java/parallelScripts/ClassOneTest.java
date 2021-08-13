package parallelScripts;

import org.testng.annotations.Test;

public class ClassOneTest {

	@Test
	public void Method1()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Method 1 : " + id);		
	}
		
	
	
}
