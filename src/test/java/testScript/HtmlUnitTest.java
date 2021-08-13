package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HtmlUnitTest 
{
	WebDriver driver;
	
	@Test
	public void test() 
	{	
	
	driver = new HtmlUnitDriver();
	
	driver.get("https://google.co.in/");
	
	WebElement searchBox = driver.findElement(By.name("q"));
	
	searchBox.sendKeys("Java tutorial");
	searchBox.sendKeys(Keys.ENTER);
	
	System.out.println("Paga Title : " + driver.getTitle());
	
	Assert.assertEquals(driver.getTitle(),  "Java tutorial - Google Search");
			
	}
	
}
