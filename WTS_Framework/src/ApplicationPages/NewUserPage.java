package ApplicationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Browser;
import Framework.Utilities;

public class NewUserPage {
	
	public static Framework.Utilities Utility = new Utilities();
		public static Browser links_User(Browser browser)
	{
		try{
			administrationlink(browser);
			Userslink(browser);		
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return browser;
	}
	
	
	public static Browser AddingnewUser_1(Browser browser, String firstname, String lastname, String loginname, String userpwd)
	{
		try{
			AddUserButton(browser);
			FirstnameText(browser, firstname);
			Lastnametxt(browser, lastname);
			Loginname(browser, loginname);
			Userpassword(browser, userpwd);
			Forcepasswordcheck(browser);
			SaveUserProfilebtn(browser);
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return browser;
	}
	
	public static Browser AddingnewUser_2(Browser browser, String userrole)
	{
		try{
			LeftnavRolesandPermissions(browser);
			SelectUserrole(browser, userrole);
			SaveRolesandPermissionsbtn(browser);
			LeftnavTimesheetslink(browser);

		}catch (Exception e)
		{
			System.out.println(e);
		}
		return browser;
	} 
	
	public static void administrationlink(Browser browser)
	{
		try{
			Boolean result;
			Thread.sleep(30000);
			result=Utility.isElementPresentByXpath(browser, "//*[@id='menuItems']/li[9]/a");
			if (result == true)
			{
			WebElement adminlink = Utility.FindElementByXpathwithwait(browser, "//*[@id='menuItems']/li[9]/a");
			adminlink.click();
			}
			else
			{
				System.out.println("Element not found");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void Userslink(Browser browser)
	{
		try{
			WebElement userlink = Utility.FindElementByXpathwithwait(browser, "//a[contains(text(), 'Users')]");
			userlink.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void AddUserButton(Browser browser)
	{
		try{
			WebElement adduserbtn = Utility.FindElementByXpathwithwait(browser, "//input[@id='addNewButton']");
			adduserbtn.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void FirstnameText(Browser browser, String firstname)
	{
		try{
			WebElement fnametxt = Utility.FindElementByXpathwithwait(browser, "//input[@id='PersonalInformation_ctl03']");
			fnametxt.sendKeys(firstname);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void Lastnametxt(Browser browser, String lastname)
	{
		try{
			WebElement lnametxt = Utility.FindElementByXpathwithwait(browser, "//input[@id='PersonalInformation_ctl05']");
			lnametxt.sendKeys(lastname);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
/*	public static void Pickstartdate(Browser browser, String startdate)
	{
		try{
			WebElement start_date = Utility.FindElementByXpathwithwait(browser, "//input[@id='PersonalInformation$ctl13$datePicker$input']");
			start_date.sendKeys(startdate);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	} */
	
	public static void Loginname(Browser browser, String login)
	{
		try{
			WebElement login_nametxt = Utility.FindElementByXpathwithwait(browser, "//input[@id='Login_ctl03']");
			login_nametxt.sendKeys(login);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void Userpassword(Browser browser, String Upassword)
	{
		try{
			WebElement user_passwordtxt = Utility.FindElementByXpathwithwait(browser, "//input[@name='Login$ctl07']");
			user_passwordtxt.sendKeys(Upassword);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void Forcepasswordcheck(Browser browser)
	{
		try{
			WebElement checkforcepwd = Utility.FindElementByXpathwithwait(browser, "//*[@id='Login_ctl09']");
			Boolean check;
			check=checkforcepwd.isSelected();
			if(check==false)
			{
				checkforcepwd.click();
				System.out.println("Checkbox is unchecked");
			}
			else
			{
				System.out.println("Checkbox is already unchecked");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void SaveUserProfilebtn(Browser browser)
	{
		try{
			WebElement saveuserbtn = Utility.FindElementByXpathwithwait(browser, "//button[@id='save']");
			saveuserbtn.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void LeftnavRolesandPermissions(Browser browser)
	{
		try{
			WebElement rolepermission = Utility.FindElementByXpathwithwait(browser, "//*[@id='RoleAndPermission']/a");
			rolepermission.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void SelectUserrole(Browser browser, String userrole)
	{
		try{
			WebElement role = Utility.FindElementByXpathwithwait(browser, "//a[@id='userSelect']");
			role.click();
			WebElement role1 = Utility.FindElementByXpathwithwait(browser, "//a[contains(text(), 'Basic User')]");
			role1.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void SaveRolesandPermissionsbtn(Browser browser)
	{
		try{
			WebElement saverolesbtn = Utility.FindElementByXpathwithwait(browser, "//input[@id='saveRolesAndPermission']");
			saverolesbtn.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void LeftnavTimesheetslink(Browser browser)
	{
		try{
			WebElement timsheetslink = Utility.FindElementByXpathwithwait(browser, "//a[contains(text(), 'Timesheets')]");
			timsheetslink.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}

	
}
