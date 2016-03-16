package ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Browser;
import Framework.Utilities;

public class ActivityListPage {
	
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
	
	public static Browser selectactivitydisable (Browser browser)
	{
		try{
			selectactivity(browser);
			Disableactivity(browser);
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
			WebElement adminlink = (new WebDriverWait (browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Administration")));
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
	
	public static void addnewactivity_savebtn(Browser browser)
	{
		try{
			//Thread.sleep(100000);
			WebElement Addactivitysave= (new WebDriverWait(browser.driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='save']")));
			Addactivitysave.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void selectactivity(Browser browser)
	{
		try{
			
			WebElement sactivity = (new WebDriverWait(browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Coding")));			
			sactivity.click();
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void Disableactivity(Browser browser)
	{
		try{
			WebElement enablecheck = (new WebDriverWait(browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@id='MainLayout_ctl09']")));
			Boolean checkstatus;
			checkstatus = enablecheck.isSelected();
			if(!checkstatus==true)
			{
				enablecheck.click();
				System.out.println("Checkbox is unchecked");
			}
			else
			{
				System.out.println("Checkbox is already unchecked");
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
