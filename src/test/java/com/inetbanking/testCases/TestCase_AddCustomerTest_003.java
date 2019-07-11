package com.inetbanking.testCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TestCase_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addnewCustomer() throws IOException, Exception  
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
	
		
		AddCustomerPage  addcust=new AddCustomerPage (driver);
		addcust.clickAddNewCUstomer();
		Thread.sleep(2000);
		addcust.customerName(randomString());
		Thread.sleep(2000);
		logger.info("username  is provided");
		Thread.sleep(2000);
		addcust.custGender("male");
		Thread.sleep(2000);
		addcust.custDOB("10","15","1992");
		Thread.sleep(2000);
		addcust.custAddress("INDIA");
		Thread.sleep(2000);
		addcust.custCity(randomString());
		Thread.sleep(2000);
		addcust.custState("TAMILNADU");
		Thread.sleep(2000);
		addcust.custPin(randomNum());
		Thread.sleep(2000);
		Thread.sleep(2000);
		addcust.custMobileNmbr(randomNum1());
		Thread.sleep(2000);
		addcust.custEmail(randomString()+"@gmail.com");
		Thread.sleep(2000);
		addcust.custPassword(randomString());
		
		Thread.sleep(3000);
		logger.info("clicking on  submit button");
		Thread.sleep(2000);
		addcust.btnSubmit();
		logger.info("validation has been started");
		
		if(isAlertPresent()==true)
		{
			logger.warn("login failed");
			driver.switchTo().alert().accept();
			logger.info("alert is aceepted");
			Assert.assertTrue(false);
			
		}
		else if(isAlertPresent()==false)
		{
			
			Thread.sleep(5000);
			captureScreenshot(driver,"AddCustomerTest");
			Assert.assertTrue(driver.getPageSource().contains(driver.findElement(By.xpath("//p[@class='heading3']")).getText()));
			logger.info("Login Passed");
		
		}
	}
	
	
	}
	
	

