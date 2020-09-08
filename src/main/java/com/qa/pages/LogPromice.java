package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LogPromice {
	
	WebDriver driver;
	
	@FindBy(xpath="//textarea[@id='txtPromise']")
	WebElement enterPromise;
	
	@FindBy(id="btnSubmit")
	WebElement logPromiseBtn;
	
	
	
	public LogPromice(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	public void addPromise(String promiseFrm, String promise)
	{
		Select select = new Select(driver.findElement(By.name("cboEmp")));
		select.selectByVisibleText(promiseFrm);
		enterPromise.sendKeys(promise);
		logPromiseBtn.click();
	}
	
	
	
	
}



