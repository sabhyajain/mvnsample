package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgSample
{
	WebDriver driver;
	
	//@BeforeTest
	//@Parameters("browser")
	
	//@BeforeMethod
	@BeforeTest
	public void startMethod()//String strBrowser)
	{
		//System.out.println("browser is : " + strBrowser);
		
		//if(strBrowser.equalsIgnoreCase("chrome"))
		//{		
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");	
		// below line imported from maven website in pom.xml
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		//}
		
		//else if(strBrowser.equalsIgnoreCase("edge"))
		//{		
		//System.setProperty("webdriver.edge.driver", "E:\\drivers\\chromedriver.exe");	
			// WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
		//}
			driver.get("https:\\google.com");
			driver.manage().window().maximize();				
	}
	
	
  @Test (retryAnalyzer = RetryAnalyzerTest.class) //(priority=1)
  public void f1() 
  {
	  driver.get("https:\\google.com");
	  
	 // SoftAssert softassert = new SoftAssert();
	//  softassert.assertEquals(driver.getTitle(), "Google");
	  Assert.assertEquals(driver.getTitle(), "Google");
	  WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("java tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "java tutorial - Google");
		//softassert.assertEquals(driver.getTitle(), "java tutorial - Google Search");
			 
		//softassert.assertAll();
  }
  
  @Test //(priority=2)
  public void searchSeleniumTest1() 
  {
		
		WebElement searchBox = driver.findElement(By.name("qa"));
		
		searchBox.sendKeys("C# tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "java tutorial - Google Search");
		  
  }
  
  @Test //(alwaysRun = true,  dependsOnMethods = "f1")
  public void searchSeleniumTest2() 
  {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("Appium tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "java tutorial - Google Search");
  }
  
  @Test (enabled = false) // or //(priority=4) 
  public void searchSeleniumTest3() 
  {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("Selenium tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "java tutorial - Google Search");
	   }
  
  //@AfterTest
  @AfterMethod
  public void tearDown() 
  {
	  driver.close();
  }
}
