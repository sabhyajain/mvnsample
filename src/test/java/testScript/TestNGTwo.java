package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGTwo {

WebDriver driver;
	
public static Properties prop;

@BeforeTest
public void readProperty() throws IOException
{
	prop = new Properties();
	String path = System.getProperty("user.dir") + "//src//test//resources//config.properties";
	FileInputStream fin = new FileInputStream(path);
	prop.load(fin);
}

	@BeforeMethod	
	public void startMethod()
	{
		 // System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");	
		if(prop.getProperty("broswer").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		//driver = new ChromeDriver();
			//driver.get("https:\\google.com");
			driver.manage().window().maximize();				
	}
	
	
  //@Test (retryAnalyzer = RetryAnalyzerTest.class)
	@Test
  public void f() 
  {
		prop.getProperty("url"); 
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys(prop.getProperty("scearText") ); // "java tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "java tutorial - Google"); 
  }
  
  @Test
  public void searchSeleniumTest() 
  {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("java tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "java tutorial - Google Search");	  
  }
  
   @AfterMethod
  public void tearDown() 
  {
	  driver.close();
  }
}
