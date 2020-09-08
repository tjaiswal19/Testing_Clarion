package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText="Log Promise")
	WebElement logPromiseLink;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean clickOnLogPromiseLink()
	{
		logPromiseLink.click();
		return true;
		
		
	}
	
	
	
	
}
