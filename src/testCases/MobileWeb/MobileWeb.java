package testCases.MobileWeb;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;

import com.RelianceJio.srikanta.basic.BasicFunctions;
import com.RelianceJio.srikanta.driver.Drivers;


public class MobileWeb {
	
	
	
	Drivers objDriver = new Drivers();
	
	BasicFunctions objBasic = new BasicFunctions();
	
	WebDriver driver = null;
	
	@BeforeClass(groups = {"setUp"})
	@Parameters({"AppEnvironment","DBEnvironment","AppiumRunningAt","MobileVersion","MobileID"})
	public void setUpEnvironment(String sAppEnvironment, String sDBEnvironment,String sAppiumServerRunningAt,String sMobileID, String sMobileVersion) throws IOException
	{
		//objReport.startRecorder();
		driver = objDriver.setAndroidBrowser(sMobileID,sMobileVersion,sAppiumServerRunningAt);
		
		objBasic.openUrlInBrowser(driver, "https://www.google.com/drive/");
		//Setting applciation url ready for testing
	}
	@BeforeMethod
	public void setUp() throws Exception {
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Reliance Jio Assignment";
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
