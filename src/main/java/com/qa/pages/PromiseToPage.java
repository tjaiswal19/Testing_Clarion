package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PromiseToPage {
	
	WebDriver driver;
	
	@FindBy(name="btnSearch")
	WebElement searchbtn;
	
	public PromiseToPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	public void verifyPromiseAdded(String promisor)
	{
		Select select = new Select(driver.findElement(By.id("cboEmp")));
		select.selectByVisibleText(promisor);
		searchbtn.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a/b[contains(text(),'Promise From')]")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Last>>")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
	}
	


}



