package TestCases;

import static Utils.LoadPropertiesFile.prop;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Config.BaseClass;
import junit.framework.Assert;

public class RegistrationFlow extends BaseClass{
	
	@Test(priority=1)
	@Parameters("Registration")
	public void SetUp(String Url) throws InterruptedException
	{
	
		String s= Utils.Utils.getRootDir();
		System.setProperty("webdriver.chrome.driver", s+"\\Config\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(Url);
		driver.manage().window().maximize();
		String UrlToNavigate =prop.getProperty(Url);
		System.out.println("Url to navigate is " +UrlToNavigate);
		driver.get(UrlToNavigate);
		
	}
	
	@Test(priority=2)
	public void Signin() throws InterruptedException
	
	{
		Utils.Utils u = new Utils.Utils();
		String Email=Utils.Utils.RandomValue()+"@yopmail.com";
		String BusinessName=Utils.Utils.RandomValue();
		Utils.Utils.webriverwait(By.xpath(prop.getProperty("CreateOne")));
		driver.findElement(By.xpath(prop.getProperty("CreateOne"))).click();
		u.EnterText(By.id(prop.getProperty("BusinessName")), BusinessName);
		driver.findElement(By.xpath(prop.getProperty("NextButton"))).click();
		Utils.Utils.webriverwait(By.id(prop.getProperty("first")));
		u.EnterText(By.id(prop.getProperty("first")),prop.getProperty("FirstName"));
		u.EnterText(By.id(prop.getProperty("last")),prop.getProperty("LastName"));
		u.EnterText(By.id(prop.getProperty("Email")),Email);
		driver.findElement(By.xpath(prop.getProperty("NextButton"))).click();
		u.EnterText(By.id(prop.getProperty("Password")),prop.getProperty("PasswordValue"));
		u.EnterText(By.id(prop.getProperty("confirmpassword")),prop.getProperty("PasswordValue"));
		driver.findElement(By.xpath(prop.getProperty("NextButton"))).click();
		Thread.sleep(50000);
		Utils.Utils.webriverwait(By.xpath(prop.getProperty("WhatDoYouLikeToStart")));
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("WhatDoYouLikeToStart"))).isDisplayed());
		
	}
}
