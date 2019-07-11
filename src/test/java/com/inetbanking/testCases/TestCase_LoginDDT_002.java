package com.inetbanking.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.EXLUtils;


public class TestCase_LoginDDT_002 extends BaseClass 
{
@Test(dataProvider="logindata")
	public void loginDDt(String user,String pwd) throws IOException  
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit(); 
		
		
		if(isAlertPresent()==true)
		{
			captureScreenshot(driver,"loginDDt");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else if(isAlertPresent()==false)
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			
			lp.clickLogout();
			
			driver.switchTo().alert().accept();//close Logout alert
			driver.switchTo().defaultContent();
		}
	}



@DataProvider(name="logindata")
	public String[][] getData() throws IOException
	{
/*		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	
		int rownum=EXLUtils.getRowCount(path,"Sheet1");
		int cellcount=EXLUtils.getCellCount(path,"Sheet1",1);
	
	String logindata[][]=new String[rownum][cellcount];
	
	for (int i=1;i<=rownum;i++)
	{
		for(int j=0;j<cellcount;j++)
		{
			logindata[i-1][j]=EXLUtils.getCellData(path,"Sheet1",i,j);
		}
	}
	return logindata;
	}*/
		return new String[][] {{"mngr205904","gYpugYr"},{"mgr205904","gYpugYr"},
			{"mngr20904","gYpugYr"}
		,{"mngr205904","gYpugYr"}
		,{"mngr205904","gYpgYr"}};
	}
}

