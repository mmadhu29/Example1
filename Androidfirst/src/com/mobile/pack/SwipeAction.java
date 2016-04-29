package com.mobile.pack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class SwipeAction {
	
	AndroidDriver driver;
	Dimension size;
	WebDriverWait wait;
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "Android Emulator");
		c.setCapability("browserName", "Android");
		c.setCapability("plaformName", "Android");
		c.setCapability("plaformVersion", "5.1.1");
		c.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		c.setCapability("appActivity", "com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
		driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	}
	
	@Test
	public void swipeact()
	{
		size = driver.manage().window().getSize();
		int x1 = (int) (size.width * 0.20);
		int x2 = (int) (size.width * 0.80);
		WebElement ele1 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/front").get(3);
		TouchAction action = new TouchAction ((MobileDriver) driver);
		action.longPress(ele1).moveTo(x1, 288).perform().release();
		
		WebElement ele2 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/back").get(3);
		action.longPress(ele2).moveTo(x2, 288).perform().release();
	}
	
	@AfterTest
	public void end()
	{
		driver.quit();
	}
}
