package testCases.MobileWeb;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RelianceJio.srikanta.basic.BasicFunctions;
import com.RelianceJio.srikanta.driver.Drivers;
import com.RelianceJio.srikanta.feature.Reports;

public class MobileWeb {
	
	Drivers objDriver = new Drivers();
	Reports objReport = new Reports();
	BasicFunctions objBasic = new BasicFunctions();
	
	WebDriver driver = null;
	
	@BeforeClass(groups = {"setUp"})
	@Parameters({"AppEnvironment","DBEnvironment","AppiumRunningAt","MobileVersion","MobileID"})
	public void setUpEnvironment(String sAppEnvironment, String sDBEnvironment,String sAppiumServerRunningAt,String sMobileID, String sMobileVersion) throws IOException
	{
		//objReport.startRecorder();
		driver = objDriver.setAndroidBrowser(sMobileID,sMobileVersion,sAppiumServerRunningAt);
		objReport.writeTestReports(driver);
		objBasic.openUrlInBrowser(driver, "https://www.google.com/drive/");
		//Setting applciation url ready for testing
	}
	
	@Test(priority=21, alwaysRun=true,  successPercentage =100)
	public void test_1_TestCase1() 
	
	{
		
	}
	
	@AfterClass(groups = {"tearDown"})
	public void tearDown() {
		objDriver.closeDriver(driver);
		
	}

}
