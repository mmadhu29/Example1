package Framework;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 


public class Utilities {
	public boolean isElementPresent(Browser browser, By by) {
		try {
			browser.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	public boolean isPageTitleMatching(
			Browser browser, String Title) {
		try {
			if (browser.driver.getTitle().contains(Title)) {
				System.out.println("Page Verification Pass");
				return true;
				
			} else {
				return false;
			}
		} catch (Exception NoPageTitleException) {
			return false;
		}
	}
	public static void waitForProcessingBar(Browser browser,int timeout) {
		try {
			int iwaitTime = 0;
			do {
				Thread.sleep(1000);
				
				if (++iwaitTime > 100) {
					break;
				}
			} while ((new Utilities()).isElementPresentByXpath(browser,"//div[@class='modal-backdrop fade in']"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void waitforAJAX(Browser browser) {
		int i = 0;

		String idString = "loading-bar-spinner";
		try{
			while (browser.driver.findElement(By.id(idString)).isDisplayed()) {
						try {
							if (i > 25) {
								break;
							}
							//System.out.println("Inside Search " + i);
							Thread.sleep(2 * 1000);
							i++;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
		}
		catch(NoSuchElementException e){
		}
	} 
	public WebElement FindElementById(
		Browser browser, String id) {
	try
	{
		WebElement element;
		element = browser.driver.findElement(By.id(id));
		return element;
	}catch (Exception e)
	{
		throw e;
	}

	}
	public WebElement FindElementByName(Browser browser, String name) {
	try
	{
		WebElement element;
		element = browser.driver.findElement(By.name(name));
		return element;
	}catch (Exception e)
	{
		throw e;
	}
	}
	public WebElement FindElementByXpath(Browser browser, String Xpath) {
		try
		{
			WebElement element;
			element = browser.driver.findElement(By.xpath(Xpath));
			return element;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	public WebElement FindElementByXpathwithwait(Browser browser, String Xpath) {
		try
		{
			WebElement element;
			element = (new WebDriverWait (browser.driver, 1000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			return element;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	public WebElement FindElementBylinktextwithwait(Browser browser, String text) {
		try
		{
			WebElement element;
			element = (new WebDriverWait (browser.driver, 50)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
			return element;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	public WebElement FindElementBypartiallinktextwithwait(Browser browser, String text) {
		try
		{
			WebElement element;
			element = (new WebDriverWait (browser.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(text)));
			return element;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	public boolean isElementPresentByXpath(
			Browser browser, String xpath) {
		try {
			browser.driver.findElement(By.xpath(xpath));
			
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
		
		
	} 
	public static void highlightElement(Browser browser,WebElement element) {
		try {
			for (int i = 0; i < 8; i++) {
				JavascriptExecutor js = (JavascriptExecutor) browser.driver;
				js.executeScript(
						"arguments[0].setAttribute('style', arguments[1]);",
						element, "color: red; border: 4px solid red;");
				js.executeScript(
						"arguments[0].setAttribute('style', arguments[1]);",
						element, "");
			}
		} catch (Exception e) {
			// System.out.println("Error in highlighting element");
		}
	}
	// Check page source
	public boolean isTextPresentInPageSource(Browser browser, String targetText)
	{
		try
		{
			if(browser.driver.getPageSource().contains(targetText))
			{
				return true;
			}
			else
				return false;
			
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	public boolean  validateInfo(Browser browser, String textToBeValidated, String Xpath,
			String validationString)
//	: ExcelRow #: " + properties.currentRow + " -- " +
//	properties.TestCaseID +" -- "+ properties.CalcGroup +" -- "+ properties.WeekStartDate + " "
	{
		WebElement element = browser.driver.findElement(By.xpath(Xpath));
		//Assert.assertTrue(element.getText().contains(textToBeValidated),validationString);
		if (element.getText().contains(textToBeValidated))
		{
			return true;
		}
		else
			return false;
		
	}
	public boolean  validateInfoElementValue(Browser browser, String textToBeValidated, String Xpath,
			String validationStringElement)
	{
		WebElement element = browser.driver.findElement(By.xpath(Xpath));
		//Assert.assertTrue(element.getAttribute("value").contains(textToBeValidated), validationStringElement);
		if (element.getText().contains(textToBeValidated))
		{
			return true;
		}
		else
			return false;
		
	}
	public static void screenShot(Browser browser,String moduleName, String Sname) throws Exception 
	{
		try 
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH-mm-ss");
			Date date = new Date();
			String filenamer = "";
			String strTime = dateFormat.format(date);
			String TestReport=System.getProperty("user.dir") + "\\ErrorScreenshots\\";
			File screenshot = ((TakesScreenshot) browser.driver).getScreenshotAs(OutputType.FILE);
			TestReport = TestReport.toLowerCase();
			filenamer = TestReport  + "/" + moduleName + "_"+ Sname+"-"+strTime	+ ".png";
			FileUtils.copyFile(screenshot, new File(filenamer));
		} 
		catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
	
	public int switchOnMonth(Browser browser, String monthCompare)
	{
		int monthDex = 0;
//		System.out.println("MONTHCOMPARE INSIDE SWITCH ON MONTH: " + monthCompare);
        switch (monthCompare) 
        {
            case "January":
                monthDex = 1;
                break;
            case "February":
                monthDex = 2;
                break;
            case "March":
                monthDex = 3;
                break;
            case "April":
                monthDex = 4;
                break;
            case "May":
                monthDex = 5;
                break;
            case "June":
                monthDex = 6;
                break;
            case "July":
                monthDex = 7;
                break;
            case "August":
                monthDex = 8;
                break;
            case "September":
                monthDex = 9;
                break;
            case "October":
                monthDex = 10;
                break;
            case "November":
                monthDex = 11;
                break;
            case "December":
                monthDex = 12;
                break;
            default:
            	monthDex = Integer.valueOf(monthCompare);
            	break;
        }    
		return monthDex;
	}

}
