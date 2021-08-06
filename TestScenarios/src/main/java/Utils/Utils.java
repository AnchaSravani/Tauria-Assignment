package Utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Utils.LoadPropertiesFile.prop;

import java.io.File;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import Config.BaseClass;

public class Utils extends BaseClass {
	
	public void ClickOnElement(By ele)
	{
		webriverwait(ele);
		driver.findElement(ele).click();
	}
	
	public void EnterText(By ele, String value)
	{
		webriverwait(ele);
		driver.findElement(ele).sendKeys(value);
		
	}
	
	public static void webriverwait(By ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	
	
	public static int factorial(int n)
	{
		 
		if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 }  
	
	public static String RandomValue()
	{
		  String RandomValue = RandomStringUtils.randomAlphabetic(10);
	  
		    return(RandomValue);
		   
	}
	
	public static String getRootDir() {
		File path = new File("");
		String absPath = path.getAbsolutePath();
		File dir = new File(absPath);
		String rootDir = dir.getParent();
		
		return absPath;

	}
}
