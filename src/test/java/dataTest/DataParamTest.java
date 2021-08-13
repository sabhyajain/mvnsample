package dataTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataParamTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="loginData")
	public void loginTest(String strUser, String strPwd)
	{
		driver.get("https://the-internet.herokuapp.com/login");
		
		driver.findElement(By.id("username")).sendKeys(strUser);
		driver.findElement(By.id("password")).sendKeys(strPwd);
		driver.findElement(By.xpath("//button[@class='radius']")).click();
		
		boolean isLoginSuccess = driver.findElement(By.xpath("//div[@class='flash success']")).isDisplayed();
		
		Assert.assertTrue(isLoginSuccess);	
		
	}
	
	//user1 - testuser1, welcome123 - user[1][1], user[1][2]
	//user2 - testuser2, welcome123
	//user3 - tomsmith, SuperSecretPassword!
	
/*	@DataProvider(name = "loginData") // if no name given the method name by defalut 
	public Object[][] getData()
	{
		return new Object[][] {
			
			new Object[] {"testuser1" , "welcome123"},
			new Object[] {"testuser2" , "welcome123"},
			new Object[] {"tomsmith" , "SuperSecretPassword!"},
		};		
	} */
	
	/* @DataProvider(name = "loginData") // if no name given the method name by defalut 
	public Object[][] getData() throws CsvValidationException, IOException
	{
	
		String path = System.getProperty("user.dir") + "//src//test//resources//loginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		
		String[] col;
		ArrayList<Object[]> datalist = new ArrayList<Object[]>();
		while((col=reader.readNext()) != null)
		{
			Object[] record = {col[0], col[1]};
			datalist.add(record);
			}
		reader.close();		
		
		System.out.println("Number of records : " + datalist.size());
		
		return datalist.toArray(new Object[datalist.size()][]);	
	} */

	// //body/div[@id='gb-main']/div[@id='outer']/div[@id='main']/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]
	
	@DataProvider(name = "loginData") // if no name given the method name by defalut 
	public String[][] getData() throws IOException, ParseException 
	{
		String path = System.getProperty("user.dir") + "//src//test//resources//loginData.json";
		FileReader reader = new FileReader(path);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		
		JSONObject jsonObject = (JSONObject)obj;
		
		JSONArray userArray = (JSONArray)jsonObject.get("userLogins");
		
		String arr[][] = new String[userArray.size()][];
		
		for(int i=0; i< userArray.size(); i++)
		{
			JSONObject user = (JSONObject)userArray.get(i);
			String strUser = (String)user.get("username");
			String strPwd = (String)user.get("password");
			String record[] = new String[2];
			record[0] = strUser;
			record[1] = strPwd;
			arr[i] = record;
			
		}
		return arr;
	
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.close();
	}
}
