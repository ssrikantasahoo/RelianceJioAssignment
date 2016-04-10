package com.RelianceJio.srikanta.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Drivers {
	
		public static WebDriver driver;
		private DesiredCapabilities objCapability;
		private  String OS = null;
		
		
		
		
		public WebDriver setWebBrowser(String sBrowserType)
		{
			if(sBrowserType.equals("Firefox") && sBrowserType.equalsIgnoreCase("firefox"))
			{
				driver = setFirefoxBrowser();
			}
			else if(sBrowserType.equals("chrome") && sBrowserType.equalsIgnoreCase("chrome"))
			{
				driver = setChromeBrowser();
			}
			else if(sBrowserType.equals("InternetExplorer") && sBrowserType.equalsIgnoreCase("InternetExplorer"))
			{
				driver = setInternetExplorerBrowser();
			}
			return driver;
			
		}
		
		//This method will invoke InternetExplorer driver
		public WebDriver setInternetExplorerBrowser() 
		{
			if (isthisWindowsOS()) 
			{
				objCapability = DesiredCapabilities.internetExplorer();
				 try {
					driver = new RemoteWebDriver(new URL("http://localhost:5555"), objCapability);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				return driver;
		}
			
		//This method will invoke Firefox driver
		public WebDriver setFirefoxBrowser() 
		{
			driver = new FirefoxDriver();
			return driver;
		}
		
		//This method will invoke chrome driver
		public WebDriver setChromeBrowser() 
		{
			if (isthisWindowsOS()) {
				
				 objCapability = DesiredCapabilities.chrome();
				 objCapability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				 ChromeOptions options = new ChromeOptions();
				 options.addArguments("test-type");
				 objCapability.setCapability(ChromeOptions.CAPABILITY, options);
				 try {
					driver = new RemoteWebDriver(new URL("http://localhost:9515"), objCapability);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			
			return driver;
		}
		
		//This method will invoke Safari driver
		public WebDriver setSafariBrowser() 
		{
				driver = new SafariDriver();
				return driver;
		}
		
		//This method will invoke Android driver with Chrome as Browser
		public WebDriver setAndroidBrowser(String sDeviceName, String sOSVersion, String sServerName) {
			
			objCapability = DesiredCapabilities.android();
			objCapability.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			objCapability.setCapability("deviceName",sDeviceName);
			objCapability.setCapability("platformVersion", sOSVersion);
			objCapability.setCapability("platformName",MobilePlatform.ANDROID);
			objCapability.setCapability("app", "chrome");
	        
	        try {
				driver = new AndroidDriver<MobileElement>(new URL(sServerName), objCapability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return driver;
		}

		//This method will invoke Android driver with Chrome as Browser
		@SuppressWarnings("unchecked")
		public AndroidDriver<MobileElement> setAndroidApp(String sDeviceName, String sOSVersion,String sAppPath,String sPackageName, String sActivityName,String sServerName) {

				File fappPath = new File(sAppPath);
				objCapability = DesiredCapabilities.android();
				objCapability.setCapability("deviceName",sDeviceName);
				objCapability.setCapability("platformVersion", sOSVersion);
				objCapability.setCapability("platformName",MobilePlatform.ANDROID);
				objCapability.setCapability("app", fappPath.getAbsolutePath());
				objCapability.setCapability("appPackage", sPackageName);
				objCapability.setCapability("appActivity", sActivityName);
				objCapability.setCapability(CapabilityType.BROWSER_NAME, "Android");
				objCapability.setCapability("autoWebview", true);
		        
		        try {
					driver = new AndroidDriver<MobileElement>(new URL(sServerName), objCapability);
				} catch (MalformedURLException e) {
				
					e.printStackTrace();
				}
				return (AndroidDriver<MobileElement>) driver;
			}
		@SuppressWarnings("unchecked")
		public IOSDriver<MobileElement> setIPhoneBrowser(String sDeviceName, String sOSVersion,String sServerName,String sUDID) throws MalformedURLException {
			
			
			objCapability = DesiredCapabilities.iphone();
			objCapability.setCapability(CapabilityType.BROWSER_NAME, "safari");
			objCapability.setCapability(CapabilityType.VERSION, sOSVersion);
			objCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			objCapability.setCapability("deviceName", sDeviceName);
			//capabilities.setCapability("udid", sUDID);

	        try {
	        	 driver = new IOSDriver<MobileElement>(new URL(sServerName), objCapability);
	        	 
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (IOSDriver<MobileElement>) driver;
		}
		@SuppressWarnings({ "unchecked"})
		public IOSDriver<MobileElement> setIOSApp(String sDeviceName, String sOSVersion,String sAppPath,String sServerName,String sUDID) {

			File fappPath = new File(sAppPath);
			objCapability = DesiredCapabilities.iphone();
			objCapability.setCapability(CapabilityType.BROWSER_NAME, "safari");
			objCapability.setCapability(CapabilityType.VERSION, sOSVersion);
			objCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			objCapability.setCapability("deviceName", sDeviceName);
			objCapability.setCapability("app", fappPath.getAbsolutePath());

	        try {
				driver = new IOSDriver<MobileElement>(new URL(sServerName), objCapability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (IOSDriver<MobileElement>) driver;
		}
		
		
		public void closeDriver(WebDriver driver) 
		{
				driver.quit();
		}	
		
		
		public static void main(String args[])
		{
			Drivers od = new Drivers();
			WebDriver driver = od.setFirefoxBrowser();
			od.closeDriver(driver);
		}
		
		public  String getOperatingSystem()
		   {
		      if(OS == null) { OS = System.getProperty("os.name"); }
		      return OS;
		   }
		public  boolean isthisWindowsOS()
		   {
		      return getOperatingSystem().startsWith("Windows");
		   }
		public  boolean isthisMacOS()
		   {
		      return getOperatingSystem().startsWith("Mac");
		   }
		public  boolean isthisAndroidOS()
		   {
		      return getOperatingSystem().startsWith("Android");
		   }

}
