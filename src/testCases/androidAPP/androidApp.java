package testCases.androidAPP;


import io.appium.java_client.MobileElement;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RelianceJio.srikanta.basic.BasicFunctions;
import com.RelianceJio.srikanta.driver.Drivers;
import com.RelianceJio.srikanta.feature.Reports;

public class androidApp {
	
	Drivers objDriver = new Drivers();
	Reports objReports = new Reports();
	BasicFunctions objbasic = new BasicFunctions();
	
	
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass(groups = { "setUp"})
	@Parameters({"AppEnvironment","DBEnvironment","MobileID","MobileVersion","AppPath","PacKageName","ActivityName","AppiumRunningAt","url"})
	public void setUpEnvironment(String sAppEnvironment, String url, String sDBEnvironment, String MobileID,String MobileVersion,String AppPath, String PacKageName,String ActivityName,
			String AppiumRunningAt) throws IOException
	{
		objReports.writeTestReports(driver);
		driver = objDriver.setAndroidApp(MobileID, MobileVersion, AppPath, PacKageName, ActivityName, AppiumRunningAt);
		//Setting applciation url ready for testing
		objbasic.openUrlInBrowser(driver, url);
		
	}
	@Test(priority=0, alwaysRun=true, successPercentage =100)
	public void test_TestCase1() 
	{
		
		Reporter.log("");
		
	}
	
	@Test(priority=1, alwaysRun=true, successPercentage =100)
	public void test_TestCase2() 
	{
		NetworkConnectionSetting n = new NetworkConnectionSetting(false, false, true);
		driver.setNetworkConnection(n);
		Reporter.log("");
		
	}
	@AfterClass(groups = {"tearDown"})
	public void tearDown() {
		objDriver.closeDriver(driver);
	}

}
