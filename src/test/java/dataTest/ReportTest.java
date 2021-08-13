package dataTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.java.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportTest {
	
	WebDriver driver;
	ExtentTest extentTest;
	ExtentReports reports;
	ExtentHtmlReporter htmlReport;
	
	@BeforeTest
	public void setExtent()
	{
		reports = new ExtentReports();
		//htmlReport = new ExtentHtmlReporter("E:\\Screenshots\\ExtentReports.html");
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "// reports//ExtentReport1.html");
		reports.attachReporter(htmlReport);
	}
	
	//@BeforeTest
	@BeforeMethod	
	public void startMethod()
	{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
			driver.get("https:\\google.com");
			driver.manage().window().maximize();				
	}
	
	
  @Test //(priority=1)
  public void searchJavaTest() 
  {
	  extentTest = reports.createTest("Search Java Test");
	  driver.get("https:\\google.co.in/");
	  
	 WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("java tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "java tutorial - Google Search");
  }
  
  @Test //(priority=2)
  public void searchSeleniumTest1() 
    {	
	  extentTest = reports.createTest("Search Selenium Test");
	  driver.get("https:\\google.co.in/");
	  
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("Selenium tutorial");
		
		searchBox.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "Selenium tutorial - Google Search");
		  
  }
  
  @AfterMethod
  public void tearDown(ITestResult result) throws IOException //throws IOException
  {
	  if(ITestResult.FAILURE == result.getStatus())
	  {
		  String path = Utility.getScreenshotPath(driver);
		  extentTest.fail(result.getName());
		  extentTest.fail(result.getThrowable().getMessage());		  
		  extentTest.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  }	  
	  
	  driver.close();
  }

  
  @AfterTest
  public void FlushExtent()
  {  
  reports.flush();	  
	  
  }
  

}
