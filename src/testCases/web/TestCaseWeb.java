package testCases.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

import com.RelianceJio.srikanta.basic.BasicFunctions;
import com.RelianceJio.srikanta.driver.Drivers;
import com.RelianceJio.srikanta.feature.Reports;
import com.RelianceJio.srikanta.ui.*;

public class TestCaseWeb {
	
	WebDriver driver;
	
	
	
	Drivers objDriver = new Drivers();
	Reports objReport = new  Reports();
	BasicFunctions objbasic = new BasicFunctions();
	PageInteraction objPageInteract = new PageInteraction();
    UIAssert objAssert = new UIAssert();
	PageWaits objwait = new PageWaits();
	PageElements pagEle = new PageElements();
	
	@BeforeClass(groups = {"setUp"})
//	@Parameters({"url","browser"})
//	public void setUpEnvironment(String browser,String url) throws IOException
//	{
	
	public void setUpEnvironment() throws IOException
		{
		//driver = objDriver.setWebBrowser(browser);
		driver = objDriver.setWebBrowser("firefox");
		driver = objDriver.setFirefoxBrowser();
		objReport.writeTestReports(driver);
		objReport.startRecorder();
		try {
			objbasic.clearCookies(driver);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
//		objbasic.openUrlInBrowser(driver, url);
		objbasic.openUrlInBrowser(driver, "https://www.google.com/drive/");
		objwait.setIWaitS(driver, 10);
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

   @Test(priority=0, alwaysRun=true, successPercentage =100)
	public void test_1_TestCase2()
	{
	   objwait.setIWaitS(driver, 10);
	   pagEle.byCSSPath(driver, "#Passwd").sendKeys("123sri45");
	   pagEle.byCSSPath(driver, "#signIn").click();
	   objwait.setIWaitS(driver, 10);
	 
	   pagEle.byCSSPath(driver, "div[guidedhelpid=\"new_menu_button\"]").click();
	   pagEle.byId(driver, ".//*[@id=':5f']/div/span[2]/span[1]/div").sendKeys(System.getProperty("user.dir")+"\\lib\\add product.jpg");
	   objwait.setIWaitS(driver, 10);
	   objAssert.assertEquals( pagEle.byCSSPath(driver, ".lc-M").getText(),"1 upload complete");
	   objwait.setIWaitS(driver, 10);
	}
   @Test(priority=0, alwaysRun=true, successPercentage =100)
  	public void test_1_crossplatform()
  	{
	   pagEle.byXpath(driver, ".//*[@id='gbqfqwb']/table/tbody/tr/td").sendKeys("test.jpg");
	   pagEle.byXpath(driver, ".//*[@id='gbqfb']").click();
	   objAssert.assertEquals( pagEle.byXpath(driver, ".//*[@id=':9j.0ByC_66XJxPtTR1hQbTd1MWZ3RDA']/div[2]/div[3]/div/div[3]").getText(),"test.jpg");
	   
  	}
	
   @AfterClass(groups = {"tearDown"})
	public void tearDown()
	{
	   objDriver.closeDriver(driver);
	   objReport.stopRecorder();
	}

}
