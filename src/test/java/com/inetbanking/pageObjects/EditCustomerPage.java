package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="/html/body/div[2]/div/div/ul/li[3]/a") @CacheLookup WebElement  lnkEditCustomer;
	@FindBy(xpath="//input[@name='cusid']" )@CacheLookup WebElement EditCustomer;
	@FindBy(xpath="//input[@name='AccSubmit']" )@CacheLookup WebElement btnSubmit;
	
	public void clickEDitCustomer()
	{
		lnkEditCustomer.click();
	}
	public void EditCustomer()
	{
		EditCustomer.sendKeys("51801");
	}
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	
}
