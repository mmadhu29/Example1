package com.mobile.pack;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragandDrop {
	
	AndroidDriver driver;
	@BeforeTest
	public void setup()throws MalformedURLException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/App");
		File app = new File(appDir, "com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk"); 
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "Android Emulator");
		c.setCapability("browserName", "Android");
		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "5.1.1");
		c.setCapability("app", app.getAbsolutePath());
		c.setCapability("appPackage", "com.mobeta.android.demodslv"); 
		c.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	@Test
	public void dragDrop()
	{
		try{
			driver.findElementByName("Basic usage playground").click();
			WebElement ele1 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);
			WebElement ele2 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);
			TouchAction action = new TouchAction((MobileDriver) driver); 
			System.out.println("It Is dragging element.");
			action.longPress(ele1).moveTo(ele2).release().perform(); 
			System.out.println("Element has been droped at destination successfully.");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
