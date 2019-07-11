package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")       @CacheLookup WebElement lnkAddNewCUstomer;
	@FindBy(xpath="//input[@name='name']") 							@CacheLookup WebElement  textCustomerName;
	@FindBy (xpath="//tr[5]//td[2]//input[1]") @CacheLookup WebElement chkboxGender;
	@FindBy (xpath="//input[@id='dob']") @CacheLookup WebElement txtDOB;
	@FindBy (xpath="//textarea[@name='addr']") @CacheLookup WebElement txtAddress;
	@FindBy (xpath="//input[@name='city']") @CacheLookup WebElement textCity;
	@FindBy (xpath="//input[@name='state']") @CacheLookup WebElement txtState;
	@FindBy (xpath="//input[@name='pinno']") @CacheLookup WebElement txtPin;
	@FindBy (xpath="//input[@name='telephoneno']") @CacheLookup WebElement txtMobileNmbr;
	@FindBy (xpath="//input[@name='emailid']") @CacheLookup WebElement txtEmail;
	@FindBy (xpath="//input[@name='password']") @CacheLookup WebElement txtPassword;
	@FindBy (xpath="//input[@name='sub']") @CacheLookup WebElement btnSubmit;
	@FindBy (xpath="//input[@name='res']") @CacheLookup WebElement btnReset;

	public void clickAddNewCUstomer()
	{
		lnkAddNewCUstomer.click();
	}
	public void customerName(String cname)
	{
		textCustomerName.sendKeys(cname);
	}
	public void custGender(String cgender)
	{
		chkboxGender.click();
	}
	public void custDOB( String mm,String dd,String yyyy)
	{
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yyyy);		
	}
	public void custAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	public void custCity(String ccity)
	{
		textCity.sendKeys(ccity);
	}
	public void custState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	public void custPin(String cpin)
	{
		txtPin.sendKeys(String.valueOf(cpin));
	}
	public void custMobileNmbr(String cmobile)
	{
		txtMobileNmbr.sendKeys(cmobile); 
	}
	public void custEmail(String cemail)
	{
		txtEmail.sendKeys(cemail);
	}
	public void custPassword(String cpwd)
	{
		txtPassword.sendKeys(cpwd);
	}
	public void btnSubmit()
	{
		btnSubmit.click();
	}
	public void btnReset()
	{
		btnReset.click();
	}
	
}
