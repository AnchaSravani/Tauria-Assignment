package Config;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeSuite
	public void intialize() throws IOException
	{
		Utils.LoadPropertiesFile t = new Utils.LoadPropertiesFile();
		t.Load();
	}
	
	@AfterSuite
	public void CloseBrowser()
	{
		driver.close();
	}
}
