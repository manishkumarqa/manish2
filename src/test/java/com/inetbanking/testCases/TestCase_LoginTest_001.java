package com.inetbanking.testCases;

import java.io.IOException;


import org.testng.Assert;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TestCase_LoginTest_001 extends BaseClass

{
	@Test
	public void loginTest() throws Exception  
	{
		
		
		logger.info("URL is Opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("ENtered Password");
		lp.clickSubmit();
		
	
if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
{
	Assert.assertTrue(true);
	logger.info("Test Passed");
}
else 
{
	captureScreenshot(driver,"loginTest");
	Assert.assertTrue(false);
	logger.info("Test Failed");
} 
		
		
	}
	

}
