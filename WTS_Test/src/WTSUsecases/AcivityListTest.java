package WTSUsecases;

import java.net.MalformedURLException;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;




//Webdriver and TestNG imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ApplicationPages.ActivitiesPage;
import ApplicationPages.ActivityListPage;
//Framework and Factory imports
import ApplicationPages.LoginPage;
import Framework.Application;
import Framework.Browser;
import Framework.Utilities;
import WTSUsecases.AcivityListProperties;
import WTSUsecases.XlsReader;
import WTSUsecases.AcivityListFactory;

public class AcivityListTest {
	
	public Framework.Browser Browser;
	private AcivityListProperties properties; 

	public AcivityListTest(AcivityListProperties newProp) {
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
		Linkstoactivitypage();
		selectactivity_disable();
	}

	private void loginToWTS() {
	
		this.Browser = LoginPage.applogin(this.Browser, properties.COMPANY, properties.USERNAME, properties.PASSWORD);
	}
	
	private void Linkstoactivitypage() {
		
		this.Browser = ActivityListPage.Linksfor_Activity(this.Browser);
		
	/*	WebElement btn = SearchHotelPage.verifycontinuebtn(Browser);
		Boolean result;
		if (btn.equals(null))
		{
			result = false;
		}
		else
		{
			result = true;
		}
		Assert.assertTrue(result, "Submit button was not clicked or the page was not refreshed");*/
	}
	
	private void selectactivity_disable()
	{
		this.Browser = ActivityListPage.selectactivitydisable(this.Browser);
		 
	}
	

	
	

}
