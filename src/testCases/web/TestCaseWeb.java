package testCases.web;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import com.RelianceJio.srikanta.basic.BasicFunctions;
import com.RelianceJio.srikanta.driver.Drivers;
import com.RelianceJio.srikanta.ui.*;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
    MethodListener.class })
public class TestCaseWeb {
	{
		System.setProperty("atu.reporter.config", "C:\\Users\\user\\workspace\\RelianceJioAssignment\\config\\atu.properties");
		
	}
	
	WebDriver driver;
	
	ATUTestRecorder recorder;
	
	Drivers objDriver = new Drivers();
	
	BasicFunctions objbasic = new BasicFunctions();
	PageInteraction objPageInteract = new PageInteraction();
    UIAssert objAssert = new UIAssert();
	PageWaits objwait = new PageWaits();
	PageElements pagEle = new PageElements();
	
	
	@BeforeClass(groups = {"setUp"})
//	@Parameters({"url","browser"})
//	public void setUpEnvironment(String browser,String url) throws IOException
//	{
	
	public void setUpEnvironment() throws IOException, ATUTestRecorderException
		{
		

        recorder = new ATUTestRecorder("C:/Users/user/workspace/RelianceJioAssignment/ScriptVideos","reliancejio.mov",false);
        recorder.start(); 
       
		
		//driver = objDriver.setWebBrowser(browser);
		driver = objDriver.setWebBrowser("firefox");
		driver = objDriver.setFirefoxBrowser();
		driver.manage().window().maximize();
		
		try {
			objbasic.clearCookies(driver);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
//		objbasic.openUrlInBrowser(driver, url);
		objbasic.openUrlInBrowser(driver, "https://www.google.com/drive/");
		
		objwait.setIWaitS(driver, 10);
		
		
	}
	
	
	@BeforeMethod
	public void Stratreporting() throws IOException, ATUTestRecorderException
	{
		// ATU Reports Method
				ATUReports.setWebDriver(driver);
				ATUReports.indexPageDescription = "Reliance Jio Assignment";
	}
	

   @Test(priority=0, alwaysRun=true, successPercentage =100)
	public void InvalidLogin()
	{
	   ATUReports.setAuthorInfo("Srikanta Kumar Sahoo", Utils.getCurrentTime(), "1.0");
	   
	   objwait.setIWaitS(driver, 10);
	   
	   ATUReports.add("Click on google drive icon", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
		
	   pagEle.byCSSPath(driver, "a[data-g-label=\"Go to Google Drive\"][class=\"maia-button button-download mobile-is-hidden get-started go-to-drive\"]").click();
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   ATUReports.add("enter email address in email textbox", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   pagEle.byCSSPath(driver, "#Email").sendKeys("srikantareljio");
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   ATUReports.add("Click on next button ", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   pagEle.byCSSPath(driver, "#next").click();
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   ATUReports.add("enter invalid password in password textbox", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   pagEle.byCSSPath(driver, "#Passwd").sendKeys("123456");
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   ATUReports.add("Click on signin button ", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   pagEle.byCSSPath(driver, "#signIn").click();
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   ATUReports.add("Check assertTrue", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   objAssert.assertEquals( pagEle.byCSSPath(driver, "#errormsg_0_Passwd").getText(),"The email and password you entered don't match.");
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   ATUReports.add("Wait for 10 sec", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   objwait.setIWaitS(driver, 10);
	}

   @Test(priority=0, alwaysRun=true, successPercentage =100)
	public void ValidLogin()
	{
	   ATUReports.setAuthorInfo("Srikanta Kumar Sahoo", Utils.getCurrentTime(), "1.0");
	   objwait.setIWaitS(driver, 10);
	   ATUReports.add("enter valid password in password textbox", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   pagEle.byCSSPath(driver, "#Passwd").sendKeys("123sri45");
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   ATUReports.add("Click on signin button ", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   pagEle.byCSSPath(driver, "#signIn").click();
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	   objwait.setIWaitS(driver, 10);
	   ATUReports.add("Check assertTrue", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	   objAssert.assertEquals( pagEle.byCSSPath(driver, ".a-Lb-Rp-P").getText(),"Drive");
	   ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	  
	   
	}
   @Test(priority=0, alwaysRun=true, successPercentage =100)
	public void uploadimage() throws InterruptedException, AWTException
	{
	   ATUReports.setAuthorInfo("Srikanta Kumar Sahoo", Utils.getCurrentTime(), "1.0");
	   
	   ATUReports.add("Click on new button", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	     pagEle.byXpath(driver, ".//*[@id='drive_main_page']/div[4]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div").click();
	     ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.DESKTOP));
	     ATUReports.add("wait for dropdown display", LogAs.INFO, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
	     objwait.setIWaitS(driver, 20);
	     ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.DESKTOP));
	     ATUReports.add("Click on upload from dropdown", LogAs.INFO, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
	     Actions action= new Actions(driver);
	     action.contextClick(pagEle.byXpath(driver, ".//*[@id='drive_main_page']/div[4]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div")).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	     ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.DESKTOP));
	     ATUReports.add("wait for system windows to display", LogAs.INFO, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
	     Thread.sleep(10000l);
	     ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.DESKTOP));
	     if(objDriver.isthisWindowsOS()){
	     ATUReports.add("enter path of image in syatem windows", LogAs.INFO, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
	     
	     StringSelection ss = new StringSelection("C:\\Users\\user\\workspace\\RelianceJioAssignment\\lib\\addproduct.jpg");
     	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
     	ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
     	 ATUReports.add("Click on open button in system windows", LogAs.INFO, new CaptureScreen(
 				ScreenshotOf.BROWSER_PAGE));
     	
     	
     	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_V);
    	robot.keyRelease(KeyEvent.VK_V);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	robot.delay(500);
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	robot.delay(2000);
     	}else{
     		File file = new File("");
            
            StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
     	   //Copy to clipboard
            
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
             
            Robot robot = new Robot();
             
            // Cmd + Tab is needed since it launches a Java app and the browser looses focus
             
            robot.keyPress(KeyEvent.VK_META);
             
            robot.keyPress(KeyEvent.VK_TAB);
             
            robot.keyRelease(KeyEvent.VK_META);
             
            robot.keyRelease(KeyEvent.VK_TAB);
             
            robot.delay(500);
             
            //Open Goto window
             
            robot.keyPress(KeyEvent.VK_META);
             
            robot.keyPress(KeyEvent.VK_SHIFT);
             
            robot.keyPress(KeyEvent.VK_G);
             
            robot.keyRelease(KeyEvent.VK_META);
             
            robot.keyRelease(KeyEvent.VK_SHIFT);
             
            robot.keyRelease(KeyEvent.VK_G);
             
            //Paste the clipboard value
             
            robot.keyPress(KeyEvent.VK_META);
             
            robot.keyPress(KeyEvent.VK_V);
             
            robot.keyRelease(KeyEvent.VK_META);
             
            robot.keyRelease(KeyEvent.VK_V);
             
            //Press Enter key to close the Goto window and Upload window
             
            robot.keyPress(KeyEvent.VK_ENTER);
             
            robot.keyRelease(KeyEvent.VK_ENTER);
             
            robot.delay(500);
             
            robot.keyPress(KeyEvent.VK_ENTER);
             
            robot.keyRelease(KeyEvent.VK_ENTER);
     	}
    	ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
    	 ATUReports.add("wait for complete the upload", LogAs.INFO, new CaptureScreen(
 				ScreenshotOf.BROWSER_PAGE));
    	objwait.setEWait(driver, "cssSelector", "span[class=\"lc-M\"]", 30);
       
    	ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
		 objwait.setIWaitS(driver, 20); 
	}
 @Test(priority=0, alwaysRun=true, successPercentage =100)
	public void verifyuploadimage() throws InterruptedException
	{
	 ATUReports.setAuthorInfo("Srikanta Kumar Sahoo", Utils.getCurrentTime(), "1.0");
	 ATUReports.add("Wait for upload image", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	 objwait.setEWait(driver, "cssSelector", ".k-ta-P-x", 30);
	 ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	 ATUReports.add("Check assertTrue", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	 objAssert.assertEquals( pagEle.byCSSPath1(driver, ".k-ta-P-x",2).getText(),"addproduct.jpg");
	  ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	  objwait.setIWaitS(driver, 10);

	}


	
   @AfterClass(groups = {"tearDown"})
	public void tearDown() throws ATUTestRecorderException
	{
	   objDriver.closeDriver(driver);
	   recorder.stop();
	   
	 	}
}

