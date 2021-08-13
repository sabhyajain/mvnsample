package dataTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataTest
{
	
WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginData() throws IOException
	{
		driver.get("https://the-internet.herokuapp.com/login");
		
		//driver.findElement(By.id("username")).sendKeys(getExcelData("userName"));
		driver.findElement(By.xpath(getExcelObj("txtusername"))).sendKeys(getExcelData("userName"));
		
		//driver.findElement(By.id("password")).sendKeys(getExcelData("password"));
		driver.findElement(By.xpath(getExcelObj("txtpassword"))).sendKeys(getExcelData("password"));
		
		driver.findElement(By.xpath(getExcelObj("loginbtn"))).click();
		
		boolean isLoginSuccess = driver.findElement(By.xpath("//div[@class='flash success']")).isDisplayed();
		Assert.assertTrue(isLoginSuccess);			
}
	
	public String getExcelData(String colName) throws IOException
	{
		String colValue = "";
		String path = System.getProperty("user.dir") + "//src//test//resources//testData.xlsx";
		
		FileInputStream fin = new FileInputStream(path);
		//.xlsx - XSSF..
		//.xls - HSSF..
		
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet loginSheet = workbook.getSheet("loginData");
		
		int numRow = loginSheet.getLastRowNum();
		System.out.println("Number of Rows : " + numRow);
		
		for(int i=1; i<= numRow; i++)
		{
			XSSFRow row = loginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(colName))
			{
				colValue = row.getCell(1).getStringCellValue();
			}
		}		
		return colValue;
	}
	
	public String getExcelObj(String elementName) throws IOException
	{
		String elementPath = "";
		String path = System.getProperty("user.dir") + "//src//test//resources//testData.xlsx";
		
		FileInputStream fin = new FileInputStream(path);
		//.xlsx - XSSF..
		//.xls - HSSF..
		
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet loginSheet = workbook.getSheet("loginObjRepo");
		
		int numRow = loginSheet.getLastRowNum();
		System.out.println("Number of Rows : " + numRow);
		
		for(int i=1; i<= numRow; i++)
		{
			XSSFRow row = loginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(elementName))
			{
				elementPath = row.getCell(1).getStringCellValue();
			}
		}		
		return elementPath;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
