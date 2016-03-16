package ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Browser;
public class LoginPage {

	public static Browser applogin(Browser browser, String companyname, String username, String password)
	{
		try{
			WebElement companynamefield = logincompanyname(browser);
			companynamefield.sendKeys(companyname);
			
			WebElement  useridfield = loginusername(browser);
			useridfield.sendKeys(username); 
			
			WebElement  passwordfield = loginpassword(browser);
			passwordfield.sendKeys(password); 
			
			WebElement  loginbutton = loginbutton(browser);
			loginbutton.click();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return browser;
	}
	
	public static WebElement logincompanyname(Browser browser)
	{
		try{
			WebElement compname = browser.driver.findElement(By.xpath("//*[@id='CompanyNameTextBox']"));
			return compname;
			
		}catch (Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public static WebElement loginusername(Browser browser)
	{
		try{
			WebElement username = browser.driver.findElement(By.xpath("//*[@id='LoginNameTextBox']"));
			return username;
			
		}catch (Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public static WebElement loginpassword(Browser browser)
	{
		try{
			WebElement password = browser.driver.findElement(By.xpath("//*[@id='PasswordTextBox']"));
			return password;
			
		}catch (Exception e){
			System.out.println(e);
		}
		return null;
		
	}
	
	public static WebElement loginbutton(Browser browser)
	{
		try{
			WebElement loginbtn = browser.driver.findElement(By.xpath("//*[@id='LoginButton']"));
			return loginbtn;
			
		}catch (Exception e){
			System.out.println(e);
		}
		return null;
		
	}
}
