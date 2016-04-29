package com.mobile.pack;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerStartStop {
	
	static AndroidDriver driver;
	static String Appium_Node_Path="D:\\Appium\\node.exe";
    static String Appium_JS_Path="D:\\Appium\\node_modules\\appium\\bin\\appium.js";
    static AppiumDriverLocalService service;
    static String service_url;

    public static void appiumStart() throws Exception{
        service = AppiumDriverLocalService
        		.buildService(new AppiumServiceBuilder()
        		.usingPort(4723)
        		.usingDriverExecutable(new File(Appium_Node_Path))
        		.withAppiumJS(new File(Appium_JS_Path))
        		.withIPAddress("127.0.0.1"));
        service.start();
        Thread.sleep(25000);
        service_url = service.getUrl().toString();
    }

    public static void appiumStop() throws Exception
    {
        service.stop();
    }
    
	@BeforeTest
	public void setup() throws Exception
	{	
		System.out.println("---- Starting appium server ----");
		appiumStart();
		System.out.println("---- Appium server started Successfully ! ----");
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "ZX1B325TV4");
		c.setCapability("platformName", "Android");
		c.setCapability("browserName", "Android");
		c.setCapability("platformVersion", "5.1");
		c.setCapability("appPackage", "io.appium.android.apis");
		c.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL(service_url), c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	
	
	@Test
	public void scrollTab()
	{
		driver.scrollTo("Views");
		driver.findElementByName("Views").click();
	}
	
	@AfterTest
	public void end()throws Exception
	{
		driver.quit();
		appiumStop();
		
	}

}
