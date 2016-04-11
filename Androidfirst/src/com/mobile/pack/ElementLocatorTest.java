package com.mobile.pack;
import java.net.MalformedURLException; 
import java.net.URL; 
import java.util.List;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.openqa.selenium.remote.RemoteWebDriver; 

import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test;

public class ElementLocatorTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "Android Emulator");
		c.setCapability("browserName", "Andriod");
		c.setCapability("platformVersion", "5.1");
		c.setCapability("platformName", "Android");
		c.setCapability("appPackage", "com.android.calculator2");
		c.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
	}
	@Test
	public void sum()
	{
		try{
			driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
			driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
			List<WebElement> list1 = driver.findElements(By.xpath("//android.widget.Button"));
			list1.get(16).click();
			/*	int x = list1.size();
			System.out.println(x);
			for(int i=0;i<x;i++)
			{
				String ele = list1.get(i).getText();
				System.out.println(ele);
			}*/
			driver.findElement(By.id("com.android.calculator2:id/digit5")).click();
			driver.findElement(By.name("=")).click();
			String result = driver.findElement(By.className("android.widget.EditText")).getText();
			System.out.println("The result of 2 + 5 = " + result);	
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@AfterTest
	public void last(){
		driver.quit();
	}
}
