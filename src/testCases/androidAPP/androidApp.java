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

import com.RelianceJio.srikanta.ui.PageElements;
import com.RelianceJio.srikanta.ui.PageInteraction;
import com.RelianceJio.srikanta.ui.PageWaits;
import com.RelianceJio.srikanta.ui.UIAssert;

public class androidApp {
	
	Drivers objDriver = new Drivers();
	
	BasicFunctions objbasic = new BasicFunctions();
	PageInteraction objPageInteract = new PageInteraction();
    UIAssert objAssert = new UIAssert();
	PageWaits objwait = new PageWaits();
	PageElements pagEle = new PageElements();
	
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass(groups = { "setUp"})
	@Parameters({"AppEnvironment","DBEnvironment","MobileID","MobileVersion","AppPath","PacKageName","ActivityName","AppiumRunningAt","url"})
	public void setUpEnvironment(String sAppEnvironment, String url, String sDBEnvironment, String MobileID,String MobileVersion,String AppPath, String PacKageName,String ActivityName,
			String AppiumRunningAt) throws IOException
	{
		
		driver = objDriver.setAndroidApp(MobileID, MobileVersion, AppPath, PacKageName, ActivityName, AppiumRunningAt);
		//Setting applciation url ready for testing
		objbasic.openUrlInBrowser(driver, url);
		
	}
	@Test(priority=0, alwaysRun=true, successPercentage =100)
	public void test_TestCase1() 
	{
		
		try{
			pagEle.byId(driver, "identifierId").sendKeys("srikantareljio");
			pagEle.byId(driver, "identifierNext").click();
			pagEle.byId(driver, "password").sendKeys("123sri45");
			pagEle.byId(driver, "passwordNext").click();
			pagEle.byName(driver, "ACCEPT").click();
			pagEle.byId(driver, "com.google.android.gms:id/suw_navbar_more").click();
			pagEle.byId(driver, "com.google.android.gms:id/suw_navbar_next").click();
			objwait.setIWaitS(driver, 10);

			  }catch(Exception e){
			   
			  }
		pagEle.byId(driver, "com.google.android.apps.docs:id/doclist_create_button").click();
		pagEle.byId(driver, "com.google.android.apps.docs:id/choice_create_upload").click();
		pagEle.byName(driver, "Images").click();
		pagEle.byclassName1(driver, "android.widget.RelativeLayout", 1).click();
		pagEle.byclassName1(driver, "android.view.View", 0).click();
		String test = pagEle.byclassName1(driver, "android.view.View", 0).getText();
		pagEle.byId(driver, "com.google.android.apps.photos:id/done_button").click();
		objAssert.assertEquals(pagEle.byId(driver, "com.google.android.apps.docs:id/doc_entry_root").getText(),test );
		objwait.setIWaitS(driver, 10);
		
	}

	@Test(priority=1, alwaysRun=true, successPercentage =100)
	public void test_TestCasecrossplatform() 
	{
		pagEle.byclassName(driver, "android.widget.ImageButton").click();
		pagEle.byclassName1(driver, "android.widget.LinearLayout",3).click();
		pagEle.byId(driver, "com.google.android.apps.docs:id/doc_entry_root").click();
		pagEle.byId(driver, "com.google.android.apps.docs:id/open_detail_panel").click();
		pagEle.byId1(driver, "com.google.android.apps.docs:id/menu_icon",6).click();
		pagEle.byId(driver, "com.google.android.apps.docs:id/new_name").sendKeys("test.jpg");
		pagEle.byId(driver, "android:id/button1").click();
		
	}
	
	@Test(priority=1, alwaysRun=true, successPercentage =100)
	public void test_TestCasewith_noNetwork() 
	{
		NetworkConnectionSetting n = new NetworkConnectionSetting(false, false, true);
		driver.setNetworkConnection(n);
		pagEle.byId(driver, "com.google.android.apps.docs:id/doclist_create_button").click();
		pagEle.byId(driver, "com.google.android.apps.docs:id/choice_create_upload").click();
		pagEle.byName(driver, "Images").click();
		pagEle.byclassName1(driver, "android.widget.RelativeLayout", 1).click();
		pagEle.byclassName1(driver, "android.view.View", 0).click();
		objwait.setIWaitS(driver, 10);
		driver.openNotifications();
		
		objAssert.assertEquals(pagEle.byId(driver, "com.google.android.apps.docs:id/offline_status").getText(),"Waiting for network");
		Reporter.log("");
		
	}
	@AfterClass(groups = {"tearDown"})
	public void tearDown() {
		objDriver.closeDriver(driver);
	}

}
