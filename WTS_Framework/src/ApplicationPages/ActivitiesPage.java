package ApplicationPages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Browser;
public class ActivitiesPage {
	
	public static Browser Linksfor_Activity (Browser browser)
	{
		try{
		administrationlink(browser);
		Activitieslink(browser);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return browser;
	}
	
	public static Browser addnewactivity (Browser browser, String name, String code, String desc)
	{
		try{
		AddActivitybutton(browser);
		addnewactivity_name(browser, name);
		addnewactivity_code(browser, code);
		addnewactivity_description(browser, desc);
		selectingusertoassignactivity(browser);
		moveusertoassigned(browser);
		addnewactivity_savebtn(browser);		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return browser;
	}
	
	public static void administrationlink(Browser browser)
	{
		try{
			WebElement adminlink = (new WebDriverWait (browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Administration')]")));
			adminlink.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void Activitieslink(Browser browser)
	{
		try{
			WebElement Activitylink = (new WebDriverWait (browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Activities')]")));
			Activitylink.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void AddActivitybutton(Browser browser)
	{
		try{
			WebElement Addactivitybtn = (new WebDriverWait(browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='addNewButton']")));
			Addactivitybtn.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void addnewactivity_name(Browser browser, String name)
	{
		try{
			WebElement Addactivityname = (new WebDriverWait(browser.driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name, 'MainLayout$ctl03')]")));
			Addactivityname.sendKeys(name);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void addnewactivity_code(Browser browser, String code)
	{
		try{
			WebElement Addactivitycode = (new WebDriverWait(browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name, 'MainLayout$ctl05')]")));
			Addactivitycode.sendKeys(code);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
	public static void addnewactivity_description(Browser browser, String description)
	{
		try{
			WebElement Addactivitydesc= (new WebDriverWait(browser.driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[contains(@name, 'MainLayout$ctl07')]")));
			Addactivitydesc.sendKeys(description);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void selectingusertoassignactivity (Browser browser)
	{
		try{
			WebElement useractivity = (new WebDriverWait(browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@name, 'MainLayout$ctl11$ctl01')]")));
			Select activityselect = new Select(useractivity);
			activityselect.deselectAll();
			List <WebElement> selectallusers = activityselect.getOptions();
			for(WebElement list1 : selectallusers)
			{
				activityselect.selectByVisibleText(list1.getText());
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void moveusertoassigned(Browser browser)
	{
		try{
			
			WebElement movetoassignedusers = browser.driver.findElement(By.xpath("//button[@id='MainLayout_ctl11_ctl04']"));
			movetoassignedusers.click();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void addnewactivity_savebtn(Browser browser)
	{
		try{
			Thread.sleep(100000);
			WebElement Addactivitysave= (new WebDriverWait(browser.driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='save']")));
			Addactivitysave.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
}
