package com.mobile.pack;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultiTouch {
	
	AndroidDriver driver;
	Dimension size;

	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "ZX1B325TV4");
		c.setCapability("browserName", "Android");
		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "4.4.4");
		c.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		c.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void multitouchtest()
	{
		try{
			
			size = driver.manage().window().getSize();
			
			//For touch1
			int x1 = (int) (size.width *0.20);
			int y1 = (int) (size.height * 0.20);
			
			//For Touch2
			
			int x2 = (int) (size.width * 0.80);
			int y2 = (int) (size.height * 0.20);
			
			//Touch 3
			
			int x3 = (int) (size.width * 0.20);
			int y3 = (int) (size.height * 0.80);
			
			//Touch4
			
			int x4 = (int) (size.width * 0.80);
			int y4 = (int) (size.height * 0.80);
			
			//Touch3
			int x5 = size.width/2;
			int y5 = size.height/2;
			
			MultiTouchAction m = new MultiTouchAction ((MobileDriver) driver);
			TouchAction a1 = new TouchAction((MobileDriver) driver).longPress(x1, y1).waitAction(1500);
			TouchAction a2 = new TouchAction((MobileDriver) driver).longPress(x2, y2).waitAction(1500);
			TouchAction a3 = new TouchAction ((MobileDriver) driver).longPress(x3, y3).waitAction(1500);
			TouchAction a4 = new TouchAction((MobileDriver) driver).longPress(x4, y4).waitAction(1500);
			TouchAction a5 = new TouchAction ((MobileDriver) driver).longPress(x5, y5).waitAction(1500);
			m.add(a1).add(a2).add(a3).add(a4).add(a5).perform();
			
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
