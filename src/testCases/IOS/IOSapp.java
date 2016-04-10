package testCases.IOS;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RelianceJio.srikanta.basic.BasicFunctions;
import com.RelianceJio.srikanta.driver.Drivers;
import com.RelianceJio.srikanta.feature.Reports;

public class IOSapp {

	Drivers objDriver = new Drivers();
	Reports objReports = new Reports();
	BasicFunctions objbasic = new BasicFunctions();
	
	
	IOSDriver<MobileElement> driver = null;
	
	@BeforeClass(groups = { "setUp"})
	@Parameters({"DeviceName","OSVersion","AppPath","ServerName","UDID","AppiumRunningAt","url"})
	public void setUpEnvironment(String sDeviceName, String url, String sOSVersion, String sAppPath,String sServerName,String sUDID,
			String AppiumRunningAt) throws IOException
	{
		objReports.writeTestReports(driver);
		driver = objDriver.setIOSApp(sDeviceName, sOSVersion, sAppPath, sServerName, sUDID);
		//Setting applciation url ready for testing
		objbasic.openUrlInBrowser(driver, url);
	}
	
	@Test(priority=0, alwaysRun=true, successPercentage =100)
	public void test_TestCase1() 
	{
		Reporter.log("");
		
	}
	@AfterClass(groups = {"tearDown"})
	public void tearDown() {
		objDriver.closeDriver(driver);
	}
}
