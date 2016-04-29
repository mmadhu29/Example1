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

public class driverSwipe {

	AndroidDriver driver;
	Dimension size;
	@BeforeTest
	public void setup() throws MalformedURLException{
		
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "Android Emulator");
		c.setCapability("browserName", "Android");
		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "5.1.1");
		c.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		c.setCapability("appActivity", "com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
		driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, 300);
		w.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	}
	
	@Test
	public void swipinghorizontal()
	{
		try{
			size = driver.manage().window().getSize();
			System.out.println(size);
			int startx = (int) (size.width * 0.70);
			int endx = (int)(size.width * 0.30);
			int starty = size.height/2;
			System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
			driver.swipe(startx, starty, endx, starty, 3000);
			Thread.sleep(2000);
			driver.swipe(endx, starty, startx, starty, 3000);
			Thread.sleep(2000);
	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void swipingveritcal()
	{
		try{
			size = driver.manage().window().getSize();
			int starty = (int)(size.height * 0.80);
			int endy = (int)(size.height * 0.20);
			int startx = size.width/2;
			driver.swipe(startx, starty, startx, endy, 3000);
			Thread.sleep(2000);
			driver.swipe(startx, endy, startx, starty, 3000);
			Thread.sleep(2000);
			
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
