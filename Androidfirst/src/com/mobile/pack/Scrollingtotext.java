package com.mobile.pack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Scrollingtotext {

	AndroidDriver driver;
	Dimension size;
	WebDriverWait w;
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "ZX1B325TV4");
		c.setCapability("platformVersion", "4.4.4");
		c.setCapability("BrowserName", "Android");
		c.setCapability("platformName", "Android");
		c.setCapability("appPackage", "io.appium.android.apis");
		c.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void scrolltext()
	{
		try{
			driver.scrollTo("Views");
			driver.findElementByName("Views").click();
			System.out.println("Scrolling has started to find the text tabs");
			driver.scrollTo("Tabs");
			driver.findElementByName("Tabs").click();
			
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	@AfterTest
	public void end()
	{
		driver.quit();
	}
}
