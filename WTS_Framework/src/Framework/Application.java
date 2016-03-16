package Framework;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import Framework.Browser;
import Framework.Utilities;

public class Application 
{
	public static Browser go( Browser browser, String appUrl) {
		browser.driver.get(appUrl);
		return browser;
}



public static void CloseBrowser(Browser browser){
	try{
		String parentWindow = browser.driver.getWindowHandle();
		Set<String> handles =  browser.driver.getWindowHandles();
		if(handles.size() >= 1 ){
		   for(String windowHandle  : handles)
		     {
			   browser.driver.switchTo().window(windowHandle);
			   browser.driver.close();  
		          }
		     }
		
} catch (Exception e) {
	e.printStackTrace();
	}
}

}