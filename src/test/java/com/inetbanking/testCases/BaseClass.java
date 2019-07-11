package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	  ReadConfig readconfig=new ReadConfig();
	  
	  
	public String baseUrl=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	
	

	public static Logger logger;
	public static WebDriver driver;
    @Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{
				
		 logger=Logger.getLogger("Web Base Banking"); 
		PropertyConfigurator.configure("Log4j.properties");
		
		
		
		if(br.equals("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();	
		}
		else if(br.equals("firefox")) 
			{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();	
			}

		else if(br.equals("ie")) 
		{
		System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
		driver=new InternetExplorerDriver();	
		}
		
		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	@AfterClass              
	public void teardown()
	{
		driver.close();
	}
	
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenSHot has been taken");
	}
	public String randomString()
	{
		
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public String randomNum()
	{
		
		String genratedNumeric=RandomStringUtils.randomNumeric(6);
		return genratedNumeric;
	
	}
	public String randomNum1()
	{
		String generatedNumeric1=RandomStringUtils.randomNumeric(10);
		return generatedNumeric1;
	}
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	
	
	
	
	}	
}
