package com.RelianceJio.srikanta.GRID;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RelianceJio.srikanta.basic.BasicFunctions;
import com.RelianceJio.srikanta.driver.Drivers;

import com.RelianceJio.srikanta.ui.PageElements;
import com.RelianceJio.srikanta.ui.PageInteraction;
import com.RelianceJio.srikanta.ui.PageWaits;
import com.RelianceJio.srikanta.ui.UIAssert;

public class seleniumGrid {
	
	Drivers objDriver = new Drivers();
	
	BasicFunctions objbasic = new BasicFunctions();
	PageInteraction objPageInteract = new PageInteraction();
    UIAssert objAssert = new UIAssert();
	PageWaits objwait = new PageWaits();
	PageElements pagEle = new PageElements();
	
	WebDriver driver = null; 
	
	
	@Parameters({ "platform", "browser", "url" }) 
	@BeforeTest(alwaysRun = true) 
	 public void setup(String platform, String browser, String url) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities(); 
		if (platform.equalsIgnoreCase("MAC"))
			caps.setPlatform(org.openqa.selenium.Platform.MAC);
		if (platform.equalsIgnoreCase("WINDOWS"))
			caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		if (platform.equalsIgnoreCase("WINDOWS")&&browser.equalsIgnoreCase("internetexplorer")) 
			caps = DesiredCapabilities.internetExplorer(); 
		if (platform.equalsIgnoreCase("MAC")&&browser.equalsIgnoreCase("safari")) 
			caps = DesiredCapabilities.safari(); 
		if (browser.equalsIgnoreCase("Firefox")) 
			caps = DesiredCapabilities.firefox(); 
		if (browser.equalsIgnoreCase("chrome")) 
			caps = DesiredCapabilities.chrome(); 
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps); 
		
		objwait.setIWaitS(driver, 10);
		driver.manage().window().maximize();
		objbasic.openUrlInBrowser(driver, url);
		
	}
	@Test(priority=0, alwaysRun=true, successPercentage =100)
	public void test_1_TestCase1()
	{
	  
	   objwait.setIWaitS(driver, 10);
	   pagEle.byCSSPath(driver, "a[data-g-label=\"Go to Google Drive\"][class=\"maia-button button-download mobile-is-hidden get-started go-to-drive\"]").click();
	   
	   pagEle.byCSSPath(driver, "#Email").sendKeys("srikantareljio");
	   pagEle.byCSSPath(driver, "#next").click();
	   pagEle.byCSSPath(driver, "#Passwd").sendKeys("123456");
	   pagEle.byCSSPath(driver, "#signIn").click();
	   objAssert.assertEquals( pagEle.byCSSPath(driver, "#errormsg_0_Passwd").getText(),"The email and password you entered don't match.");
	   objwait.setIWaitS(driver, 10);
	}
	  
	
   @AfterClass(groups = {"tearDown"})
	public void tearDown()
	{
	   objDriver.closeDriver(driver);
	   
	}

		
	}

