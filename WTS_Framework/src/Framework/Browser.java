package Framework;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser 
{
	public WebDriver driver;
	public void getDriver() throws MalformedURLException 
	{
		if (driver == null) 
		{
			//Enable below two lines to make your browser run locally 
			driver = new  FirefoxDriver();
			driver.manage().window().maximize();
			
			//Enable below 8 lines if we need the browser to run on server - Selenium Grid
			/*DesiredCapabilities browser = DesiredCapabilities.firefox();
			try 
			{
				driver = new RemoteWebDriver(new URL("http:r/10.77.41.47:4444/wd/hub"), browser);
			} 
			catch (MalformedURLException e) {
				e.printStackTrace();	
			} */
			
		}
		
	}
	public void closeDriver() 
	{

		if (driver == null) 
		{
			driver.close();
		}
	}
}
