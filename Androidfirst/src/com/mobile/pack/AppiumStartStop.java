package com.mobile.pack;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppiumStartStop {
	static AndroidDriver driver;
	String nodePath = "D:/Appium/node.exe";
	String appiumJSPath = "D:/Appium/node_modules/appium/bin/appium.js";
	
	public void appiumStart()throws IOException, InterruptedException
	{
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/d");
		command.addArgument(nodePath);
		command.addArgument(appiumJSPath);
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no reset");
		command.addArgument("--log");
		command.addArgument("D://appiumLogs.txt");
		DefaultExecuteResultHandler resulthandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resulthandler);	
	}
	
	public void appiumStop() throws IOException
	{
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/d");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		DefaultExecuteResultHandler resulthandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resulthandler);
	}
	
	@BeforeTest
	public void setup() throws Exception
	{	
		System.out.println("---- Starting appium server ----");
		appiumStart();
		System.out.println("---- Appium server started Successfully ! ----");
		Thread.sleep(2000L);
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "ZX1B325TV4");
		c.setCapability("platformName", "Android");
		c.setCapability("browserName", "Android");
		c.setCapability("platformVersion", "5.1");
		c.setCapability("appPackage", "io.appium.android.apis");
		c.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), c);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void scrollTab()
	{
		driver.scrollTo("Views");
		driver.findElementByName("Views").click();
	}
	
	@AfterTest
	public void end()throws IOException
	{
		driver.quit();
		appiumStop();
		
	}
}
