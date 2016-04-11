package com.mobile.pack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ScrollHTabs {

	AndroidDriver driver;
	Dimension size;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "ZX1B325TV4");
		c.setCapability("platformVersion", "4.4.4");
		c.setCapability("platformName", "Android");
		c.setCapability("browserName", "Android");
		c.setCapability("appPackage", "io.appium.android.apis");
		c.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), c);
	}
	
	@Test
	public void scrollhorizontaltabs()
	{
		try{
			driver.scrollTo("Views");
			driver.findElementByName("Views").click();
			driver.scrollTo("Tabs");
			driver.findElementByName("Tabs").click();
			driver.findElementByName("5. Scrollable").click();
			
			for (int i=0; i< 10; i++)
			{
				if (driver.findElementsByName("Tab 11").size()!=0)
				{
					driver.findElementByName("Tab 11").click();
					break;
				}
				else
				{
					scrolltabs();
				}
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement ele1 = (WebElement) driver.findElementsById("android:id/tabs").get(0);
			WebElement ele2 = ele1.findElement(arg0)
			
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void scrolltabs()
	{
		try{
			size = driver.manage().window().getSize();
			int startx = (int) (size.width *0.70);
			int endx = (int) (size.width * 0.30);
			int starty = 150;
			driver.swipe(startx, starty, endx, starty, 3000);
			
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
