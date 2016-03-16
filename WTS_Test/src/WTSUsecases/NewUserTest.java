package WTSUsecases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;




//Webdriver and TestNG imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ApplicationPages.NewUserPage;
//Framework and Factory imports
import ApplicationPages.LoginPage;
import Framework.Application;
import Framework.Browser;
import Framework.Utilities;
import WTSUsecases.NewUserProperties;
import WTSUsecases.XlsReader;
import WTSUsecases.NewUserFactory;

public class NewUserTest {
	
	public Framework.Browser Browser;
	private NewUserProperties properties;
	
	public NewUserTest(NewUserProperties newProp) {
		this.properties = newProp;
	}
	
	@BeforeClass
	public void beforeClass(){
		Browser = new Framework.Browser();
		try {
			Browser.getDriver();
			
		} 
		catch (MalformedURLException e) {
			
			System.out.println(e.getMessage());
			} 
		}
	
	@AfterClass
	public void afterClass() 
	{
		//Application.CloseBrowser(this.Browser);
	}
	
	@Test(description ="Execute test")
	public void executeTest() throws InterruptedException
	{
		this.Browser = Application.go(Browser, properties.APPURL);
		loginToWTS();
		Clicklinks();
		AddingNewUser_Page1();
		AddingNewUser_Page2();
		AddingNewUser_Page3();
		User_Timesheet();
	}

	private void loginToWTS() {
	
		this.Browser = LoginPage.applogin(this.Browser, properties.COMPANY, properties.USERNAME, properties.PASSWORD);
	}

	private void Clicklinks()
	{
		this.Browser = NewUserPage.links_User(this.Browser);
	}
	
	private void AddingNewUser_Page1()
	{
		this.Browser = NewUserPage.AddingnewUser_1(this.Browser, properties.FIRSTNAME, properties.LASTNAME, properties.LOGINNAME, properties.USERPASSWORD, properties.STARTDATE);
	}
	
	private void AddingNewUser_Page2()
	{
		this.Browser = NewUserPage.AddingnewUser_2(this.Browser, properties.USERROLE);
	}
	
	private void AddingNewUser_Page3()
	{
		this.Browser = NewUserPage.AddingnewUser_3(this.Browser);
	}
	
	private void User_Timesheet()
	{
		this.Browser = NewUserPage.UserTimesheet(this.Browser);
	}
}
