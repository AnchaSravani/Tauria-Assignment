package TestCases;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Config.BaseClass;
import Utils.Utils;
import junit.framework.Assert;

import static Utils.LoadPropertiesFile.prop;

import java.io.File;


public class FactorialVerification extends BaseClass {
	

	
	
	@Test(priority=1)
	@Parameters("Factorial")
	public void SetUp(String Url) throws InterruptedException
	{
		String s= Utils.getRootDir();
		System.setProperty("webdriver.chrome.driver", s+"\\Config\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(Url);
		driver.manage().window().maximize();
		String UrlToNavigate =prop.getProperty(Url);
		System.out.println("Url to navigate is " +UrlToNavigate);
		driver.get(UrlToNavigate);
		
	}
	
	@Test(priority=2)
	public void enterValidInput()
	{
		By InputField = By.id(prop.getProperty("InputFile"));
		String VaildInput=prop.getProperty("ValidInput");
		driver.findElement(InputField).sendKeys(VaildInput);
		By CalculateButton = By.xpath(prop.getProperty("CalculateButton"));
		driver.findElement(CalculateButton).click();
	}
	
	@Test(priority=3)
	public void VerifyOutput() throws InterruptedException
	{
		Thread.sleep(1000);
		By Output = By.xpath(prop.getProperty("Output"));
		String[] output=driver.findElement(Output).getAttribute("innerHTML").split(":");
		int factCal=Utils.factorial(Integer.parseInt(prop.getProperty("ValidInput")));
		String s=output[1].trim();
        String t=String.valueOf(factCal);
        System.out.println(s);
        System.out.println(t);
        Assert.assertEquals(s, t);
//        try {
//        	if(s.equalsIgnoreCase(t))
//        	{
//        		System.out.println("both are equal");
//        	}
//        	catch(Exception e)
//            {
//            	System.out.println("Wrong output");
//            }
//        }
       
	}
	
	}

