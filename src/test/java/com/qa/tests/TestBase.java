package com.qa.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LogPromice;
import com.qa.pages.LoginPage;
import com.qa.pages.PromiseToPage;

public class TestBase 
{

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	LogPromice logPromice;
	PromiseToPage objpromiseToPage;
	
	String url= "http://182.74.238.221/clarion_promise_qa/home.php";
	
	@BeforeTest()
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Testing Setup\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		}
	
	@Test(priority=1)
	public void verifyValidationMessage()
	{ 	loginPage = new LoginPage(driver);
		loginPage.loginBtn.click();
		String expectedmsg = "Invalid Username/password";
		String actualmsg = driver.findElement(By.xpath("//*[contains(text(),'Invalid Username/password')]")).getText();
		
		Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	@Test(priority=2)
	public void verifyLogin()
	{ 	
		loginPage = new LoginPage(driver);
		 loginPage.clicklogin("sanjeetk@clariontechnologies.co.in","clarion");
		//Assert.assertTrue(isUserLoggedInSuccessfully(), "User failed to login");
	}
	
	@Test(priority=3)
	public void verifyLogPromiseLink()
	
	{	homePage = new HomePage(driver);
		//homePage.clickOnPromiseLog();
		Assert.assertTrue(homePage.clickOnLogPromiseLink());
	}
	
	@Test(priority=4)
	public void addPromiseTest()
	{
		logPromice = new LogPromice(driver);
		logPromice.addPromise("Sonali test", "Testing new demo is added by tj new");
	}
	
	@Test(priority=5)
	public void verifyPromiseAddedTest()
	{
		objpromiseToPage = new PromiseToPage(driver);
		objpromiseToPage.verifyPromiseAdded("Sonali test");
		
	}
	
	
	@Test(priority=6)
	public void verifylogout()
	{
		driver.findElement(By.xpath("//a/b[contains(text(),'LOGOUT')]")).click();
		
		
	}
	@AfterTest()
	public void terminateBrowser() {
		driver.close();
	}
}
